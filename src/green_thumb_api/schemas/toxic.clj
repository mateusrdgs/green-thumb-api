(ns green-thumb-api.schemas.toxic
  (:require
   [schema.core :as s]))

(def Toxic
  {:uuid s/Str
   :toxic s/Bool
   :text s/Str})