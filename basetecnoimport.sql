create user 'luis'@'192.168.%.%' identified by 'luis2020';
grant all privileges on *.* to 'luis'@'192.168.%.%' with grant option;
flush privileges;

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

create table login(
	idUsuario int,
    clave varchar(30),
    tipo varchar(30)
);

insert into login values (909090909,'xxx123','Gerente');
insert into login values (909090901,'xxx1234','Administrador');
insert into login values (909090900,'xxx12345','Jefe de Bodega');
insert into login values (1234567890,'12345','Vendedor');

insert into matriz(nombre,idMatriz,telefono,direccion) values ("Matriz Norte",1,"2576287","Av. Americas"),
	("Matriz Sur",2,"22476589","Cdla. Los Esteros");

insert into sucursal(nombre,idSucursal,telefono,direccion) values ("Sucursal Norte",1,"2278647","Av. Antonio Parra Velazco"),
	("Sucursal Sur",2,"2274651","Cdla. Los Esteros 2");

insert into bodega(nombre,idBodega,telefono,direccion,idTipolocal) values ("Bodega Norte",1,"2214783","Av. Jose Maria Egas",1);

insert into cliente(nombre,apellido,idCliente,edad,telefono,email,direccion) values ("luis","carrasco",1,"22","0974157414","example@hotmail.com","Sauces 2"),
	("juan","veliz",2,"25","0974561235","example2@hotmail.com","Sauces 5"),
	("marvin","munoz",3,"23","0974125631","example3@hotmail.com","Sauces 4"),
	("andres","cantos",4,"24","0977485123","example4@hotmail.com","Sauces 3"),
	("harold","espinoza",5,"22","0844561230","example5@hotmail.com","Sauces 1");
	
insert into vendedor(idVendedor,nombre,apellido,edad,telefono,idCliente)
values (1,"jose","cantos","30","2478341",1),
		(2,"ariel","zavala","25","2874610",2),
		(3,"cristhian","lopez","27","2214753",3);


insert into jefebodega(nombre,apellido,edad,idJefe,telefono,idBodega)
values("xavier","suarez","23",1,"2417852",1);


insert into repartidor(nombre,apellido,edad,telefono,idJefe,idRepartidor )values("andre","alejandro","24","2164852",1,1);


insert into administrador(nombre,apellido,idAdmin,edad,telefono,idMatriz,idSucursal)values("angel","loor",1,"36","2471563",1,1);


insert into gerente(nombre,apellido,idGerente,idAdmin,idMatriz,idSucursal
)values("dayse","maroto",1,1,1,1);


insert into articulo(idArticulo,nombre,categoria,descripcion,precio,tiempoMaximoEntrega) 
values(1,"articulo1","cat1","nn",4.50,150.0),(2,"articulo2","cat2","nn",3.80,140.0),(3,"articulo3","cat3","nn",2.70,130.0);


insert into factura(idFactura,idCliente,idArticulo,fechaRecibido)values(1,1,1,curdate()),(2,2,2,curdate()); 

insert into formaPago(idFormaPago,formaPago) values(1,"cash"),(2,"paypal");

insert into venta(idVenta,idCliente,idFormaPago,fechaRecibido
)values(1,1,1,curdate()),(2,2,2,curdate());

insert into clienteXformaPago(idFormaPago,monto,idCliente
)values(1,100,1),(2,150,2);


insert into inventario(idArticulo,idMatriz,idBodega,idInventario,cantidad,nombre) values(1,1,1,1,5,"articulo1"),(2,2,1,2,10,"articulo2");



