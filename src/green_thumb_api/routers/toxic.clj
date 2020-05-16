(ns green-thumb-api.routers.toxic
  (:require
   [compojure.api.sweet :as api]
   [ring.util.http-response :as response]
   [green-thumb-api.schemas.toxic :refer [Toxic]]
   [green-thumb-api.controllers.toxic :refer [get-toxic]]))

(def toxic-router
  (api/context "/toxic"
    []
    :tags ["Toxic"]
    
    (api/GET "/"
      []
      :return [Toxic]
      :summary "Get toxicity options"
      (response/ok (get-toxic)))))