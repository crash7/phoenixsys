-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 09-12-2010 a las 20:26:48
-- Versión del servidor: 5.1.41
-- Versión de PHP: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `phoenix`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE IF NOT EXISTS `clientes` (
  `idCliente` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) DEFAULT NULL,
  `Apellido` varchar(50) DEFAULT NULL,
  `Documento` varchar(15) DEFAULT NULL,
  `CUIT` varchar(12) DEFAULT NULL,
  `Direccion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=16 ;

--
-- Volcar la base de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`idCliente`, `Nombre`, `Apellido`, `Documento`, `CUIT`, `Direccion`) VALUES
(1, 'Leandro', 'Cid', '3333333', '20-3333333-3', 'Su casa 29A'),
(2, 'Christian', 'Musa', '34454897', '20-34454897-', 'Mi motorhome'),
(3, 'Majud', 'Mulaj', '124235348', '23948239*234', 'suelo arabe'),
(4, 'Dummy', 'Dummy', '3115544', '20-34454897-', 'Dummiyy'),
(5, 'Dummy', 'Dummy', '3115544', '20-34454897-', 'Dummiyy'),
(6, 'Dummy', 'Dummy', '3115544', '20-34454897-', 'Dummiyy'),
(7, 'Dummy', 'Dummy', '3115544', '20-34454897-', 'Dummiyy'),
(8, 'Dummy', 'Dummy', '3115544', '20-34454897-', 'Dummiyy'),
(9, 'Dummy', 'Dummy', '3115544', '20-34454897-', 'Dummiyy'),
(10, 'Dummy', 'Dummy', '3115544', '20-34454897-', 'Dummiyy'),
(11, 'Dummy', 'Dummy', '3115544', '20-34454897-', 'Dummiyy'),
(12, 'Dummy', 'Dummy', '3115544', '20-34454897-', 'Dummiyy'),
(13, 'Dummy', 'Dummy', '3115544', '20-34454897-', 'Dummiyy'),
(14, 'Dummy', 'Dummy', '3115544', '20-34454897-', 'Dummiyy'),
(15, 'Dummy', 'Dummy', '3115544', '20-34454897-', 'Dummiyy');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallepresupuestos`
--

DROP TABLE IF EXISTS `detallepresupuestos`;
CREATE TABLE IF NOT EXISTS `detallepresupuestos` (
  `Presupuestos_idPresupuesto` int(10) unsigned NOT NULL,
  `idLinea` int(10) unsigned NOT NULL,
  `Materiales_idMaterial` int(10) unsigned NOT NULL,
  `EstadoPresupuesto` int(10) unsigned NOT NULL,
  `Cantidad` int(10) DEFAULT NULL,
  `PrecioUnitario` float DEFAULT NULL,
  `Importe` float DEFAULT NULL,
  PRIMARY KEY (`Presupuestos_idPresupuesto`,`idLinea`),
  KEY `materiales` (`Materiales_idMaterial`),
  KEY `presupuestos` (`Presupuestos_idPresupuesto`),
  KEY `estado` (`EstadoPresupuesto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcar la base de datos para la tabla `detallepresupuestos`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historialordenes`
--

DROP TABLE IF EXISTS `historialordenes`;
CREATE TABLE IF NOT EXISTS `historialordenes` (
  `idHistorial` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Ordenes_idOrden` int(10) unsigned NOT NULL,
  `TiposHistorial_idTipoHistorial` int(10) unsigned NOT NULL,
  `Comentario` varchar(70) DEFAULT NULL,
  `Fecha` date DEFAULT NULL,
  PRIMARY KEY (`idHistorial`),
  KEY `order` (`Ordenes_idOrden`),
  KEY `tipos` (`TiposHistorial_idTipoHistorial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `historialordenes`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materiales`
--

DROP TABLE IF EXISTS `materiales`;
CREATE TABLE IF NOT EXISTS `materiales` (
  `idMaterial` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Material` varchar(20) DEFAULT NULL,
  `PrecioUnitario` float DEFAULT NULL,
  PRIMARY KEY (`idMaterial`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Volcar la base de datos para la tabla `materiales`
--

INSERT INTO `materiales` (`idMaterial`, `Material`, `PrecioUnitario`) VALUES
(1, 'uno', 2.256),
(2, 'uno', 2.256),
(3, 'uno', 2.256),
(4, 'uno', 2.256),
(5, 'uno', 2.256);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ordenes`
--

DROP TABLE IF EXISTS `ordenes`;
CREATE TABLE IF NOT EXISTS `ordenes` (
  `idOrden` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Clientes_idCliente` int(10) unsigned NOT NULL,
  `Descripcion` varchar(50) DEFAULT NULL,
  `FechaCreacion` date DEFAULT NULL,
  `MontoRestante` int(10) DEFAULT NULL,
  `EstadoActual` int(10) unsigned NOT NULL,
  `LugarEntrega` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idOrden`),
  KEY `clientes` (`Clientes_idCliente`),
  KEY `tipos h` (`EstadoActual`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Volcar la base de datos para la tabla `ordenes`
--

INSERT INTO `ordenes` (`idOrden`, `Clientes_idCliente`, `Descripcion`, `FechaCreacion`, `MontoRestante`, `EstadoActual`, `LugarEntrega`) VALUES
(1, 1, 'Hla munasd', '2010-12-04', 1000, 2, 'puedo editar son todos re putos manga de cagones'),
(2, 1, 'ToolTipText', '2010-12-09', 0, 1, 'ToolTipText'),
(3, 1, 'ToolTipText', '2010-12-09', 0, 1, 'ToolTipText'),
(4, 1, 'ToolTipText', '2010-12-09', 0, 1, 'ToolTipText'),
(5, 2, '2', '2010-12-09', 0, 1, '2'),
(6, 7, 'me cago en los chinos', '2010-12-09', 0, 2, 'putos'),
(7, 3, 'adsad', '2010-12-09', 0, 1, 'asdasd');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `presupuestos`
--

DROP TABLE IF EXISTS `presupuestos`;
CREATE TABLE IF NOT EXISTS `presupuestos` (
  `idPresupuesto` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Ordenes_idOrden` int(10) unsigned NOT NULL,
  `FechaCreacion` date DEFAULT NULL,
  `Vencimiento` date DEFAULT NULL,
  `FichaTecnica` text,
  PRIMARY KEY (`idPresupuesto`),
  KEY `ordenes` (`Ordenes_idOrden`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `presupuestos`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `testing`
--

DROP TABLE IF EXISTS `testing`;
CREATE TABLE IF NOT EXISTS `testing` (
  `idTable` int(10) NOT NULL AUTO_INCREMENT,
  `Test` varchar(100) NOT NULL,
  PRIMARY KEY (`idTable`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `testing`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tiposhistorial`
--

DROP TABLE IF EXISTS `tiposhistorial`;
CREATE TABLE IF NOT EXISTS `tiposhistorial` (
  `idTipoHistorial` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `TipoHistorial` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idTipoHistorial`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Volcar la base de datos para la tabla `tiposhistorial`
--

INSERT INTO `tiposhistorial` (`idTipoHistorial`, `TipoHistorial`) VALUES
(1, 'Nueva orden'),
(2, 'Todosputos'),
(3, 'Prendida fuego');

--
-- Filtros para las tablas descargadas (dump)
--

--
-- Filtros para la tabla `detallepresupuestos`
--
ALTER TABLE `detallepresupuestos`
  ADD CONSTRAINT `estado` FOREIGN KEY (`EstadoPresupuesto`) REFERENCES `tiposhistorial` (`idTipoHistorial`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `materiales` FOREIGN KEY (`Materiales_idMaterial`) REFERENCES `materiales` (`idMaterial`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `presupuestos` FOREIGN KEY (`Presupuestos_idPresupuesto`) REFERENCES `presupuestos` (`idPresupuesto`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `historialordenes`
--
ALTER TABLE `historialordenes`
  ADD CONSTRAINT `order` FOREIGN KEY (`Ordenes_idOrden`) REFERENCES `ordenes` (`idOrden`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tipos` FOREIGN KEY (`TiposHistorial_idTipoHistorial`) REFERENCES `tiposhistorial` (`idTipoHistorial`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `ordenes`
--
ALTER TABLE `ordenes`
  ADD CONSTRAINT `clientes` FOREIGN KEY (`Clientes_idCliente`) REFERENCES `clientes` (`idCliente`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tipos h` FOREIGN KEY (`EstadoActual`) REFERENCES `tiposhistorial` (`idTipoHistorial`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `presupuestos`
--
ALTER TABLE `presupuestos`
  ADD CONSTRAINT `ordenes` FOREIGN KEY (`Ordenes_idOrden`) REFERENCES `ordenes` (`idOrden`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
