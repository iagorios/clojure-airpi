(ns clojure-airpi.error-test
  (:require [midje.sweet :refer :all]
            [clojure-airpi.error :as error]))

(fact "Should return invalid aircraft error"
  (error/invalid-aircraft) => {:error {:message "Invalid aircraft"}})
