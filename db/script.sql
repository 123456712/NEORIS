-- Database: carcare

-- DROP DATABASE IF EXISTS carcare;

CREATE DATABASE carcare
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

GRANT TEMPORARY, CONNECT ON DATABASE carcare TO PUBLIC;


-- Table: public.marcas

-- DROP TABLE IF EXISTS public.marcas;

CREATE TABLE IF NOT EXISTS public.marcas
(
    codigo numeric(18,0) NOT NULL,
    nombre_marca character varying(30) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_marcas PRIMARY KEY (codigo)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.marcas
    OWNER to postgres;
	
	
	-- Table: public.clientes

-- DROP TABLE IF EXISTS public.clientes;

CREATE TABLE IF NOT EXISTS public.clientes
(
    tipo_documento character varying(2) COLLATE pg_catalog."default" NOT NULL,
    documento numeric(18,0) NOT NULL,
    primer_nombre character varying(30) COLLATE pg_catalog."default" NOT NULL,
    segundo_nombre character varying(30) COLLATE pg_catalog."default",
    primer_apellido character varying(30) COLLATE pg_catalog."default" NOT NULL,
    segundo_apellido character varying(30) COLLATE pg_catalog."default",
    celular character varying(10) COLLATE pg_catalog."default" NOT NULL,
    direccion character varying(200) COLLATE pg_catalog."default" NOT NULL,
    email character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_clientes PRIMARY KEY (tipo_documento, documento)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.clientes
    OWNER to postgres;
	
	
	-- Table: public.vehiculos

-- DROP TABLE IF EXISTS public.vehiculos;

CREATE TABLE IF NOT EXISTS public.vehiculos
(
    placa character varying(6) COLLATE pg_catalog."default" NOT NULL,
    color character varying(30) COLLATE pg_catalog."default" NOT NULL,
    cod_marca numeric(18,0) NOT NULL,
    cli_documento numeric(18,0) NOT NULL,
    cli_tipo_documento character varying(2) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_vehiculos PRIMARY KEY (placa),
    CONSTRAINT vehiculos_clientes_fk FOREIGN KEY (cli_documento, cli_tipo_documento)
        REFERENCES public.clientes (documento, tipo_documento) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT vehiculos_marcas_fk FOREIGN KEY (cod_marca)
        REFERENCES public.marcas (codigo) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.vehiculos
    OWNER to postgres;
	
	-- Table: public.mecanicos

-- DROP TABLE IF EXISTS public.mecanicos;

CREATE TABLE IF NOT EXISTS public.mecanicos
(
    tipo_documento character varying(2) COLLATE pg_catalog."default" NOT NULL,
    documento integer NOT NULL,
    primer_nombre character varying(30) COLLATE pg_catalog."default" NOT NULL,
    segundo_nombre character varying(30) COLLATE pg_catalog."default",
    primer_apellido character varying(30) COLLATE pg_catalog."default" NOT NULL,
    segundo_apellido character varying(30) COLLATE pg_catalog."default",
    celular character varying(10) COLLATE pg_catalog."default" NOT NULL,
    direccion character varying(200) COLLATE pg_catalog."default" NOT NULL,
    email character varying(100) COLLATE pg_catalog."default" NOT NULL,
    estado character(1) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_mecanicos PRIMARY KEY (tipo_documento, documento)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.mecanicos
    OWNER to postgres;
	
		
	CREATE TABLE public.facturas
(
    LIKE public.clientes
        INCLUDING CONSTRAINTS,

    codigo integer NOT NULL,
    fecha date NOT NULL,
    cli_tipo_documento character varying NOT NULL,
    cli_documento integer NOT NULL,
    descuento_servicio integer NOT NULL,
    limite_presupuesto double precision NOT NULL,
    subtotal double precision NOT NULL,
    total double precision NOT NULL,
    PRIMARY KEY (codigo)
);

ALTER TABLE IF EXISTS public.facturas
    OWNER to postgres;
	
	-- Table: public.mantenimientos

-- DROP TABLE IF EXISTS public.mantenimientos;

CREATE TABLE IF NOT EXISTS public.mantenimientos
(
    codigo integer NOT NULL,
    estado integer,
    cod_placa character varying(6) COLLATE pg_catalog."default" NOT NULL,
    fecha date NOT NULL,
    mec_documento integer NOT NULL,
    mec_tipo_documento character varying(2) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_mantenimientos PRIMARY KEY (codigo),
    CONSTRAINT man_vehiculos_fk FOREIGN KEY (cod_placa)
        REFERENCES public.vehiculos (placa) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT mantenimientos_mecanicos_fk FOREIGN KEY (mec_documento, mec_tipo_documento)
        REFERENCES public.mecanicos (documento, tipo_documento) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.mantenimientos
    OWNER to postgres;
	
	-- Table: public.repuestos

-- DROP TABLE IF EXISTS public.repuestos;

CREATE TABLE IF NOT EXISTS public.repuestos
(
    codigo integer NOT NULL,
    nombre_repuesto character varying(100) COLLATE pg_catalog."default" NOT NULL,
    precio_unitario numeric(18,0) NOT NULL,
    unidades_inventario integer NOT NULL,
    proveedor character varying(300) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_repuestos PRIMARY KEY (codigo)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.repuestos
    OWNER to postgres;
	
	
	-- Table: public.repuestos_x_mantenimientos

-- DROP TABLE IF EXISTS public.repuestos_x_mantenimientos;

CREATE TABLE IF NOT EXISTS public.repuestos_x_mantenimientos
(
    codigo integer NOT NULL,
    unidades integer NOT NULL,
    tiempo_estimado integer NOT NULL,
    cod_mantenimiento integer NOT NULL,
    cod_repuesto integer NOT NULL,
    CONSTRAINT pk_repuestos_x_mantenimientos PRIMARY KEY (codigo),
    CONSTRAINT rep_x_man_rep_fk FOREIGN KEY (cod_repuesto)
        REFERENCES public.repuestos (codigo) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT rep_x_mtos_man_fk FOREIGN KEY (cod_mantenimiento)
        REFERENCES public.mantenimientos (codigo) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.repuestos_x_mantenimientos
    OWNER to postgres;
	
	-- Table: public.fotos

-- DROP TABLE IF EXISTS public.fotos;

CREATE TABLE IF NOT EXISTS public.fotos
(
    codigo integer NOT NULL,
    ruta character varying(200) COLLATE pg_catalog."default",
    cod_mantenimiento integer NOT NULL,
    CONSTRAINT pk_fotos PRIMARY KEY (codigo),
    CONSTRAINT fotos_man_fk FOREIGN KEY (cod_mantenimiento)
        REFERENCES public.mantenimientos (codigo) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.fotos
    OWNER to postgres;
	
	-- Table: public.servicios

-- DROP TABLE IF EXISTS public.servicios;

CREATE TABLE IF NOT EXISTS public.servicios
(
    codigo integer NOT NULL,
    nombre_servicio character varying(100) COLLATE pg_catalog."default" NOT NULL,
    precio numeric(18,0) NOT NULL,
    CONSTRAINT pk_servicios PRIMARY KEY (codigo)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.servicios
    OWNER to postgres;
	
	-- Table: public.servicios_x_mantenimientos

-- DROP TABLE IF EXISTS public.servicios_x_mantenimientos;

CREATE TABLE IF NOT EXISTS public.servicios_x_mantenimientos
(
    codigo integer NOT NULL,
    tiempo_estimado integer NOT NULL,
    cod_servicio integer NOT NULL,
    cod_mantenimiento integer NOT NULL,
    CONSTRAINT pk_servicios_x_mantenimientos PRIMARY KEY (codigo),
    CONSTRAINT ser_x_man_man_fk FOREIGN KEY (cod_mantenimiento)
        REFERENCES public.mantenimientos (codigo) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT ser_x_man_ser_fk FOREIGN KEY (cod_servicio)
        REFERENCES public.servicios (codigo) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.servicios_x_mantenimientos
    OWNER to postgres;