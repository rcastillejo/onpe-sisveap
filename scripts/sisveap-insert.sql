--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.9
-- Dumped by pg_dump version 9.3.9
-- Started on 2015-07-29 16:53:32

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

--
-- TOC entry 1992 (class 0 OID 16688)
-- Dependencies: 170
-- Data for Name: tp_estado; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tp_estado VALUES ('AOT0001', 'Pendiente');
INSERT INTO tp_estado VALUES ('AOT0002', 'En Proceso');
INSERT INTO tp_estado VALUES ('AOT0004', 'Terminado');
INSERT INTO tp_estado VALUES ('AOT0005', 'Rechazado');
INSERT INTO tp_estado VALUES ('AOT0003', 'Asignado');

INSERT INTO tp_estado VALUES ('ORT0001', 'Pendiente');
INSERT INTO tp_estado VALUES ('ORT0002', 'En Proceso');
INSERT INTO tp_estado VALUES ('ORT0004', 'Terminado');
INSERT INTO tp_estado VALUES ('ORT0005', 'Rechazado');
INSERT INTO tp_estado VALUES ('ORT0003', 'Asignado');

INSERT INTO tp_estado VALUES ('VER0001', 'Disponible');
INSERT INTO tp_estado VALUES ('VER0002', 'No Disponible');


INSERT INTO tp_region VALUES ('RG00001', 'Region1');
INSERT INTO tp_region VALUES ('RG00002', 'Region2');
INSERT INTO tp_region VALUES ('RG00003', 'Region3');
INSERT INTO tp_region VALUES ('RG00004', 'Region4');


INSERT INTO tp_supervisor VALUES ('SU00001', '46633129', 'Luis Ricardo', 'Castillejo Luna', 'Manco Segundo 130', 'RG00001');
INSERT INTO tp_supervisor VALUES ('SU00002', '46633128', 'Harold', 'Flores', 'Las Palmeras 4430', 'RG00002');
INSERT INTO tp_supervisor VALUES ('SU00003', '46633127', 'Juan', 'Perez', 'Chinchon 130', 'RG00003');
INSERT INTO tp_supervisor VALUES ('SU00004', '46633126', 'Sergio', 'Gomez', 'Manco Segundo 530', 'RG00004');
INSERT INTO tp_supervisor VALUES ('SU00005', '46633130', 'Luis', 'Castillejo Luna', 'Manco Segundo 130', 'RG00001');
INSERT INTO tp_supervisor VALUES ('SU00006', '46633131', 'Arnold', 'Flores', 'Las Palmeras 4430', 'RG00002');
INSERT INTO tp_supervisor VALUES ('SU00007', '46633132', 'Jose', 'Perez', 'Chinchon 130', 'RG00003');
INSERT INTO tp_supervisor VALUES ('SU00008', '46633133', 'Abraham', 'Gomez', 'Manco Segundo 530', 'RG00004');


INSERT INTO tp_verificador VALUES ('VE00001', '46633129', 'Luis Ricardo', 'Castillejo Luna', 'Manco Segundo 130', '2000-08-27', 'RG00001', 'VER0001', 0);
INSERT INTO tp_verificador VALUES ('VE00002', '46633128', 'Harold', 'Flores', 'Las Palmeras 4430', '2005-08-27', 'RG00002', 'VER0001', 0);
INSERT INTO tp_verificador VALUES ('VE00003', '46633127', 'Juan', 'Perez', 'Chinchon 130', '2010-08-27', 'RG00003', 'VER0001', 0);
INSERT INTO tp_verificador VALUES ('VE00004', '46633126', 'Sergio', 'Gomez', 'Manco Segundo 530', '2009-08-27', 'RG00004', 'VER0001', 0);


INSERT INTO tp_archivo_ot VALUES ('ARC201500001', now(), NULL, 'ot_20150827', 'C:/arch_ot/ot_20150827.txt', 100, 'AOT0001', NULL, NULL, '2015-07-29 16:33:44.156', NULL);


INSERT INTO tp_orden_trabajo VALUES ('ORT201500001', 'ARC201500001', now(), NULL, 'RG00001', 'ORT0001', NULL, NULL, '2015-07-29 16:33:44.156', NULL, NULL);
INSERT INTO tp_orden_trabajo VALUES ('ORT201500002', 'ARC201500001', now(), NULL, 'RG00002', 'ORT0001', NULL, NULL, '2015-07-29 16:33:44.156', NULL, NULL);
INSERT INTO tp_orden_trabajo VALUES ('ORT201500003', 'ARC201500001', now(), NULL, 'RG00003', 'ORT0001', NULL, NULL, '2015-07-29 16:33:44.156', NULL, NULL);
INSERT INTO tp_orden_trabajo VALUES ('ORT201500004', 'ARC201500001', now(), NULL, 'RG00004', 'ORT0001', NULL, NULL, '2015-07-29 16:33:44.156', NULL, NULL);
INSERT INTO tp_orden_trabajo VALUES ('ORT201500005', 'ARC201500001', now(), NULL, 'RG00001', 'ORT0001', NULL, NULL, '2015-07-29 16:33:44.156', NULL, NULL);
INSERT INTO tp_orden_trabajo VALUES ('ORT201500006', 'ARC201500001', now(), NULL, 'RG00002', 'ORT0001', NULL, NULL, '2015-07-29 16:33:44.156', NULL, NULL);
INSERT INTO tp_orden_trabajo VALUES ('ORT201500007', 'ARC201500001', now(), NULL, 'RG00003', 'ORT0001', NULL, NULL, '2015-07-29 16:33:44.156', NULL, NULL);
INSERT INTO tp_orden_trabajo VALUES ('ORT201500008', 'ARC201500001', now(), NULL, 'RG00004', 'ORT0001', NULL, NULL, '2015-07-29 16:33:44.156', NULL, NULL);
INSERT INTO tp_orden_trabajo VALUES ('ORT201500009', 'ARC201500001', now(), NULL, 'RG00001', 'ORT0001', NULL, NULL, '2015-07-29 16:33:44.156', NULL, NULL);
INSERT INTO tp_orden_trabajo VALUES ('ORT201500010', 'ARC201500001', now(), NULL, 'RG00002', 'ORT0001', NULL, NULL, '2015-07-29 16:33:44.156', NULL, NULL);
INSERT INTO tp_orden_trabajo VALUES ('ORT201500011', 'ARC201500001', now(), NULL, 'RG00003', 'ORT0001', NULL, NULL, '2015-07-29 16:33:44.156', NULL, NULL);
INSERT INTO tp_orden_trabajo VALUES ('ORT201500012', 'ARC201500001', now(), NULL, 'RG00004', 'ORT0001', NULL, NULL, '2015-07-29 16:33:44.156', NULL, NULL);


