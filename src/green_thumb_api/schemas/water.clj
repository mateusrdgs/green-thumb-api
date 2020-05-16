(ns green-thumb-api.schemas.water
  (:require
   [schema.core :as s]))

(s/defschema Water
  {:uuid s/Str
   :frequency s/Int
   :text s/Str})