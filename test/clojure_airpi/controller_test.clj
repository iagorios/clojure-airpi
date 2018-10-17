(ns clojure-airpi.controller-test
  (:require [midje.sweet :refer :all]
            [clojure-airpi.controller :as controller]
            [clojure-airpi.helper :as helper])
  (:import [java.util UUID]))

(def airbus319 {:msn "546"
                :type "319-114"
                :airline "Air Canada"
                :first-flight "25/08/1995"
                :registration "C-GBIP"
                :status "Active"})

(def broken-aircraft-input {:msn "546"
                            :type "319-114"
                            :airline "Air Canada"})

(facts "Should return invalid job error"
  (controller/create-aircraft! broken-aircraft-input) => {:error {:message "Invalid aircraft"}})

(facts "Creating aircraft"
  (future-fact "should return the aircraft created with an id"
    (controller/create-aircraft! airbus319) => (just {:123 {:msn uuid?
                                                            :type "319-114"
                                                            :airline "Air Canada"
                                                            :first-flight "25/08/1995"
                                                            :registration "C-GBIP"
                                                            :status "Active"}})))
