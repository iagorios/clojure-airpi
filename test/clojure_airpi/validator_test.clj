(ns clojure-airpi.validator-test
  (:require [midje.sweet :refer :all]
            [clojure-airpi.validator :as validator]))

(def airbus319 {:msn "546"
                :type "319-114"
                :airline "Air Canada"
                :first-flight "25/08/1995"
                :registration "C-GBIP"
                :status "Active"})

(def broken-aircraft {:msn "546"
                      :type "319-114"
                      :airline "Air Canada"})

(facts "All required fields should be present"
  (fact "should return true"
   (validator/validate-aircraft airbus319) => true)

  (fact "should return false"
   (validator/validate-aircraft broken-aircraft) => false))
