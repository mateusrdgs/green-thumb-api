 (defproject green-thumb-api "0.1.0-SNAPSHOT"
   :description "FIXME: write description"
   :dependencies [[org.clojure/clojure "1.10.0"]
                  [metosin/compojure-api "2.0.0-alpha30"]
                  [org.clojure/java.jdbc "0.7.11"]
                  [mysql/mysql-connector-java "8.0.20"]
                  [environ "1.2.0"]]
   :ring {:handler green-thumb-api.core/app}
   :uberjar-name "server.jar"
   :profiles {:dev {:dependencies [[javax.servlet/javax.servlet-api "3.1.0"]]
                    :plugins [[lein-ring "0.12.5"]
                              [lein-environ "1.2.0"]]
                    :env {:classname "com.mysql.cj.jdbc.Driver"
                          :subprotocol "mysql"
                          :dbtype "mysql"
                          :dbname "green_thumb"
                          :user "mrodrigues"}}})
