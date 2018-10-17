(ns clojure-airpi.model.aircraft
  (:import [java.util UUID]))

(defn get-new-id
  "Returns a new uuid keyword"
  []
  (keyword (str (UUID/randomUUID))))

(defn set-id
  "Set and UUID to an aircraft to be inserted"
  [aircraft]
  (let [id (get-new-id)]
    (assoc-in {} [id] aircraft)))
