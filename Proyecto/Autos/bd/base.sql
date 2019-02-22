/*
SQLyog Enterprise - MySQL GUI v7.1 
MySQL - 5.0.45-community-nt : Database - pro_visual
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`pro_visual` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_general_ci */;

USE `pro_visual`;

/*Table structure for table `almacen` */

DROP TABLE IF EXISTS `almacen`;

CREATE TABLE `almacen` (
  `nro_entrada` int(4) NOT NULL auto_increment,
  `idproducto` int(4) NOT NULL,
  `cantidad` varchar(11) NOT NULL default '',
  `fecha_ingreso` varchar(15) NOT NULL,
  `hora_ingreso` varchar(15) NOT NULL,
  `fecha_caducidad` date NOT NULL,
  `precio_compra` double NOT NULL,
  PRIMARY KEY  (`nro_entrada`),
  KEY `ALMACEN_FKIndex1` (`idproducto`),
  KEY `nom_pedido` (`nro_entrada`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

/*Data for the table `almacen` */

insert  into `almacen`(`nro_entrada`,`idproducto`,`cantidad`,`fecha_ingreso`,`hora_ingreso`,`fecha_caducidad`,`precio_compra`) values (1,2,'540','2009-10-02','03:30:05','2008-04-10',0.5),(2,1,'100','2009-10-02','05:12:14','2008-05-14',25.4),(3,3,'250','2009-10-02','04:16:13','2008-07-21',0.6),(4,1,'12','2009-11-23','18:24:14','2010-10-13',25.6),(5,2,'10','2009-11-23','18:32:55','2010-07-15',25.8),(6,3,'50','2009-11-23','18:35:07','2010-05-23',0.5),(7,4,'50','2009-11-23','15:12:14','2010-06-10',14.5),(8,5,'180','2009-11-24','16:30:09','2001-03-11',2.3),(9,6,'230','2009-11-24','14:22:08','2010-05-12',10.5),(10,7,'350','2009-11-24','12:09:00','2011-03-10',8.9),(11,0,'120','2009-11-25','11:34:13','2009-11-30',17.5),(12,9,'200','2009-11-25','02:03:25','2010-12-03',35.9),(13,10,'340','2009-11-25','13:32:00','2009-12-30',2.01),(14,1,'12','2009-11-28','05:00','2009-12-31',23),(15,2,'15','2009-11-28','12:59:23','2010-01-12',33),(16,6,'3','2010-6-19','17:47:40','2010-06-19',32),(17,1,'23','2010-6-27','10:26:37','2010-06-26',50),(18,0,'20','2010-6-27','23:31:19','2011-12-05',1),(19,0,'20','2010-6-27','23:51:17','2013-11-12',0.6),(20,4,'12','2010-6-28','00:13:15','2015-12-10',0.4);

/*Table structure for table `auto` */

DROP TABLE IF EXISTS `auto`;

CREATE TABLE `auto` (
  `idventa` int(4) NOT NULL auto_increment,
  `idcliente` int(4) NOT NULL,
  `idmarca` int(4) NOT NULL,
  `idmodelo` int(4) NOT NULL,
  `comprobante` varchar(7) collate latin1_general_ci NOT NULL,
  `ruc` varchar(11) collate latin1_general_ci NOT NULL,
  `tipo` varchar(20) collate latin1_general_ci NOT NULL,
  `color` varchar(10) collate latin1_general_ci NOT NULL,
  `cantidad` int(3) NOT NULL,
  `total` varchar(8) collate latin1_general_ci NOT NULL,
  `fecha` varchar(10) collate latin1_general_ci NOT NULL,
  `hora` varchar(8) collate latin1_general_ci NOT NULL,
  PRIMARY KEY  (`idventa`),
  KEY `idcliente` (`idcliente`,`idmarca`,`idmodelo`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

/*Data for the table `auto` */

insert  into `auto`(`idventa`,`idcliente`,`idmarca`,`idmodelo`,`comprobante`,`ruc`,`tipo`,`color`,`cantidad`,`total`,`fecha`,`hora`) values (1,1,1,2,'Factura','98765412301','Camioneta','Verde',1,'jLabel4','',''),(2,1,1,2,'Boleta','98765412301','Camioneta','Verde',1,'jLabel4','',''),(3,1,2,1,'Factura','25874196301','Todo Terreno','Negro',2,'jLabel4','2010-12-4','02:31:30'),(4,1,2,1,'Factura','25413698741','Camioneta','Verde',4,'6320','2010-12-4','03:17:43');

/*Table structure for table `clientes` */

DROP TABLE IF EXISTS `clientes`;

CREATE TABLE `clientes` (
  `idcliente` int(4) NOT NULL auto_increment,
  `dni` varchar(8) collate latin1_general_ci NOT NULL default '',
  `nombre` varchar(20) collate latin1_general_ci NOT NULL,
  `apellidos` varchar(20) collate latin1_general_ci NOT NULL,
  `direccion` varchar(25) collate latin1_general_ci NOT NULL,
  `telefono` varchar(12) collate latin1_general_ci NOT NULL,
  PRIMARY KEY  (`idcliente`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

/*Data for the table `clientes` */

insert  into `clientes`(`idcliente`,`dni`,`nombre`,`apellidos`,`direccion`,`telefono`) values (1,'12345678','Juan Manuel','Vegas More','Nvo. Chimbote','943012541');

/*Table structure for table `detalle_venta` */

DROP TABLE IF EXISTS `detalle_venta`;

CREATE TABLE `detalle_venta` (
  `id_detalle` int(4) NOT NULL auto_increment,
  `idproducto` int(4) NOT NULL,
  `id_venta` int(4) NOT NULL,
  `cantidad` int(10) NOT NULL,
  PRIMARY KEY  (`id_detalle`),
  KEY `DETALLE_VENTA_FKIndex1` (`id_venta`),
  KEY `DETALLE_VENTA_FKIndex2` (`idproducto`)
) ENGINE=MyISAM AUTO_INCREMENT=48 DEFAULT CHARSET=latin1;

/*Data for the table `detalle_venta` */

/*Table structure for table `marca` */

DROP TABLE IF EXISTS `marca`;

CREATE TABLE `marca` (
  `idmarca` int(4) NOT NULL,
  `nombre` varchar(20) collate latin1_general_ci NOT NULL,
  PRIMARY KEY  (`idmarca`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

/*Data for the table `marca` */

insert  into `marca`(`idmarca`,`nombre`) values (1,'Toyota'),(2,'Nissan'),(3,'Tico'),(4,'Corolla');

/*Table structure for table `modelo` */

DROP TABLE IF EXISTS `modelo`;

CREATE TABLE `modelo` (
  `idmodelo` int(4) NOT NULL auto_increment,
  `idmarca` int(4) NOT NULL,
  `descripcion` varchar(25) collate latin1_general_ci NOT NULL,
  `tiempo` varchar(4) collate latin1_general_ci NOT NULL,
  `precio` double NOT NULL,
  `color` varchar(15) collate latin1_general_ci NOT NULL,
  `velocidad` varchar(7) collate latin1_general_ci NOT NULL,
  `tipo` varchar(15) collate latin1_general_ci NOT NULL,
  PRIMARY KEY  (`idmodelo`),
  KEY `idmarca` (`idmarca`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

/*Data for the table `modelo` */

insert  into `modelo`(`idmodelo`,`idmarca`,`descripcion`,`tiempo`,`precio`,`color`,`velocidad`,`tipo`) values (1,2,'4x4','2002',1580,'Rojo','0 km/s','Camioneta'),(2,1,'Station','2000',205,'Blanco','0 Km/s','Carabinero');

/*Table structure for table `productos` */

DROP TABLE IF EXISTS `productos`;

CREATE TABLE `productos` (
  `idproducto` int(4) NOT NULL auto_increment,
  `nombre` varchar(15) collate latin1_general_ci NOT NULL,
  `descripcion` varchar(50) collate latin1_general_ci NOT NULL,
  `precio` double NOT NULL,
  `stock` int(5) NOT NULL,
  PRIMARY KEY  (`idproducto`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

/*Data for the table `productos` */

insert  into `productos`(`idproducto`,`nombre`,`descripcion`,`precio`,`stock`) values (1,'a','Ahora siiiiiiiiiiiii\nofpghpfkphkfgh',12,3),(2,'aaaaa','aaaa',12,43);

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `idusuario` int(4) NOT NULL auto_increment,
  `nombre` varchar(25) collate latin1_general_ci NOT NULL,
  `apellidos` varchar(25) collate latin1_general_ci NOT NULL,
  `dni` varchar(8) collate latin1_general_ci NOT NULL,
  `telefono` varchar(12) collate latin1_general_ci NOT NULL,
  `direccion` varchar(25) collate latin1_general_ci NOT NULL,
  `nom_usuario` varchar(10) collate latin1_general_ci NOT NULL,
  `pass` varchar(6) collate latin1_general_ci NOT NULL,
  PRIMARY KEY  (`idusuario`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

/*Data for the table `usuario` */

insert  into `usuario`(`idusuario`,`nombre`,`apellidos`,`dni`,`telefono`,`direccion`,`nom_usuario`,`pass`) values (1,'Elizabeth','Sanchez','12345678','943005708','Santa Cruz','dorcas','123456'),(2,'Styven','Roman Riojas','42760775','944985926','Coishco','styven','311284');

/*Table structure for table `venta` */

DROP TABLE IF EXISTS `venta`;

CREATE TABLE `venta` (
  `id_venta` int(4) unsigned NOT NULL auto_increment,
  `idcliente` int(4) NOT NULL,
  `idproducto` int(4) NOT NULL,
  `cantidad` varchar(5) default NULL,
  `fecha` varchar(15) NOT NULL,
  `total` double NOT NULL,
  `hora` varchar(15) NOT NULL,
  `comprobante` varchar(20) NOT NULL default '',
  PRIMARY KEY  (`id_venta`),
  KEY `VENTA_FKIndex1` (`idcliente`)
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

/*Data for the table `venta` */

insert  into `venta`(`id_venta`,`idcliente`,`idproducto`,`cantidad`,`fecha`,`total`,`hora`,`comprobante`) values (22,1,1,'1','2010-12-4',12,'06:10:25','Factura'),(24,1,1,'2','2010-12-4',24,'06:21:57','Boleta');

/* Procedure structure for procedure `busrep` */

/*!50003 DROP PROCEDURE IF EXISTS  `busrep` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `busrep`(nombre varchar(20))
BEGIN
	select *
	from productos
	where nombre like concat(nombre,"%");
    END */$$
DELIMITER ;

/* Procedure structure for procedure `edita_cliente` */

/*!50003 DROP PROCEDURE IF EXISTS  `edita_cliente` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `edita_cliente`(dn varchar(8),nom varchar(20),ape varchar(20),dir varchar(25),tel varchar(12))
BEGIN
	update clientes
	SET dni=dn,nombre=nom,apellidos=ape,direccion=dir,telefono=tel
	;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `edita_mod` */

/*!50003 DROP PROCEDURE IF EXISTS  `edita_mod` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `edita_mod`( marca INT(4),des VARCHAR(50),an varchar(4),pre VARCHAR(7), col VARCHAR(10), vel VARCHAR(6),tip VARCHAR(15))
BEGIN
	update modelo
	SET idmarca=marca,descripcion=des,año=an,precio=pre,color=col,velocidad=vel,tipo=tip
	WHERE idmodelo=cod;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `edita_rep` */

/*!50003 DROP PROCEDURE IF EXISTS  `edita_rep` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `edita_rep`(nom varchar(25),des varchar(50), pre double, st int(5))
BEGIN
	update productos
	SET nombre=nom,descripcion=des,precio=pre,stock=st;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `graba_cliente` */

/*!50003 DROP PROCEDURE IF EXISTS  `graba_cliente` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `graba_cliente`(dn varchar(8),nom varchar(20),ape varchar(20),dir varchar(25),tel varchar(12))
BEGIN
	INSERT INTO clientes(dni,nombre,apellidos,direccion,telefono)VALUES(dn,nom,ape,dir,tel);
    END */$$
DELIMITER ;

/* Procedure structure for procedure `graba_repuesto` */

/*!50003 DROP PROCEDURE IF EXISTS  `graba_repuesto` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `graba_repuesto`(nom varchar(15),des varchar(50),pre double,st int(5))
BEGIN
	INSERT INTO productos(nombre,descripcion, precio,stock)VALUES(nom,des,pre,st);
    END */$$
DELIMITER ;

/* Procedure structure for procedure `graba_user` */

/*!50003 DROP PROCEDURE IF EXISTS  `graba_user` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `graba_user`(nom varchar(25),ape varchar(25),dn varchar(8),tel varchar(12), dir varchar(25), us varchar(10), contra varchar(6))
BEGIN
	INSERT INTO usuario(nombre,apellidos,dni,telefono,direccion,nom_usuario,pass)VALUES(nom,ape,dn,tel,dir,us,contra);
    END */$$
DELIMITER ;

/* Procedure structure for procedure `graba_ven` */

/*!50003 DROP PROCEDURE IF EXISTS  `graba_ven` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `graba_ven`(cli int(4),pro int(4),can varchar(5),fec varchar(10),hor varchar(10),tot varchar(5),com varchar(7))
BEGIN
	INSERT INTO venta(idcliente,idproducto,cantidad,fecha,hora,total,comprobante)VALUES(cli,pro,can,fec,hor,tot,com);
    END */$$
DELIMITER ;

/* Procedure structure for procedure `graba_v_auto` */

/*!50003 DROP PROCEDURE IF EXISTS  `graba_v_auto` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `graba_v_auto`(cli int(4),marc int(4),model int(4),comp varchar(7),ruc varchar(11),tip varchar(20),col varchar(10),can int(3),tot varchar(8),fec varchar(10),hor varchar(10))
BEGIN
	INSERT INTO auto(idcliente,idmarca,idmodelo,comprobante,ruc,tipo,color,cantidad,total,fecha,hora)VALUES(cli,marc,model,comp,ruc,tip,col,can,tot,fec,hor);
    END */$$
DELIMITER ;

/* Procedure structure for procedure `ingreso_pro` */

/*!50003 DROP PROCEDURE IF EXISTS  `ingreso_pro` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `ingreso_pro`(codp int(4))
BEGIN
	select sum(cantidad)as Salida
	from almacen
	where idproducto=codp;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `login` */

/*!50003 DROP PROCEDURE IF EXISTS  `login` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `login`()
BEGIN
	select concat(nombre,' ',apellidos) as datos,nom_usuario,pass from usuario;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `precio` */

/*!50003 DROP PROCEDURE IF EXISTS  `precio` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `precio`(des varchar(15))
BEGIN
	SELECT modelo.precio as total from modelo 
	where modelo.descripcion=des;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `salida_pro` */

/*!50003 DROP PROCEDURE IF EXISTS  `salida_pro` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `salida_pro`(codp int(4))
BEGIN
	select sum(dv.cantidad)as Salida
	from detalle_venta dv
	where dv.idproducto=codp;
    END */$$
DELIMITER ;

/*Table structure for table `ver_modelo` */

DROP TABLE IF EXISTS `ver_modelo`;

/*!50001 DROP VIEW IF EXISTS `ver_modelo` */;
/*!50001 DROP TABLE IF EXISTS `ver_modelo` */;

/*!50001 CREATE TABLE `ver_modelo` (
  `marca` varchar(20) collate latin1_general_ci NOT NULL,
  `descripcion` varchar(25) collate latin1_general_ci NOT NULL,
  `tiempo` varchar(4) collate latin1_general_ci NOT NULL,
  `precio` double NOT NULL,
  `color` varchar(15) collate latin1_general_ci NOT NULL,
  `velocidad` varchar(7) collate latin1_general_ci NOT NULL,
  `tipo` varchar(15) collate latin1_general_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci */;

/*View structure for view ver_modelo */

/*!50001 DROP TABLE IF EXISTS `ver_modelo` */;
/*!50001 DROP VIEW IF EXISTS `ver_modelo` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `ver_modelo` AS select `marca`.`nombre` AS `marca`,`modelo`.`descripcion` AS `descripcion`,`modelo`.`tiempo` AS `tiempo`,`modelo`.`precio` AS `precio`,`modelo`.`color` AS `color`,`modelo`.`velocidad` AS `velocidad`,`modelo`.`tipo` AS `tipo` from (`modelo` join `marca` on((`modelo`.`idmarca` = `marca`.`idmarca`))) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
