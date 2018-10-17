(ns clojure-airpi.controller
  (:require [clojure-airpi.db.aircrafts :as db.aircrafts]
            [clojure-airpi.model.aircraft :as model.aircraft]
            [clojure-airpi.error :as error]
            [clojure-airpi.validator :as validator]))

(defn create-aircraft!
  "Creates an aircraft with a new uuid (set by the model)"
  [aircraft]
  (if (not (validator/validate-aircraft aircraft))
    (error/invalid-aircraft)
    (let [new-aircraft (model.aircraft/set-id aircraft)]
      (db.aircrafts/insert-aircraft! new-aircraft))))

(defn get-aircrafts [] (db.aircrafts/read-all))
