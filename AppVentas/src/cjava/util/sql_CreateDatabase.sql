
CREATE DATABASE cjava;

USE cjava ;


CREATE TABLE Proveedores
(
	idProveedor	 char(5) NOT NULL,
	RazonSocial	 varchar(60) NOT NULL,
	Direccion	 varchar(60) NOT NULL,
	Ruc		 varchar(11) NOT NULL,
	Telefono	 varchar(15) NOT NULL,
 	PRIMARY KEY (idProveedor)
)  ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE Empleados
(
	idEmpleado	 char(5) NOT NULL,
	Apellido	 varchar(40) NOT NULL,
	Nombre	         varchar(30) NOT NULL,
     Email		 varchar(50) NOT NULL,
	Usuario   	varchar(20) NOT NULL,
	Clave	       varchar(20) NOT NULL,
 	PRIMARY KEY (idEmpleado)
)  ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE Categorias
(
	idCategoria   int(2) not null,
	Nombre	 varchar(20) NOT NULL,
	Descripcion varchar(60) null,
	PRIMARY KEY (idCategoria)
 ) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE Productos
(
	idProducto	 char(5),
	Descripcion	 varchar(50) NOT NULL,
	IdCategoria	 int(2) NOT NULL,	
	PrecioCompra     decimal(18,2) NOT NULL,
	PrecioVenta	 decimal(18,2) NOT NULL,
	Stock		 int(5) NOT NULL,
	PRIMARY KEY (idProducto)
 ) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE Clientes(
	idCliente	 char(5) NOT NULL,
	Nombre		 varchar(60) NOT NULL,
	Direccion	 varchar(60) NOT NULL,
	RucDNI		 varchar(11) NOT NULL,
	Telefono	 varchar(15) NOT NULL,
	PRIMARY KEY (idCliente)
	)  ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE Ventas
(
	idVenta	    int(5) NOT NULL,
	idCliente   char(5) NOT NULL,	
	idEmpleado  char(5) NOT NULL,
	TipoDoc    varchar(10) NOT NULL,
	NroDoc    varchar(7) NOT NULL,
	Fecha    datetime NOT NULL,
	Total    decimal(18,2) NOT NULL,
	PRIMARY KEY (idVenta),
	Foreign Key (idCliente) References Clientes(idCliente),
        Foreign Key (idEmpleado) References Empleados(idEmpleado)
) ENGINE=InnoDB DEFAULT CHARSET=latin1; 


CREATE TABLE DetalleVenta
(
	idVenta   int(5) NOT NULL,
	idProducto   char(5) NOT NULL,	
	PrecioVenta   decimal(18,2) NOT NULL,
	Cantidad   int(5) NOT NULL,
	Importe   decimal(18,2) NOT NULL,
	Foreign Key (idVenta) references Ventas(idVenta),
	Foreign Key (idProducto) references Productos(idProducto)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE Compras
(
	idCompra   int(5) NOT NULL,
	idProveedor   char(5) NOT NULL,
	idEmpleado    char(5) NOT NULL,
	TipoDoc   varchar(20) NOT NULL,
	NroDoc   varchar(7) NOT NULL,
	Fecha   date NOT NULL,
	SubTotal   decimal(18,2) NOT NULL,
	Igv   decimal(18,2) NOT NULL,
	Total   decimal(18,2) NOT NULL,
	PRIMARY KEY (idCompra),
	FOREIGN KEY (idproveedor) REFERENCES proveedores(idProveedor),
        Foreign Key (idEmpleado) References Empleados(idEmpleado)	
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 

CREATE TABLE DetalleCompra
(
	idCompra   int(5) NOT NULL,
	idProducto   char(5) NOT NULL,
	Precio   decimal(18,2) NOT NULL,
	Cantidad   int(5) NOT NULL,
	Importe   decimal(18,2) NOT NULL,
	Foreign Key (idCompra) References Compras(idCompra),
	Foreign Key (idProducto) References Productos(idProducto)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE Control
(
	parametro   varchar(20) NOT NULL,
	Valor   int(4) not null,
	PRIMARY KEY (parametro)
 ) ENGINE=InnoDB DEFAULT CHARSET=latin1;



