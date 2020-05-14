(ns green-thumb-api.schemas.plants
  (:require [schema.core :as s]))

(s/defschema Plant
  {:uuid s/Str
   :name s/Str
   :sunlight s/Str
   :water s/Str
   :toxic s/Str})