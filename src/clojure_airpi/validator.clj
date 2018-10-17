(ns clojure-airpi.validator)

(defn contain-keys? [m & ks]
  (every? #(contains? m %) ks))

(defn validate-aircraft
  [aircraft]
  (contain-keys? aircraft :msn :type :airline :first-flight :registration :status))
