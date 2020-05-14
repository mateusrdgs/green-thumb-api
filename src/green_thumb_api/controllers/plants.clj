(ns green-thumb-api.controllers.plants
  (:require
   [clojure.java.jdbc :as db]
   [green-thumb-api.queries.plants :refer [get-all-plants-query get-plant-by-id-query]]))

(def mysql-db
  {:classname "com.mysql.cj.jdbc.Driver"
   :subprotocol "mysql"
   :dbtype "mysql"
   :dbname "green_thumb"
   :user "root"})

(defn get-plants
  []
  (let [plants (db/query mysql-db [get-all-plants-query])]
    plants))

(defn get-plant-by-uuid
  [id]
  (let [plant (db/query mysql-db [get-plant-by-id-query id])]
    (first plant)))