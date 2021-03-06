(ns green-thumb-api.core
  (:require [compojure.api.sweet :as api]
            [green-thumb-api.routers.sunlight :refer [sunlight-router]]
            [green-thumb-api.routers.water :refer [water-router]]
            [green-thumb-api.routers.plant :refer [plants-router]]
            [green-thumb-api.routers.toxic :refer [toxic-router]]))

(def app
  (api/api
   {:swagger
    {:ui "/"
     :spec "/swagger.json"
     :data {:info {:title "green-thumb-api"
                   :description "Green thumb API documentation"}}}}

   (api/context "/api" []
     :tags ["api"]

     sunlight-router
     water-router
     toxic-router
     plants-router)))
