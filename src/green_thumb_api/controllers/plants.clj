(ns green-thumb-api.controllers.plants
  (:require
   [green-thumb-api.database.database :as database]
   [green-thumb-api.queries.plants :refer [get-all-plants-query get-plant-by-id-query]]))

(defn get-plants
  "Get all plants"
  []
  (let [plants (database/query [get-all-plants-query])]
    plants))

(defn get-plant-by-uuid
  "Get an specific plant based on uuid"
  [id]
  (let [plant (database/query [get-plant-by-id-query id])]
    (first plant)))