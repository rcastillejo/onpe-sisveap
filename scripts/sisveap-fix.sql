delete from tp_orden_trabajo;
delete from tp_archivo_ot;
delete from tp_verificador;
delete from tp_supervisor;
delete from tp_region;
delete from tp_estado;

--Creacion tabla

CREATE TABLE if not exists tp_config
(
  parametro character varying(15) NOT NULL,  
  valor character varying(50) NOT NULL,  
  descripcion character varying(150),
  CONSTRAINT pk_tp_config PRIMARY KEY (parametro)
)
WITH (
  OIDS=FALSE
);