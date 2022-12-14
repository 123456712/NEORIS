-- PROCEDURE: public.sp_crear_mecanico(character varying, integer, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character)

-- DROP PROCEDURE IF EXISTS public.sp_crear_mecanico(character varying, integer, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character);

CREATE OR REPLACE PROCEDURE public.sp_crear_mecanico(
	IN in_tipo_documento varchar(2) ,
	IN in_documento integer,
	IN in_primer_nombre varchar(30),
	IN in_segundo_nombre varchar(30),
	IN in_primer_apellido varchar(30),
	IN in_segundo_apellido varchar(30),
	IN in_celular varchar(10),
	IN in_direccion varchar(200),
	IN in_email varchar(100),
	IN in_estado varchar(1))
LANGUAGE 'plpgsql'
AS $BODY$
BEGIN
	
	-- DECLARE @desc VARCHAR(30) = 'Creación exitosa!';

	INSERT INTO mecanicos(tipo_documento, documento, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido,
                          celular, direccion, email, estado)
    values (in_tipo_documento, in_documento, in_primer_nombre, COALESCE(in_segundo_nombre,''), in_primer_apellido, COALESCE(in_segundo_apellido,''), in_celular,
            in_direccion, in_email, in_estado);

	
	--RETURN @desc;
END;
$BODY$;
ALTER PROCEDURE public.sp_crear_mecanico(character varying, integer, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character)
    OWNER TO postgres;

-- inserts
INSERT INTO public.mecanicos(
	tipo_documento, documento, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, celular, direccion, email, estado)
	VALUES ('cc',1030630689,'Juan','Camilo','Leal','Rojas','3503476985','Carrera 4','algo@gmail.com','a');
	
	
	INSERT INTO public.clientes(
	tipo_documento, documento, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, celular, direccion, email)
	VALUES ('cc',54653213,'Jhon','Sebastian','Laguna',null,'3503476985','Carrera 1','algo@gmail.com');
	
	INSERT INTO public.marcas(
	codigo, nombre_marca)
	VALUES (1,'CHEVROLET');
	
	INSERT INTO public.vehiculos(
	placa, color, cod_marca, cli_documento, cli_tipo_documento)
	VALUES ('XUB395', 'Negro', 1, 54653213, 'cc');
	
	INSERT INTO public.mantenimientos(
	codigo, estado, cod_placa, fecha, mec_documento, mec_tipo_documento)
	VALUES (1, 1, 'XUB395', '2022/11/30', 1030630689, 'cc');
	
	INSERT INTO public.fotos(
	codigo, ruta, cod_mantenimiento)
	VALUES (1, 'C:\Users\User\Pictures', 1);
	
	
	INSERT INTO public.repuestos(
	codigo, nombre_repuesto, precio_unitario, unidades_inventario, proveedor)
	VALUES (1,'Pastillas de freno', 70000, 100,'Booster' );
		INSERT INTO public.repuestos(
	codigo, nombre_repuesto, precio_unitario, unidades_inventario, proveedor)
	VALUES (2,'Aceite de freno', 140000, 100,'Iridium' );
		INSERT INTO public.repuestos(
	codigo, nombre_repuesto, precio_unitario, unidades_inventario, proveedor)
	VALUES (3,'Aceite para motor', 230000, 100,'Booster' );
	
	
	INSERT INTO public.servicios(
	codigo, nombre_servicio, precio)
	VALUES (1, 'Revisión automotriz', 180000);	
	INSERT INTO public.servicios(
	codigo, nombre_servicio, precio)
	VALUES (2, 'Cambio de aceite', 65000);
	INSERT INTO public.servicios(
	codigo, nombre_servicio, precio)
	VALUES (3,'Alineación', 95000);
	
	INSERT INTO public.repuestos_x_mantenimientos(
	codigo, unidades, tiempo_estimado, cod_mantenimiento, cod_repuesto)
	VALUES (1, 2, 1, 1,3);
	
	
	INSERT INTO public.servicios_x_mantenimientos(
	codigo, tiempo_estimado, cod_servicio, cod_mantenimiento)
	VALUES (1, 2, 2, 1);
	
	--End inserts
	