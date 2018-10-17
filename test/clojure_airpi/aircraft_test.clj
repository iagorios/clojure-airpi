(ns clojure-airpi.aircraft-test
  (:require [midje.sweet :refer :all]
            [clojure-airpi.model.aircraft :as model.aircraft]
            [clojure-airpi.helper :as helper])
  (:import [java.util UUID]))

(def airbus319 {:msn "546"
                :type "319-114"
                :airline "Air Canada"
                :first-flight "25/08/1995"
                :registration "C-GBIP"
                :status "Active"})

(def aircraft-id (keyword (str (UUID/randomUUID))))

(future-fact "Should give an UUID to an aircraft"
 (model.aircraft/set-id airbus319) => {aircraft-id {:msn "546"
                                                    :type "319-114"
                                                    :airline "Air Canada"
                                                    :first-flight "25/08/1995"
                                                    :registration "C-GBIP"
                                                    :status "Active"}})
