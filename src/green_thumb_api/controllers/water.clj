(ns green-thumb-api.controllers.water
  (:require
   [green-thumb-api.database.database :as database]
   [green-thumb-api.queries.water :refer [get-water-query]]))

(defn get-water
  []
  (database/query [get-water-query]))