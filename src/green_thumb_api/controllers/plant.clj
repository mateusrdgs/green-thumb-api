(ns green-thumb-api.controllers.plant
  (:require
   [green-thumb-api.database.database :as database]
   [green-thumb-api.queries.plant :refer [get-all-plants-query get-plant-by-id-query get-plants-by-filters-query]]))

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

(defn get-plant-by-filters
  "Get a list of plants based on picked filters"
  [sunlight water toxic]
  (let [plant (database/query [get-plants-by-filters-query sunlight water toxic])]
    plant))