(ns green-thumb-api.routers.plant
  (:require
   [compojure.api.sweet :as api]
   [ring.util.http-response :as response]
   [schema.core :as s]
   [green-thumb-api.schemas.plant :refer [Plant]]
   [green-thumb-api.controllers.plant :refer [get-plants get-plant-by-uuid]]))

(def plants-router
  (api/context "/plant"
    []
    :tags ["Plant"]

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