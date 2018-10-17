(ns clojure-airpi.error)

(defn invalid-aircraft []
  "Returned when aircraft provided doesn't contain the expected keys"
  (assoc-in {} [:error] {:message "Invalid aircraft"}))
