CREATE TABLE tp_estado
(
  cod_estado character varying(15) NOT NULL NOT NULL,
  nom_estado character varying(100) NOT NULL,
  CONSTRAINT pk_tp_estado PRIMARY KEY (cod_estado)
)
WITH (
  OIDS=FALSE
);

CREATE TABLE tp_plan
(
  cod_plan character varying(15) NOT NULL,
  anio int NOT NULL,
  
  fec_registro timestamp without time zone, 
  fec_configuracion timestamp without time zone, 
  fec_programacion timestamp without time zone,
  
  fec_inicio timestamp without time zone, 
  fec_fin timestamp without time zone, 
  
  cod_estado character varying(15) NOT NULL, 
  
  usu_crea character varying(50), -- Usuario de creacion
  fec_crea timestamp without time zone DEFAULT now(), -- Fecha de creacion
  usu_modif character varying(50), -- Usuario de Modificacion
  fec_modif timestamp without time zone, -- Fecha de modifcacion
  CONSTRAINT pk_tp_plan PRIMARY KEY (cod_plan),
  CONSTRAINT fk_tp_plan_tp_estado FOREIGN KEY (cod_estado)
      REFERENCES tp_estado (cod_estado) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE tp_plan_hito
(
  cod_plan character varying(15) NOT NULL,  
  fec_hito date, 

  cod_estado character varying(15) NOT NULL, 
  
  CONSTRAINT pk_tp_plan_hito PRIMARY KEY (cod_plan,fec_hito),
  CONSTRAINT fk_tp_plan_hito_tp_plan FOREIGN KEY (cod_plan)
      REFERENCES tp_plan (cod_plan) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE tp_plan_fecha_restriccion
(
  cod_plan character varying(15) NOT NULL,  
  fec_ini_rest date NOT NULL,  -- Se utiliza para una fecha o rango
  fec_fin_rest date NOT NULL, -- Se utiliza para el rango
  tip_rest character varying(2) NOT NULL,  -- U: Una Fecha, R: Rango de fechas
  des_rest character varying(150) NOT NULL,  
  
  CONSTRAINT pk_tp_plan_fecha_restriccion PRIMARY KEY (cod_plan, fec_ini_rest, fec_fin_rest),
  CONSTRAINT fk_tp_plan_fecha_restriccion_1 FOREIGN KEY (cod_plan)
      REFERENCES tp_plan (cod_plan) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE tp_indicador
(
  cod_indicador character varying(15) NOT NULL,  
  nom_indicador character varying(250) NOT NULL,
  fec_registro timestamp without time zone, 
  formula character varying(250) NOT NULL,
  
  cod_estado character varying(15) NOT NULL, 
  
  CONSTRAINT pk_tp_indicador PRIMARY KEY (cod_indicador),
  CONSTRAINT fk_tp_indicador_tp_estado FOREIGN KEY (cod_estado)
      REFERENCES tp_estado (cod_estado) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE tp_actividad
(
  cod_actividad character varying(15) NOT NULL,
  nom_actividad character varying(250) NOT NULL,
  des_actividad character varying(250) NOT NULL,
  fec_registro timestamp without time zone, 
  duracion int,
  sesiones int,
  tipo_frecuencia character(2) NOT NULL,
  frecuencia int,
  
  cod_estado character varying(15) NOT NULL, 
  
  usu_crea character varying(50), -- Usuario de creacion
  fec_crea timestamp without time zone DEFAULT now(), -- Fecha de creacion
  usu_modif character varying(50), -- Usuario de Modificacion
  fec_modif timestamp without time zone, -- Fecha de modifcacion
  CONSTRAINT pk_tp_actividad PRIMARY KEY (cod_actividad),
  CONSTRAINT fk_tp_actividad_tp_estado FOREIGN KEY (cod_estado)
      REFERENCES tp_estado (cod_estado) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE tp_estrategia
(
  cod_estrategia character varying(15) NOT NULL,  
  titulo_estrategia character varying(250) NOT NULL,
  des_estrategia character varying(250) NOT NULL,
  fec_registro timestamp without time zone, 

  cod_estado character varying(15) NOT NULL, 
  
  CONSTRAINT pk_tp_estrategia PRIMARY KEY (cod_estrategia),
  CONSTRAINT fk_tp_actividad_tp_estado FOREIGN KEY (cod_estado)
      REFERENCES tp_estado (cod_estado) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE tp_estrategia_actividad
(
  cod_estrategia character varying(15) NOT NULL,
  cod_actividad character varying(15) NOT NULL,
  
  cod_estado character varying(15) NOT NULL, 
  
  usu_crea character varying(50), -- Usuario de creacion
  fec_crea timestamp without time zone DEFAULT now(), -- Fecha de creacion
  usu_modif character varying(50), -- Usuario de Modificacion
  fec_modif timestamp without time zone, -- Fecha de modifcacion
  CONSTRAINT pk_tp_est_act PRIMARY KEY (cod_estrategia, cod_actividad),
  CONSTRAINT fk_tp_est_act_tp_est FOREIGN KEY (cod_estrategia)
      REFERENCES tp_estrategia (cod_estrategia) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_tp_est_act_tp_act FOREIGN KEY (cod_actividad)
      REFERENCES tp_actividad (cod_actividad) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_tp_est_act_tp_estado FOREIGN KEY (cod_estado)
      REFERENCES tp_estado (cod_estado) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE tp_estrategia_indicador
(
  cod_estrategia character varying(15) NOT NULL,
  cod_actividad character varying(15) NOT NULL,
  cod_indicador character varying(15) NOT NULL,
  
  cod_estado character varying(15) NOT NULL, 
  
  usu_crea character varying(50), -- Usuario de creacion
  fec_crea timestamp without time zone DEFAULT now(), -- Fecha de creacion
  usu_modif character varying(50), -- Usuario de Modificacion
  fec_modif timestamp without time zone, -- Fecha de modifcacion
  CONSTRAINT pk_tp_est_act_ind PRIMARY KEY (cod_estrategia, cod_actividad, cod_indicador),
  CONSTRAINT fk_tp_est_act_ind_tp_est_act FOREIGN KEY (cod_estrategia, cod_actividad)
      REFERENCES tp_estrategia_actividad (cod_estrategia, cod_actividad) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_tp_est_act_ind_tp_estado FOREIGN KEY (cod_estado)
      REFERENCES tp_estado (cod_estado) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE tp_plan_estrategia
(
  cod_plan character varying(15) NOT NULL,
  cod_estrategia character varying(15) NOT NULL,
  
  CONSTRAINT pk_tp_plan_estrategia PRIMARY KEY (cod_plan, cod_estrategia),
  CONSTRAINT fk_tp_plan_estrategia_tp_plan FOREIGN KEY (cod_plan)
      REFERENCES tp_plan (cod_plan) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_tp_plan_estrategia_tp_estrategia FOREIGN KEY (cod_estrategia)
      REFERENCES tp_estrategia (cod_estrategia) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE tp_plan_actividad
(
  cod_plan character varying(15) NOT NULL,
  cod_estrategia character varying(15) NOT NULL,
  cod_actividad character varying(15) NOT NULL,
  
  fec_programacion timestamp without time zone, 
  fec_ejecucion timestamp without time zone,
  
  cod_estado character varying(15) NOT NULL, 
  
  usu_crea character varying(50), -- Usuario de creacion
  fec_crea timestamp without time zone DEFAULT now(), -- Fecha de creacion
  usu_modif character varying(50), -- Usuario de Modificacion
  fec_modif timestamp without time zone, -- Fecha de modifcacion
  CONSTRAINT pk_tp_plan_actividad PRIMARY KEY (cod_plan, cod_estrategia, cod_actividad),
  CONSTRAINT fk_tp_plan_actividad_1 FOREIGN KEY (cod_plan, cod_estrategia)
      REFERENCES tp_plan_estrategia (cod_plan, cod_estrategia) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_tp_plan_actividad_2 FOREIGN KEY (cod_estrategia, cod_actividad)
      REFERENCES tp_estrategia_actividad (cod_estrategia, cod_actividad) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE tp_plan_indicador
(
  cod_plan character varying(15) NOT NULL,
  cod_estrategia character varying(15) NOT NULL,
  cod_actividad character varying(15) NOT NULL,
  cod_indicador character varying(15) NOT NULL,
  
  meta numeric(10,2),
  
  cod_estado character varying(15) NOT NULL, 
  
  usu_crea character varying(50), -- Usuario de creacion
  fec_crea timestamp without time zone DEFAULT now(), -- Fecha de creacion
  usu_modif character varying(50), -- Usuario de Modificacion
  fec_modif timestamp without time zone, -- Fecha de modifcacion
  CONSTRAINT pk_tp_plan_indicador PRIMARY KEY (cod_plan, cod_estrategia, cod_actividad, cod_indicador),
  CONSTRAINT fk_tp_plan_indicador_1 FOREIGN KEY (cod_plan, cod_estrategia, cod_actividad)
      REFERENCES tp_plan_actividad (cod_plan, cod_estrategia, cod_actividad) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_tp_plan_indicador_2 FOREIGN KEY (cod_estrategia, cod_actividad, cod_indicador)
      REFERENCES tp_estrategia_indicador (cod_estrategia, cod_actividad, cod_indicador) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
