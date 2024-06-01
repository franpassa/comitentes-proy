-- Inserto países
INSERT INTO comitentes_schema.pais (nombre) VALUES ('Argentina');
INSERT INTO comitentes_schema.pais (nombre) VALUES ('Uruguay');

-- Inserto mercados
INSERT INTO comitentes_schema.mercado (codigo, descripcion, pais_id) VALUES ('DEC', 'DECRYPT', 1);
INSERT INTO comitentes_schema.mercado (codigo, descripcion, pais_id) VALUES ('BIN', 'BINANCE', 2);
INSERT INTO comitentes_schema.mercado (codigo, descripcion, pais_id) VALUES ('TOT', 'TOTAL', 2);
INSERT INTO comitentes_schema.mercado (codigo, descripcion, pais_id) VALUES ('PET', 'PETROBRAS', 1);

-- Inserto comitentes
INSERT INTO comitentes_schema.comitente (descripcion) VALUES ('Franco Passarelli');
INSERT INTO comitentes_schema.comitente (descripcion) VALUES ('Ariel Molina');
INSERT INTO comitentes_schema.comitente (descripcion) VALUES ('Juan Perez');
INSERT INTO comitentes_schema.comitente (descripcion) VALUES ('Leonardo Cruz');

-- Relaciono comitentes con mercados
INSERT INTO comitentes_schema.comitente_mercado (comitente_id, mercado_id) VALUES (1, 1);
INSERT INTO comitentes_schema.comitente_mercado (comitente_id, mercado_id) VALUES (2, 1);
INSERT INTO comitentes_schema.comitente_mercado (comitente_id, mercado_id) VALUES (3, 1);
INSERT INTO comitentes_schema.comitente_mercado (comitente_id, mercado_id) VALUES (4, 1);
INSERT INTO comitentes_schema.comitente_mercado (comitente_id, mercado_id) VALUES (4, 2);
INSERT INTO comitentes_schema.comitente_mercado (comitente_id, mercado_id) VALUES (4, 3);
INSERT INTO comitentes_schema.comitente_mercado (comitente_id, mercado_id) VALUES (3, 2);