(ns green-thumb-api.controllers.sunlight
  (:require
   [green-thumb-api.database.database :as database]
   [green-thumb-api.queries.sunlight :refer [get-sunlight-query]]))

(defn get-sunlight
  []
  (database/query [get-sunlight-query]))

