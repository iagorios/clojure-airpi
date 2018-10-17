(ns clojure-airpi.db.aircrafts)

(defonce aircrafts (atom {}))

(defn insert-aircraft!
  "Inserts an aircraft to the atom and return it"
  [aircraft]
  (do
    (swap! aircrafts conj aircraft)
    aircraft))

(defn read-all
  "Returns all aircrafts registered"
  []
  @aircrafts)

(defn reset-db!
  "Only used on tests"
  []
  reset! aircrafts {})
