-- MySQL Script generated by MySQL Workbench
-- Thu Jun  6 11:27:49 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema gkei_mail
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gkei_mail
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gkei_mail` DEFAULT CHARACTER SET utf8 ;
USE `gkei_mail` ;

-- -----------------------------------------------------
-- Table `gkei_mail`.`AddressType`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gkei_mail`.`AddressType` (
  `AddressTypeID` INT NOT NULL AUTO_INCREMENT,
  `AddressTypeName` VARCHAR(45) NOT NULL,
  `BuiltInType` VARCHAR(45) NOT NULL,
  `CreateDate` DATETIME NULL,
  `SuperTypeID` INT NULL,
  UNIQUE INDEX `AddressTypeID_UNIQUE` (`AddressTypeID` ASC) VISIBLE,
  INDEX `fk_AddressType_AddressType_idx` (`SuperTypeID` ASC) VISIBLE,
  PRIMARY KEY (`AddressTypeID`),
  CONSTRAINT `fk_AddressType_AddressType`
    FOREIGN KEY (`SuperTypeID`)
    REFERENCES `gkei_mail`.`AddressType` (`AddressTypeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gkei_mail`.`PurposeType`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gkei_mail`.`PurposeType` (
  `PurposeTypeID` INT NOT NULL,
  `PurposeTypeName` VARCHAR(45) NOT NULL,
  `MashiMashiType` VARCHAR(45) NOT NULL,
  `BuiltInType` VARCHAR(45) NOT NULL,
  `SuperTypeID` INT NULL,
  `CreateDate` DATETIME NULL,
  PRIMARY KEY (`PurposeTypeID`),
  UNIQUE INDEX `ContentCategoryID_UNIQUE` (`PurposeTypeID` ASC) VISIBLE,
  INDEX `fk_ContentType_ContentType1_idx` (`SuperTypeID` ASC) VISIBLE,
  CONSTRAINT `fk_ContentType_ContentType1`
    FOREIGN KEY (`SuperTypeID`)
    REFERENCES `gkei_mail`.`PurposeType` (`PurposeTypeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gkei_mail`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gkei_mail`.`User` (
  `UserID` INT NOT NULL,
  `FirstName` VARCHAR(45) NOT NULL,
  `LastName` VARCHAR(45) NOT NULL,
  `Gender` VARCHAR(45) NOT NULL,
  `Occupation` VARCHAR(45) NULL,
  `Organization` VARCHAR(45) NULL,
  `Depeartment` VARCHAR(45) NULL,
  `Signature` VARCHAR(400) NULL,
  PRIMARY KEY (`UserID`),
  UNIQUE INDEX `UserID_UNIQUE` (`UserID` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gkei_mail`.`Template`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gkei_mail`.`Template` (
  `TemplateID` INT NOT NULL,
  `TemplateName` VARCHAR(45) NOT NULL,
  `TemplateContent` VARCHAR(1000) NOT NULL,
  `CreateDate` DATETIME NOT NULL,
  `MashiMashiValue` INT NOT NULL,
  `BuiltInType` VARCHAR(45) NOT NULL,
  `AddressTypeID` INT NOT NULL,
  `PurposeTypeID` INT NOT NULL,
  `UserID` INT NOT NULL,
  PRIMARY KEY (`TemplateID`),
  UNIQUE INDEX `TemplateID_UNIQUE` (`TemplateID` ASC) VISIBLE,
  INDEX `fk_Template_AddressType1_idx` (`AddressTypeID` ASC) VISIBLE,
  INDEX `fk_Template_PurposeType1_idx` (`PurposeTypeID` ASC) VISIBLE,
  INDEX `fk_Template_User1_idx` (`UserID` ASC) VISIBLE,
  CONSTRAINT `fk_Template_AddressType1`
    FOREIGN KEY (`AddressTypeID`)
    REFERENCES `gkei_mail`.`AddressType` (`AddressTypeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Template_PurposeType1`
    FOREIGN KEY (`PurposeTypeID`)
    REFERENCES `gkei_mail`.`PurposeType` (`PurposeTypeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Template_User1`
    FOREIGN KEY (`UserID`)
    REFERENCES `gkei_mail`.`User` (`UserID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gkei_mail`.`Jikou`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gkei_mail`.`Jikou` (
  `JikouID` INT NOT NULL,
  `JikouContent` VARCHAR(1000) NOT NULL,
  `BeginMonth` INT NOT NULL,
  `EndMonth` INT NOT NULL,
  PRIMARY KEY (`JikouID`),
  UNIQUE INDEX `JikouID_UNIQUE` (`JikouID` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gkei_mail`.`Keyword`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gkei_mail`.`Keyword` (
  `KeywordID` INT NOT NULL,
  `CreateDate` DATETIME NULL,
  `KeywordContent` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`KeywordID`),
  UNIQUE INDEX `KeywordID_UNIQUE` (`KeywordID` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gkei_mail`.`TemplateKeyword`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gkei_mail`.`TemplateKeyword` (
  `TemplateKeywordID` INT NOT NULL,
  `KeywordID` INT NOT NULL,
  `TemplateID` INT NOT NULL,
  INDEX `fk_TemplateKeyword_Keyword1_idx` (`KeywordID` ASC) VISIBLE,
  INDEX `fk_TemplateKeyword_Template1_idx` (`TemplateID` ASC) VISIBLE,
  PRIMARY KEY (`TemplateKeywordID`),
  UNIQUE INDEX `TemplateKeywordID_UNIQUE` (`TemplateKeywordID` ASC) VISIBLE,
  CONSTRAINT `fk_TemplateKeyword_Keyword1`
    FOREIGN KEY (`KeywordID`)
    REFERENCES `gkei_mail`.`Keyword` (`KeywordID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TemplateKeyword_Template1`
    FOREIGN KEY (`TemplateID`)
    REFERENCES `gkei_mail`.`Template` (`TemplateID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gkei_mail`.`LikeAction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gkei_mail`.`LikeAction` (
  `LikeActionID` INT NOT NULL,
  `CreateDate` DATETIME NULL,
  `UserID` INT NOT NULL,
  `TemplateID` INT NOT NULL,
  PRIMARY KEY (`LikeActionID`),
  UNIQUE INDEX `LikeActionID_UNIQUE` (`LikeActionID` ASC) VISIBLE,
  INDEX `fk_LikeAction_User1_idx` (`UserID` ASC) VISIBLE,
  INDEX `fk_LikeAction_Template1_idx` (`TemplateID` ASC) VISIBLE,
  CONSTRAINT `fk_LikeAction_User1`
    FOREIGN KEY (`UserID`)
    REFERENCES `gkei_mail`.`User` (`UserID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_LikeAction_Template1`
    FOREIGN KEY (`TemplateID`)
    REFERENCES `gkei_mail`.`Template` (`TemplateID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gkei_mail`.`Mail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gkei_mail`.`Mail` (
  `MailID` INT NOT NULL,
  `To` VARCHAR(200) NOT NULL,
  `From` VARCHAR(200) NOT NULL,
  `Cc` VARCHAR(200) NULL,
  `Bcc` VARCHAR(200) NULL,
  `MessageID` INT NULL,
  `Subject` VARCHAR(200) NULL,
  `Keywords` VARCHAR(200) NULL,
  `Comments` VARCHAR(200) NULL,
  `Date` DATETIME NULL,
  `MimeVersion` VARCHAR(45) NULL,
  `UserID` INT NOT NULL,
  PRIMARY KEY (`MailID`),
  UNIQUE INDEX `MailID_UNIQUE` (`MailID` ASC) VISIBLE,
  INDEX `fk_Mail_User1_idx` (`UserID` ASC) VISIBLE,
  CONSTRAINT `fk_Mail_User1`
    FOREIGN KEY (`UserID`)
    REFERENCES `gkei_mail`.`User` (`UserID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gkei_mail`.`MailContent`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gkei_mail`.`MailContent` (
  `MailContentID` INT NOT NULL,
  `ContentID` INT NOT NULL,
  `ContentType` VARCHAR(200) NOT NULL,
  `ContentTransferEncoding` VARCHAR(200) NOT NULL,
  `ContentBinary` VARCHAR(4000) NOT NULL,
  `MailID` INT NOT NULL,
  PRIMARY KEY (`MailContentID`),
  UNIQUE INDEX `MailContentID_UNIQUE` (`MailContentID` ASC) VISIBLE,
  INDEX `fk_MailContent_Mail1_idx` (`MailID` ASC) VISIBLE,
  CONSTRAINT `fk_MailContent_Mail1`
    FOREIGN KEY (`MailID`)
    REFERENCES `gkei_mail`.`Mail` (`MailID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
