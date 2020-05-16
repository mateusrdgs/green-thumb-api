(ns green-thumb-api.routers.water
  (:require
   [compojure.api.sweet :as api]
   [ring.util.http-response :as response]
   [green-thumb-api.schemas.water :refer [Water]]
   [green-thumb-api.controllers.water :refer [get-water]]))

(def water-router
  (api/context "/water"
    []
    :tags ["Water"]
    
    (api/GET "/"
      []
      :return [Water]
      :summary "Get water options"
      (response/ok (get-water)))))