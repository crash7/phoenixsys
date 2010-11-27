SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `phoenix` ;
CREATE SCHEMA IF NOT EXISTS `phoenix` DEFAULT CHARACTER SET utf8 ;
USE `phoenix` ;

-- -----------------------------------------------------
-- Table `phoenix`.`Clientes`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `phoenix`.`Clientes` (
  `idCliente` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `Nombre` VARCHAR(50) NULL DEFAULT NULL ,
  `Apellido` VARCHAR(50) NULL DEFAULT NULL ,
  `Documento` VARCHAR(15) NULL DEFAULT NULL ,
  `CUIT` VARCHAR(12) NULL DEFAULT NULL ,
  `Direccion` VARCHAR(50) NULL DEFAULT NULL ,
  PRIMARY KEY (`idCliente`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `phoenix`.`Materiales`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `phoenix`.`Materiales` (
  `idMaterial` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `Material` VARCHAR(20) NULL DEFAULT NULL ,
  `PrecioUnitario` FLOAT NULL DEFAULT NULL ,
  PRIMARY KEY (`idMaterial`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `phoenix`.`TiposHistorial`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `phoenix`.`TiposHistorial` (
  `idTipoHistorial` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `TipoHistorial` VARCHAR(20) NULL DEFAULT NULL ,
  PRIMARY KEY (`idTipoHistorial`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `phoenix`.`Ordenes`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `phoenix`.`Ordenes` (
  `idOrden` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `Clientes_idCliente` INT(10) UNSIGNED NOT NULL ,
  `Descripcion` VARCHAR(50) NULL ,
  `FechaCreacion` DATE NULL ,
  `MontoRestante` INT(10) NULL ,
  `EstadoActual` INT(10) UNSIGNED NOT NULL ,
  `LugarEntrega` VARCHAR(50) NULL ,
  PRIMARY KEY (`idOrden`) ,
  INDEX `clientes` (`Clientes_idCliente` ASC) ,
  INDEX `tipos h` (`EstadoActual` ASC) ,
  CONSTRAINT `clientes`
    FOREIGN KEY (`Clientes_idCliente` )
    REFERENCES `phoenix`.`Clientes` (`idCliente` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `tipos h`
    FOREIGN KEY (`EstadoActual` )
    REFERENCES `phoenix`.`TiposHistorial` (`idTipoHistorial` )
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `phoenix`.`testing`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `phoenix`.`testing` (
  `idTable` INT(10) NOT NULL AUTO_INCREMENT ,
  `Test` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`idTable`) )
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `phoenix`.`HistorialOrdenes`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `phoenix`.`HistorialOrdenes` (
  `idHistorial` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `Ordenes_idOrden` INT(10) UNSIGNED NOT NULL ,
  `TiposHistorial_idTipoHistorial` INT(10) UNSIGNED NOT NULL ,
  `Comentario` VARCHAR(70) NULL ,
  `Fecha` DATE NULL ,
  PRIMARY KEY (`idHistorial`) ,
  INDEX `order` (`Ordenes_idOrden` ASC) ,
  INDEX `tipos` (`TiposHistorial_idTipoHistorial` ASC) ,
  CONSTRAINT `order`
    FOREIGN KEY (`Ordenes_idOrden` )
    REFERENCES `phoenix`.`Ordenes` (`idOrden` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `tipos`
    FOREIGN KEY (`TiposHistorial_idTipoHistorial` )
    REFERENCES `phoenix`.`TiposHistorial` (`idTipoHistorial` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `phoenix`.`Presupuestos`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `phoenix`.`Presupuestos` (
  `idPresupuesto` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `Ordenes_idOrden` INT(10) UNSIGNED NOT NULL ,
  `FechaCreacion` DATE NULL ,
  `Vencimiento` DATE NULL ,
  `FichaTecnica` TEXT NULL ,
  PRIMARY KEY (`idPresupuesto`) ,
  INDEX `ordenes` (`Ordenes_idOrden` ASC) ,
  CONSTRAINT `ordenes`
    FOREIGN KEY (`Ordenes_idOrden` )
    REFERENCES `phoenix`.`Ordenes` (`idOrden` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `phoenix`.`DetallePresupuestos`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `phoenix`.`DetallePresupuestos` (
  `Presupuestos_idPresupuesto` INT(10) UNSIGNED NOT NULL ,
  `idLinea` INT(10) UNSIGNED NOT NULL ,
  `Materiales_idMaterial` INT(10) UNSIGNED NOT NULL ,
  `EstadoPresupuesto` INT(10) UNSIGNED NOT NULL ,
  `Cantidad` INT(10) NULL ,
  `PrecioUnitario` FLOAT NULL ,
  `Importe` FLOAT NULL ,
  PRIMARY KEY (`Presupuestos_idPresupuesto`, `idLinea`) ,
  INDEX `materiales` (`Materiales_idMaterial` ASC) ,
  INDEX `presupuestos` (`Presupuestos_idPresupuesto` ASC) ,
  INDEX `estado` (`EstadoPresupuesto` ASC) ,
  CONSTRAINT `materiales`
    FOREIGN KEY (`Materiales_idMaterial` )
    REFERENCES `phoenix`.`Materiales` (`idMaterial` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `presupuestos`
    FOREIGN KEY (`Presupuestos_idPresupuesto` )
    REFERENCES `phoenix`.`Presupuestos` (`idPresupuesto` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `estado`
    FOREIGN KEY (`EstadoPresupuesto` )
    REFERENCES `phoenix`.`TiposHistorial` (`idTipoHistorial` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
