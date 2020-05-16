(ns green-thumb-api.routers.sunlight
  (:require
   [compojure.api.sweet :as api]
   [ring.util.http-response :as response]
   [green-thumb-api.schemas.sunlight :refer [Sunlight]]
   [green-thumb-api.controllers.sunlight :refer [get-sunlight]]))

(def sunlight-router
  (api/context "/sunlight"
    []
    :tags ["Sunlight"]

    (api/GET "/"
      []
      :return [Sunlight]
      :summary "Get sunlight options"
      (response/ok (get-sunlight)))))