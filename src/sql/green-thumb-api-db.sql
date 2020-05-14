USE green_thumb;

CREATE TABLE tb_sunlight (
    uuid VARCHAR(36) NOT NULL,
    amount INT NOT NULL,
    text VARCHAR(20) NOT NULL,
    PRIMARY KEY (uuid)
);

CREATE TABLE tb_water (
    uuid VARCHAR(36) NOT NULL,
    frequency INT NOT NULL,
    text VARCHAR(20) NOT NULL,
    PRIMARY KEY (uuid)
);

CREATE TABLE tb_toxic (
    uuid VARCHAR(36) NOT NULL,
    toxic BIT NOT NULL,
    text VARCHAR(20) NOT NULL,
    PRIMARY KEY (uuid)
);

CREATE TABLE tb_plant (
    uuid VARCHAR(36) NOT NULL,
    name VARCHAR(255) NOT NULL,
    sunlight VARCHAR(36) NOT NULL,
    water VARCHAR(36) NOT NULL,
    toxic VARCHAR(36) NOT NULL,
    PRIMARY KEY (uuid)
);

CREATE TABLE tb_plant_sunlight (
    uuid VARCHAR(36) NOT NULL,
    uuid_plant VARCHAR(36) NOT NULL,
    uuid_sunlight VARCHAR(36) NOT NULL,
    PRIMARY KEY (uuid),
    FOREIGN KEY (uuid_plant) REFERENCES tb_plant(uuid),
    FOREIGN KEY (uuid_sunlight) REFERENCES tb_sunlight(uuid)
);

-- INSERT INTO tb_toxic
-- VALUES (uuid(),  0, "No");

-- INSERT INTO tb_toxic
-- VALUES (uuid(),  1, "Yes");

-- INSERT INTO tb_water
-- VALUES (uuid(),  0, "Rarely");

-- INSERT INTO tb_water
-- VALUES (uuid(),  1, "Regularly");

-- INSERT INTO tb_water
-- VALUES (uuid(),  2, "Daily");

-- INSERT INTO tb_sunlight
-- VALUES (uuid(), 0, "No sunlight");

-- INSERT INTO tb_sunlight
-- VALUES (uuid(), 1, "Low sunlight");

-- INSERT INTO tb_sunlight
-- VALUES (uuid(), 2, "High sunlight");

DELIMITER |
  CREATE PROCEDURE insert_plant (
    IN name VARCHAR(255),
    IN sunlight VARCHAR(36),
    IN water VARCHAR(36),
    IN toxic VARCHAR(36)
  )
  BEGIN
    DECLARE plant_uuid VARCHAR(36) DEFAULT uuid();
    DECLARE plant_sunlight_uuid VARCHAR(36) DEFAULT uuid();
    
	INSERT INTO tb_plant
    VALUES (plant_uuid, name, sunlight, water, toxic);
    
    INSERT INTO tb_plant_sunlight
    VALUES (plant_sunlight_uuid, plant_uuid, sunlight);
  END
|

-- SELECT * FROM tb_sunlight;
-- SELECT * FROM tb_water;
-- SELECT * FROM tb_toxic;

-- SUNLIGHT
-- no 7f142dd0-9213-11ea-8d1a-cb234b117414
-- low 7f1ad3ce-9213-11ea-8d1a-cb234b117414
-- high  7f212b48-9213-11ea-8d1a-cb234b117414

-- WATER
-- rarely 85f23ef0-8e7e-11ea-abbf-6094c41c3ee3
-- regularly 8800683e-8e7e-11ea-abbf-6094c41c3ee3
-- daily 89932ea2-8e7e-11ea-abbf-6094c41c3ee3

-- TOXIC
-- no 27e2e282-8e7f-11ea-abbf-6094c41c3ee3
-- yes 296caac0-8e7f-11ea-abbf-6094c41c3ee3

-- CALL insert_plant (
-- 	'Monstera deliciosa',
--     '7f142dd0-9213-11ea-8d1a-cb234b117414',
--     '89932ea2-8e7e-11ea-abbf-6094c41c3ee3',
--     '296caac0-8e7f-11ea-abbf-6094c41c3ee3'
-- );

-- SELECT name, text
-- FROM tb_plant
-- INNER JOIN tb_water
-- ON tb_plant.water = tb_water.uuid;

-- SELECT name, text
-- FROM tb_plant
-- INNER JOIN tb_toxic
-- ON tb_plant.toxic = tb_toxic.uuid;

SELECT p.uuid as uuid, p.name as plant,  s.text as sunlight, w.text as water, t.text as toxic
FROM tb_plant as p
LEFT JOIN tb_water as w
ON w.uuid = p.water
LEFT JOIN tb_toxic as t
ON t.uuid = p.toxic
LEFT JOIN tb_plant_sunlight as ps
ON p.uuid = ps.uuid_plant
LEFT JOIN tb_sunlight as s
ON ps.uuid_sunlight = s.uuid;