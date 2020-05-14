(ns green-thumb-api.core
  (:require [compojure.api.sweet :as api]
            [ring.util.http-response :as response]
            [schema.core :as s]
            [green-thumb-api.routers.plants :refer [plants-router]]))

(s/defschema Pizza
  {:name s/Str
   (s/optional-key :description) s/Str
   :size (s/enum :L :M :S)
   :origin {:country (s/enum :FI :PO)
            :city s/Str}})

(def app
  (api/api
   {:swagger
    {:ui "/"
     :spec "/swagger.json"
     :data {:info {:title "Green-thumb-api"
                   :description "Compojure Api example"}
            :tags [{:name "api", :description "some apis"}]}}}

   (api/context "/api" []
     :tags ["api"]

     plants-router

     (api/GET "/plus" []
       :return {:result Long}
       :query-params [x :- Long, y :- Long]
       :summary "adds two numbers together"
       (response/ok {:result (+ x y)}))

     (api/POST "/sub" []
       :return {:result Long}
       :query-params [x :- Long, y :- Long]
       :summary "subtract a number from another"
       (response/ok {:result (- x y)}))

     (api/POST "/echo" []
       :return Pizza
       :body [pizza Pizza]
       :summary "echoes a Pizza"
       (response/ok pizza)))))
