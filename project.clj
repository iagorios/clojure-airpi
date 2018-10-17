(defproject clojure-airpi "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.5.1"]
                 [ring/ring-core "1.7.0-RC1"]
                 [ring/ring-json "0.4.0"]
                 [midje "1.9.1"]
                 [cheshire "5.8.0"]]
  :plugins [[lein-ring "0.9.7"]
            [lein-midje "3.2.1"]]
  :ring {:handler clojure-airpi.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}})
