(ns clojure-airpi.handler-test
  (:require [midje.sweet :refer :all]
            [ring.mock.request :as mock]
            [clojure-airpi.handler :refer :all]))

(facts "Hitting API default endpoints"
  (fact "main route"
    (let [response (app (mock/request :get "/"))]
      (:status response) => 200
      (:body response) => "An API built to handle aircrafts information"))

  (fact "should return 404 when a route is not found"
    (let [response (app (mock/request :get "/invalid"))]
      (:status response) => 404)))
