--- sp insertar empleado--

DELIMITER $$

DROP PROCEDURE IF EXISTS sp_Empleado_Adicionar$$

create procedure sp_Empleado_Adicionar
( p_idemp CHAR(5),
  p_nom  VARCHAR(20),
  p_ape  VARCHAR(20),
  p_correo VARCHAR(60),
  p_user VARCHAR(10),
  p_pass VARCHAR(10)
)
begin
insert into empleados values(p_idemp,p_nom,p_ape,p_correo,p_user,p_pass);

END$$

DELIMITER ;
   

--prueba--


 call sp_Empleado_Adicionar('E0006','Julio','Flores','jflores@hotmail.com','jflores','lobito');







---- actualiza-----

DELIMITER $$

DROP PROCEDURE IF EXISTS sp_Empleado_Actualizar$$

create procedure sp_Empleado_Actualizar
( p_idemp CHAR(5),
  p_nom  VARCHAR(20),
  p_ape  VARCHAR(20),
  p_correo VARCHAR(60),
  p_user VARCHAR(10),
  p_pass VARCHAR(10)
)
begin
update empleados set nombre=p_nom,apellido=p_ape,email=p_correo,usuario=p_user,clave=p_pass where idempleado=p_idemp;

END$$

DELIMITER ;

-- prueba --
call sp_Empleado_Actualizar('E0006','Julia','Flores','jflores@hotmail.com','jflores','lobita');




---- eliminar-----

DELIMITER $$

DROP PROCEDURE IF EXISTS sp_Empleado_Eliminar$$

create procedure sp_Empleado_Eliminar
( 
   p_idemp CHAR(5) 
)
begin
delete from empleados where idempleado=p_idemp;

END$$

DELIMITER ;



   -------consulta------

DELIMITER $$

DROP PROCEDURE IF EXISTS sp_Empleado_Listar$$

create procedure sp_Empleado_Listar
( 
   
)
begin
select * from empleados;

END$$

DELIMITER ;

----consultas-------

DELIMITER $$

DROP PROCEDURE IF EXISTS sp_Empleado_Datos$$

create procedure sp_Empleado_Datos
( 
   p_idemp CHAR(5) 
)
begin
select * from empleados where idempleado=p_idemp;

END$$

DELIMITER ;




DELIMITER $$

DROP PROCEDURE IF EXISTS sp_Producto_Adicionar$$

create procedure sp_Producto_Adicionar
( p_idpro CHAR(5),
  p_nom  VARCHAR(40),
  p_idcat  int,
  p_compra double,
  p_venta double,
  p_stock int
)
begin
insert into productos values(p_idpro,p_nom,p_idcat,p_compra,p_venta,p_stock);

END$$

DELIMITER ;
   

--prueba--


 call sp_Producto_Adicionar('A0026','Ternos para damas ',4,150.00,200.00,50);



























---- sp en oracle-----
--sp actualiza empleado--

create or replace procedure usp_Empleado_Actualizar
(p_idemp IN CHAR,
p_nom IN VARCHAR2,
p_ape IN VARCHAR2,
p_correo IN VARCHAR2,
p_user IN VARCHAR2,
p_pass IN VARCHAR2)
is
begin
update empleados set nombre=p_nom,apellidos=p_ape,email=p_correo,usuario=p_user,clave=p_pass
where idempleado=p_idemp;
end usp_empleado_modificar;

--prueba--

begin
usp_empleado_modificar('E0007','Manuel','Martinez','manuel@gmail.com','manuelito','angelito');
end;

--sp eliminar--

create or replace procedure usp_empleado_eliminar
(p_idemp IN CHAR
)
is
begin
delete from empleados where idempleado=p_idemp;
end usp_empleado_eliminar;

-- prueba--

begin
usp_empleado_eliminar('E0006');
end;

--sp con parametro de salida--

create or replace procedure USP_EMPLEADO_INSERTA
(p_idemp OUT CHAR,
p_nom IN VARCHAR2,
p_ape IN VARCHAR2,
p_correo IN VARCHAR2,
p_user IN VARCHAR2,
p_pass IN VARCHAR2)
is
begin
Select valor into p_idemp from Control where parametro='Empleados';
update Control set Valor=valor+1 where parametro='Empleados';
insert into empleados
 values(p_idemp,p_nom,p_ape,p_correo,p_user,p_pass);
end usp_empleado_inserta;

--prueba--



obtener la fecha del sistema en mysql

select CURDATE();

select curTime();

select now();


select YEAR(NOW());  #Selecciona el año
select MONTH (NOW()) as mes;  #Selecciona el mes
select DAY(NOW()) as dia; #Selecciona el día 
select TIME(NOW()) as hora;  #Selecciona la hora
Select LAST_DAY(NOW()); # Selecciona el ultimo dia del mes



