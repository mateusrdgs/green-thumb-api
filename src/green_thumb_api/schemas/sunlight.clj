(ns green-thumb-api.schemas.sunlight
  (:require [schema.core :as s]))

(s/defschema Sunlight
  {:uuid s/Str
   :amount s/Int
   :text s/Str})