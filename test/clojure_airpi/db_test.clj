(ns clojure-airpi.db-test
  (:require [midje.sweet :refer :all]
            [clojure-airpi.db.aircrafts :as db.aircrafts]
            [clojure-airpi.helper :as helper]))

(def airbus319 {:1000 {:msn "546"
                       :type "319-114"
                       :airline "Air Canada"
                       :first-flight "25/08/1995"
                       :registration "C-GBIP"
                       :status "Active"}})

(def saab340 {:2000 {:msn "353"
                      :type "340B"
                      :airline "American Eagle"
                      :first-flight "13/11/1993"
                      :registration "N353SB"
                      :status "Written off"}})

;; Resets the database to avoid undesired results
(helper/reset-aircrafts)

(fact "DB should be empty"
  (db.aircrafts/read-all) => {})

(fact "Should add an aircraft"
  (db.aircrafts/insert-aircraft! airbus319) => {:1000 {:msn "546"
                                                       :type "319-114"
                                                       :airline "Air Canada"
                                                       :first-flight "25/08/1995"
                                                       :registration "C-GBIP"
                                                       :status "Active"}})

(fact "Should add an aircraft"
  (db.aircrafts/insert-aircraft! saab340) => {:2000 {:msn "353"
                                                     :type "340B"
                                                     :airline "American Eagle"
                                                     :first-flight "13/11/1993"
                                                     :registration "N353SB"
                                                     :status "Written off"}})

(fact "Should return all the aircrafts inserted so far"
  (db.aircrafts/read-all) => {:1000 {:msn "546"
                                     :type "319-114"
                                     :airline "Air Canada"
                                     :first-flight "25/08/1995"
                                     :registration "C-GBIP"
                                     :status "Active"},
                              :2000 {:msn "353"
                                     :type "340B"
                                     :airline "American Eagle"
                                     :first-flight "13/11/1993"
                                     :registration "N353SB"
                                     :status "Written off"}})
