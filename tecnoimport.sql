
drop database tecnoimport;
create database tecnoimport;
use tecnoimport;


-- CREATE USER ‘usuario’@'%' IDENTIFIED BY 'contraseña';
-- GRANT REPLICATION SLAVE ON *.* TO 'usuario'@'%'  ;


create table cliente(
  nombre varchar(50),
  apellido varchar(50),
  idCliente int(10),
  edad varchar(10),
  telefono varchar(45),
  email varchar(45),
  direccion varchar(45), 
primary key (idCliente)
);

 
 
create table matriz(
  nombre varchar(50),
  idMatriz int(10),
  telefono varchar(45),
  direccion varchar(45),
  primary key (idMatriz)
);


create table sucursal(
  nombre varchar(50),
  idSucursal int(10),
  telefono varchar(45),
  direccion varchar(45),
  primary key (idSucursal)
);


create table bodega(
   nombre varchar(50),
   idBodega int(10),
   telefono varchar(45),
   direccion varchar(45),
   idTipolocal int(10),
primary key (idBodega)
);


create table vendedor(
  idVendedor int(10),
  nombre varchar(50),
  apellido varchar(50),
  edad varchar(10),
  telefono varchar(45),
  idCliente int(10),
primary key (idVendedor),
foreign key(idCliente) references cliente(idCliente)
);


create table jefebodega(
  nombre varchar(50),
  apellido varchar(50),
  edad varchar(10),
  idJefe int(10),
  telefono varchar(10),
  idBodega int(10),
primary key (idJefe),
foreign key(idBodega) references bodega(idBodega)
);


create table repartidor(
  nombre varchar(50),
  apellido varchar(50),
  edad varchar(10),
  telefono varchar(45),
  idJefe int(10),
  idRepartidor int(10),
primary key (idRepartidor),
foreign key(idJefe) references jefebodega(idJefe)
);


create table administrador(
   nombre varchar(50),
   apellido varchar(50),
   idAdmin int(10),
   edad varchar(10),
   telefono varchar(45),
   idMatriz int(10),
   idSucursal int(10),
   primary key (idAdmin),
   foreign key(idMatriz) references matriz(idMatriz),
   foreign key(idSucursal) references sucursal(idSucursal)
);


create table gerente(
	nombre varchar(50),
	apellido varchar(50),
	idGerente int(10),
    idAdmin int(10),
    idMatriz int(10),
    idSucursal int(10),
	primary key (idGerente),
    foreign key(idMatriz) references matriz(idMatriz),
    foreign key(idSucursal) references sucursal(idSucursal)
);


create table articulo(
	idArticulo int(5),
	nombre varchar(50),
	categoria varchar(50),
	descripcion varchar(500),
	precio float(5),
	tiempoMaximoEntrega float(2),
	primary key (idArticulo)
);


create table factura(
	idFactura int(5),
    idCliente int(10),
	idArticulo int(5),
	fechaRecibido DATETIME,
primary key (idFactura),
foreign key(idCliente) references cliente(idCliente),
foreign key(idArticulo) references articulo(idArticulo)
); 

create table formaPago(
	idFormaPago int(5),
	formaPago varchar(50),
primary key(idFormaPago)
);

create table venta(
	idVenta int(5),
    idCliente int(10),
	idFormaPago int(5),
	fechaRecibido datetime,
primary key (idVenta),
foreign key(idFormaPago) references formaPago(idFormaPago),
foreign key(idCliente) references cliente(idCliente)
);

create table clienteXformaPago(
	idFormaPago int(5),
	monto int(5),
	idCliente int(10),
foreign key(idFormaPago) references formaPago(idFormaPago),
foreign key(idCliente) references cliente(idCliente)
);


create table inventario(
    idArticulo int(10),
    idMatriz int(10),
    idBodega int(10),
    idInventario int(10),
    cantidad int(10),
    nombre 	VARCHAR(50),
    primary key (idArticulo),
    foreign key (idMatriz) references matriz(idMatriz),
    foreign key (idbodega) references bodega(idbodega),
    foreign key (idArticulo) references articulo(idArticulo)
);




