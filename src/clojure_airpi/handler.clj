(ns clojure-airpi.handler
    (:require [compojure.core :refer :all]
              [compojure.handler :as handler]
              [compojure.route :as route]
              [ring.middleware.json :as json]
              [ring.util.response :refer [response]]
              [clojure-airpi.controller :as controller]))

(defroutes app-routes
  (GET "/" [] "An API built to handle aircrafts information")

  (GET "/aircrafts" []
    (response (controller/get-aircrafts)))

  (POST "/aircrafts" {:keys [body]}
    (response (controller/create-aircraft! body)))

  (route/not-found "Not Found"))

(def app
  (-> (handler/api app-routes)
      (json/wrap-json-body {:keywords? true})
      json/wrap-json-response))
