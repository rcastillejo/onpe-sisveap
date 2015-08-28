CREATE TABLE tp_estado
(
  cod_estado character varying(15) NOT NULL NOT NULL,
  nom_estado character varying(100) NOT NULL,
  CONSTRAINT pk_tp_estado PRIMARY KEY (cod_estado)
)
WITH (
  OIDS=FALSE
);

CREATE TABLE tp_region
(
  cod_region character varying(15) NOT NULL NOT NULL,
  nom_region character varying(100) NOT NULL,
  CONSTRAINT pk_tp_region PRIMARY KEY (cod_region)
)
WITH (
  OIDS=FALSE
);

CREATE TABLE tp_supervisor
(
  cod_supervisor character varying(15) NOT NULL NOT NULL,
  dni character varying(8) NOT NULL,
  nombre character varying(100) NOT NULL,
  apellidos character varying(100) NOT NULL,
  direccion character varying(100) NOT NULL,
  
  cod_region character varying(15) NOT NULL, 
  
  CONSTRAINT pk_tp_supervisor PRIMARY KEY (cod_supervisor),
  CONSTRAINT fk_tp_supervisor_tp_region FOREIGN KEY (cod_region)
      REFERENCES tp_region (cod_region) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE tp_verificador
(
  cod_verificador character varying(15) NOT NULL NOT NULL,
  dni character varying(8) NOT NULL,
  nombre character varying(100) NOT NULL,
  apellidos character varying(100) NOT NULL,
  direccion character varying(100) NOT NULL,
  fec_ult_trab timestamp without time zone, 
  
  cod_region character varying(15) NOT NULL, 
  cod_estado character varying(15) NOT NULL, 
  
  cant_ot_asignado int NOT NULL, 
  
  CONSTRAINT pk_tp_verificador PRIMARY KEY (cod_verificador),
  CONSTRAINT fk_tp_verificador_tp_region FOREIGN KEY (cod_region)
      REFERENCES tp_region (cod_region) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_tp_verificador_tp_estado FOREIGN KEY (cod_estado)
      REFERENCES tp_estado (cod_estado) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE tp_archivo_ot
(
  cod_archivo character varying(15) NOT NULL,
  fec_registro timestamp without time zone, 
  fec_asignacion timestamp without time zone, 
  
  nombre_archivo character varying(50) NOT NULL,
  ruta_archivo character varying(100) NOT NULL,
  cant_registro int NOT NULL,
  
  cod_estado character varying(15) NOT NULL, 
  
  cod_supervisor character varying(15) NULL,
  
  usu_crea character varying(50), -- Usuario de creacion
  fec_crea timestamp without time zone DEFAULT now(), -- Fecha de creacion
  usu_modif character varying(50), -- Usuario de Modificacion
  fec_modif timestamp without time zone, -- Fecha de modifcacion
  CONSTRAINT pk_tp_archivo_ot PRIMARY KEY (cod_archivo),
  CONSTRAINT fk_tp_archivo_ot_tp_estado FOREIGN KEY (cod_estado)
      REFERENCES tp_estado (cod_estado) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_tp_archivo_ot_tp_supervisor FOREIGN KEY (cod_supervisor)
      REFERENCES tp_supervisor (cod_supervisor) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE tp_orden_trabajo
(
  cod_ordentrabajo character varying(15) NOT NULL,  
  cod_archivo character varying(15) NOT NULL,  
  fec_ingreso timestamp without time zone, 
  fec_asignado timestamp without time zone, 

  cod_region character varying(15) NOT NULL, 
  
  cod_estado character varying(15) NOT NULL, 
  
  cod_verificador character varying(15) NULL,
  
  usu_crea character varying(50), -- Usuario de creacion
  fec_crea timestamp without time zone DEFAULT now(), -- Fecha de creacion
  usu_modif character varying(50), -- Usuario de Modificacion
  fec_modif timestamp without time zone, -- Fecha de modifcacion
  
  CONSTRAINT pk_tp_tp_orden_trabajo PRIMARY KEY (cod_ordentrabajo),
  CONSTRAINT fk_tp_orden_trabajo_1 FOREIGN KEY (cod_archivo)
      REFERENCES tp_archivo_ot (cod_archivo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_tp_orden_trabajo_2 FOREIGN KEY (cod_region)
      REFERENCES tp_region (cod_region) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_tp_orden_trabajo_3 FOREIGN KEY (cod_estado)
      REFERENCES tp_estado (cod_estado) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_tp_orden_trabajo_4 FOREIGN KEY (cod_verificador)
      REFERENCES tp_verificador (cod_verificador) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

