(ns clojure-airpi.helper
  (:require [cheshire.core :refer [parse-string generate-string]]
            [ring.mock.request :as mock]
            [clojure-airpi.handler :refer :all]
            [clojure-airpi.db.aircrafts :as db.aircrafts]))

(defn parse-body
  [body]
  (parse-string body true))

(defn wrap-body
  [req]
  (generate-string req))

(defn get-request
  [uri]
  (let [response (app (mock/request :get uri))
        body (parse-body (:body response))]
    body))

(defn post-request
  [uri req]
  (let [response (app (-> (mock/request :post uri)
                          (mock/content-type "application/json")
                          (mock/body (wrap-body req))))
        body (parse-body (:body response))]
    body))

(defn reset-aircrafts [] (db.aircrafts/reset-db!))
