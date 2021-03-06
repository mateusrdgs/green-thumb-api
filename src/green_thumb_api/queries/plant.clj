(ns green-thumb-api.queries.plant)

(def get-all-plants-query
  "SELECT p.uuid as uuid, p.name as name, s.uuid as sunlight, w.uuid as water, t.uuid as toxic
  FROM tb_plant as p
  LEFT JOIN tb_water as w
  ON w.uuid = p.water
  LEFT JOIN tb_toxic as t
  ON t.uuid = p.toxic
  LEFT JOIN tb_plant_sunlight as ps
  ON p.uuid = ps.uuid_plant
  LEFT JOIN tb_sunlight as s
  ON ps.uuid_sunlight = s.uuid
  ORDER BY p.name;")

(def get-plant-by-id-query
  "SELECT p.uuid as uuid, p.name as name, s.uuid as sunlight, w.uuid as water, t.uuid as toxic
  FROM tb_plant as p
  LEFT JOIN tb_water as w
  ON w.uuid = p.water
  LEFT JOIN tb_toxic as t
  ON t.uuid = p.toxic
  LEFT JOIN tb_plant_sunlight as ps
  ON p.uuid = ps.uuid_plant
  LEFT JOIN tb_sunlight as s
  ON ps.uuid_sunlight = s.uuid
  WHERE p.uuid = ?;")

(def get-plants-by-filters-query
  "SELECT p.uuid as uuid, p.name as name, s.text as sunlight, w.text as water, t.text as toxic
  FROM tb_plant as p
  LEFT JOIN tb_water as w
  ON w.uuid = p.water
  LEFT JOIN tb_toxic as t
  ON t.uuid = p.toxic
  LEFT JOIN tb_plant_sunlight as ps
  ON p.uuid = ps.uuid_plant
  LEFT JOIN tb_sunlight as s
  ON ps.uuid_sunlight = s.uuid
  WHERE s.uuid LIKE ?
  AND w.uuid LIKE ?
  AND t.uuid LIKE ?")