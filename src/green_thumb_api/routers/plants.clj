(ns green-thumb-api.routers.plants
  (:require
   [compojure.api.sweet :as api]
   [ring.util.http-response :as response]
   [schema.core :as s]
   [green-thumb-api.schemas.plants :refer [Plant]]
   [green-thumb-api.controllers.plants :refer [get-plants get-plant-by-uuid]]))

(def plants-router
  (api/context "/plants"
    []
    :tags ["Plants"]

    (api/GET "/"
      []
      :return [Plant]
      :summary "Get all plants"
      (response/ok (get-plants)))

    (api/GET "/:uuid"
      []
      :path-params [uuid :- s/Str]
      :return Plant
      :summary "Get a plant by id"
      (response/ok (get-plant-by-uuid uuid)))))