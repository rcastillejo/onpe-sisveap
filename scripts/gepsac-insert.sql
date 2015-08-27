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

INSERT INTO tp_estado VALUES ('IND0001', 'Activo');
INSERT INTO tp_estado VALUES ('IND0002', 'Inactivo');
INSERT INTO tp_estado VALUES ('ACT0001', 'Registrado');
INSERT INTO tp_estado VALUES ('EST0001', 'Registrado');
INSERT INTO tp_estado VALUES ('EST0002', 'Configurado');
INSERT INTO tp_estado VALUES ('EAI0001', 'Activo');
INSERT INTO tp_estado VALUES ('EAI0002', 'Inactivo');
INSERT INTO tp_estado VALUES ('PLA0001', 'Registrado');
INSERT INTO tp_estado VALUES ('PLA0002', 'Configurado');
INSERT INTO tp_estado VALUES ('PLA0003', 'Programado');


--
-- TOC entry 1996 (class 0 OID 16730)
-- Dependencies: 174
-- Data for Name: tp_actividad; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tp_actividad VALUES ('ACT0001', 'Charla Prevención Bullying', 'Charla de prevención contra el bullying, conceptos.', NULL, 1, 1, 'S ', 1, 'ACT0001', NULL, '2015-07-29 15:35:27.888', NULL, NULL);
INSERT INTO tp_actividad VALUES ('ACT0002', 'Reconocimiento de  los roles del bullying', 'Permite reconocer el rol que participan los alumnos en el bullying', NULL, 1, 1, 'S ', 1, 'ACT0001', NULL, '2015-07-29 15:35:27.888', NULL, NULL);


--
-- TOC entry 1997 (class 0 OID 16744)
-- Dependencies: 175
-- Data for Name: tp_estrategia; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tp_estrategia VALUES ('EST20150729001', 'Reducir los casos de acoso escolar', 'Reducir los casos de acoso escolar', NULL, 'EST0002');
INSERT INTO tp_estrategia VALUES ('EST20150729002', 'Incrementar la intervención de los padres', 'Incrementar la intervención de los padres', NULL, 'EST0001');


--
-- TOC entry 1995 (class 0 OID 16717)
-- Dependencies: 173
-- Data for Name: tp_indicador; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tp_indicador VALUES ('IND0001', 'Porcentaje Asistencia', NULL, 'count(if(asistencia))/count(*)', 'IND0001');


INSERT INTO tp_estrategia_actividad VALUES ('EST20150729001', 'ACT0001', 'EAI0001', NULL, '2015-07-29 16:22:23.112', NULL, NULL);
INSERT INTO tp_estrategia_actividad VALUES ('EST20150729001', 'ACT0002', 'EAI0001', NULL, '2015-07-29 16:22:31.914', NULL, NULL);

--
-- TOC entry 1998 (class 0 OID 16757)
-- Dependencies: 176
-- Data for Name: tp_estrategia_actividad_indicador; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tp_estrategia_indicador VALUES ('EST20150729001', 'ACT0001', 'IND0001', 'EAI0001', NULL, '2015-07-29 16:22:23.112', NULL, NULL);
INSERT INTO tp_estrategia_indicador VALUES ('EST20150729001', 'ACT0002', 'IND0001', 'EAI0001', NULL, '2015-07-29 16:22:31.914', NULL, NULL);


--
-- TOC entry 1993 (class 0 OID 16693)
-- Dependencies: 171
-- Data for Name: tp_plan; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tp_plan VALUES ('PLA20150729001', '2015', NULL, NULL, NULL, '2015-03-18 00:00:00', '2015-12-24 00:00:00', 'PLA0001', NULL, '2015-07-29 16:33:44.156', NULL, NULL);

INSERT INTO tp_plan_fecha_restriccion VALUES ('PLA20150729001', '2015-04-02', '2015-04-03', 'R', 'Semana Santa');
INSERT INTO tp_plan_fecha_restriccion VALUES ('PLA20150729001', '2015-05-01', '2015-05-01', 'U', 'Día del Trabajador');
INSERT INTO tp_plan_fecha_restriccion VALUES ('PLA20150729001', '2015-06-29', '2015-06-29', 'U', 'Día de San Pedro y San Pablo');
INSERT INTO tp_plan_fecha_restriccion VALUES ('PLA20150729001', '2015-07-28', '2015-07-29', 'R', 'Fiestas Patrias');
INSERT INTO tp_plan_fecha_restriccion VALUES ('PLA20150729001', '2015-10-08', '2015-10-08', 'U', 'Combate de Angamos');
INSERT INTO tp_plan_fecha_restriccion VALUES ('PLA20150729001', '2015-11-01', '2015-11-01', 'U', 'Día de los Santos');
INSERT INTO tp_plan_fecha_restriccion VALUES ('PLA20150729001', '2015-12-08', '2015-12-08', 'U', 'Día Festivo');


--
-- TOC entry 1999 (class 0 OID 16783)
-- Dependencies: 177
-- Data for Name: tp_plan_estrategia; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1994 (class 0 OID 16707)
-- Dependencies: 172
-- Data for Name: tp_plan_hito; Type: TABLE DATA; Schema: public; Owner: postgres
--



-- Completed on 2015-07-29 16:53:33

--
-- PostgreSQL database dump complete
--

