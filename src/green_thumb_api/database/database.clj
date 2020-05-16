(ns green-thumb-api.database.database
  (:require
   [clojure.java.jdbc :as db]))

(def mysql-db
  {:classname "com.mysql.cj.jdbc.Driver"
   :subprotocol "mysql"
   :dbtype "mysql"
   :dbname "green_thumb"
   :user "root"})

(defn query
  [query]
  (db/query mysql-db query))