(ns green-thumb-api.database.database
  (:require
   [clojure.java.jdbc :as db]
   [environ.core :refer [env]]))

(def mysql-db
  {:classname (env :classname)
   :subprotocol (env :subprotocol)
   :dbtype (env :dbtype)
   :dbname (env :dbname)
   :user (env :user)
   :password (env :password)})

(defn query
  [query]
  (db/query mysql-db query))