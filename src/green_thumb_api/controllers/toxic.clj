(ns green-thumb-api.controllers.toxic
  (:require
   [green-thumb-api.database.database :as database]
   [green-thumb-api.queries.toxic :refer [get-toxic-query]]))

(defn get-toxic
  []
  (database/query [get-toxic-query]))