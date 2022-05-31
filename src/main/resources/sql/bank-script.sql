-- Bank Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bank
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bank
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bank` DEFAULT CHARACTER SET utf8 ;
USE `bank` ;

-- -----------------------------------------------------
-- Table `bank`.`Accounts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bank`.`Accounts` (
  `idAccounts` INT NOT NULL AUTO_INCREMENT,
  `balance` DOUBLE NOT NULL,
  `cbu` DOUBLE NOT NULL,
  `alias` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAccounts`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bank`.`Phones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bank`.`Phones` (
  `idPhones` INT NOT NULL AUTO_INCREMENT,
  `number` DOUBLE NOT NULL,
  `client_id` INT,
  PRIMARY KEY (`idPhones`),
  INDEX `fk_Phones_Clients1_idx` (`client_id` ASC) VISIBLE,
  CONSTRAINT `fk_Phones_Clients1`
    FOREIGN KEY (`client_id`)
    REFERENCES `bank`.`Clients` (`idClients`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bank`.`Managers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bank`.`Managers` (
  `idManagers` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `phone_id` INT NOT NULL,
  PRIMARY KEY (`idManagers`),
  INDEX `fk_Manager_Phones1_idx` (`phone_id` ASC) VISIBLE,
  CONSTRAINT `fk_Manager_Phones1`
    FOREIGN KEY (`phone_id`)
    REFERENCES `bank`.`Phones` (`idPhones`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bank`.`Clients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bank`.`Clients` (
  `idClients` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `date_of_birth` VARCHAR(45) NOT NULL,
  `document` DOUBLE NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `account_id` INT NOT NULL,
  `manager_id` INT NOT NULL,
  PRIMARY KEY (`idClients`),
  INDEX `fk_Clients_Accounts1_idx` (`account_id` ASC) VISIBLE,
  INDEX `fk_Clients_Manager1_idx` (`manager_id` ASC) VISIBLE,
  CONSTRAINT `fk_Clients_Accounts1`
    FOREIGN KEY (`account_id`)
    REFERENCES `bank`.`Accounts` (`idAccounts`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Clients_Manager1`
    FOREIGN KEY (`manager_id`)
    REFERENCES `bank`.`Managers` (`idManagers`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bank`.`Assistants`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bank`.`Assistants` (
  `idAssistants` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAssistants`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bank`.`Cards`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bank`.`Cards` (
  `idCards` INT NOT NULL AUTO_INCREMENT,
  `number` DOUBLE NOT NULL,
  `account_id` INT NOT NULL,
  PRIMARY KEY (`idCards`),
  INDEX `fk_Cards_Accounts1_idx` (`account_id` ASC) VISIBLE,
  CONSTRAINT `fk_Cards_Accounts1`
    FOREIGN KEY (`account_id`)
    REFERENCES `bank`.`Accounts` (`idAccounts`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bank`.`Deposits`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bank`.`Deposits` (
  `idDeposits` INT NOT NULL AUTO_INCREMENT,
  `money` DOUBLE NOT NULL,
  `account_id` INT NOT NULL,
  PRIMARY KEY (`idDeposits`),
  INDEX `fk_Deposits_Accounts1_idx` (`account_id` ASC) VISIBLE,
  CONSTRAINT `fk_Deposits_Accounts1`
    FOREIGN KEY (`account_id`)
    REFERENCES `bank`.`Accounts` (`idAccounts`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bank`.`Transactions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bank`.`Transactions` (
  `idTransactions` INT NOT NULL AUTO_INCREMENT,
  `money` DOUBLE NOT NULL,
  `destinationCBU` DOUBLE NULL,
  `account_id` INT NOT NULL,
  PRIMARY KEY (`idTransactions`),
  INDEX `fk_Transactions_Accounts1_idx` (`account_id` ASC) VISIBLE,
  CONSTRAINT `fk_Transactions_Accounts1`
    FOREIGN KEY (`account_id`)
    REFERENCES `bank`.`Accounts` (`idAccounts`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bank`.`Withdrawals`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bank`.`Withdrawals` (
  `idWithdrawals` INT NOT NULL AUTO_INCREMENT,
  `money` DOUBLE NOT NULL,
  `account_id` INT NOT NULL,
  PRIMARY KEY (`idWithdrawals`),
  INDEX `fk_Withdrawals_Accounts1_idx` (`account_id` ASC) VISIBLE,
  CONSTRAINT `fk_Withdrawals_Accounts1`
    FOREIGN KEY (`account_id`)
    REFERENCES `bank`.`Accounts` (`idAccounts`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bank`.`Investments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bank`.`Investments` (
  `idInvestments` INT NOT NULL AUTO_INCREMENT,
  `money` DOUBLE NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `account_id` INT NOT NULL,
  PRIMARY KEY (`idInvestments`),
  INDEX `fk_Investments_Accounts1_idx` (`account_id` ASC) VISIBLE,
  CONSTRAINT `fk_Investments_Accounts1`
    FOREIGN KEY (`account_id`)
    REFERENCES `bank`.`Accounts` (`idAccounts`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bank`.`Calls_History`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bank`.`Calls_History` (
  `assistant_id` INT NOT NULL,
  `client_id` INT NOT NULL,
  INDEX `fk_Clients_call_Assistants_Assistants1_idx` (`assistant_id` ASC) VISIBLE,
  INDEX `fk_Clients_call_Assistants_Clients1_idx` (`client_id` ASC) VISIBLE,
  CONSTRAINT `fk_Clients_call_Assistants_Assistants1`
    FOREIGN KEY (`assistant_id`)
    REFERENCES `bank`.`Assistants` (`idAssistants`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Clients_call_Assistants_Clients1`
    FOREIGN KEY (`client_id`)
    REFERENCES `bank`.`Clients` (`idClients`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bank`.`Credits`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bank`.`Credits` (
  `idCredits` INT NOT NULL AUTO_INCREMENT,
  `money` FLOAT NOT NULL,
  `interest` DOUBLE NOT NULL,
  `expiration` VARCHAR(45) NOT NULL,
  `account_id` INT NOT NULL,
  PRIMARY KEY (`idCredits`),
  INDEX `fk_Credits_Accounts1_idx` (`account_id` ASC) VISIBLE,
  CONSTRAINT `fk_Credits_Accounts1`
    FOREIGN KEY (`account_id`)
    REFERENCES `bank`.`Accounts` (`idAccounts`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bank`.`Debts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bank`.`Debts` (
  `idDebts` INT NOT NULL AUTO_INCREMENT,
  `money` DOUBLE NOT NULL,
  `deadline` VARCHAR(45) NOT NULL,
  `account_id` INT NOT NULL,
  PRIMARY KEY (`idDebts`),
  INDEX `fk_Debts_Accounts1_idx` (`account_id` ASC) VISIBLE,
  CONSTRAINT `fk_Debts_Accounts1`
    FOREIGN KEY (`account_id`)
    REFERENCES `bank`.`Accounts` (`idAccounts`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bank`.`Benefits`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bank`.`Benefits` (
  `idBenefits` INT NOT NULL AUTO_INCREMENT,
  `benefit` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idBenefits`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bank`.`Loyalty`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bank`.`Loyalty` (
  `client_id` INT NOT NULL,
  `benefit_id` INT NOT NULL,
  INDEX `fk_Benefits_has_Clients_Clients1_idx` (`client_id` ASC) VISIBLE,
  INDEX `fk_Benefits_has_Clients_Benefits1_idx` (`benefit_id` ASC) VISIBLE,
  CONSTRAINT `fk_Benefits_has_Clients_Clients1`
    FOREIGN KEY (`client_id`)
    REFERENCES `bank`.`Clients` (`idClients`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Benefits_has_Clients_Benefits1`
    FOREIGN KEY (`benefit_id`)
    REFERENCES `bank`.`Benefits` (`idBenefits`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bank`.`Payments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bank`.`Payments` (
  `idPayments` INT NOT NULL AUTO_INCREMENT,
  `money` DOUBLE NOT NULL,
  `place` VARCHAR(45) NOT NULL,
  `account_id` INT NOT NULL,
  PRIMARY KEY (`idPayments`),
  INDEX `fk_Payments_Accounts1_idx` (`account_id` ASC) VISIBLE,
  CONSTRAINT `fk_Payments_Accounts1`
    FOREIGN KEY (`account_id`)
    REFERENCES `bank`.`Accounts` (`idAccounts`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bank`.`Suscriptions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bank`.`Suscriptions` (
  `idSuscriptions` INT NOT NULL AUTO_INCREMENT,
  `service` VARCHAR(45) NOT NULL,
  `monthly_cost` DOUBLE NOT NULL,
  PRIMARY KEY (`idSuscriptions`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bank`.`Services`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bank`.`Services` (
  `account_id` INT NOT NULL,
  `suscription_id` INT NOT NULL,
  INDEX `fk_Accounts_has_Suscriptions_Accounts1_idx` (`account_id` ASC) VISIBLE,
  INDEX `fk_Accounts_has_Suscriptions_Suscriptions1_idx` (`suscription_id` ASC) VISIBLE,
  CONSTRAINT `fk_Accounts_has_Suscriptions_Accounts1`
    FOREIGN KEY (`account_id`)
    REFERENCES `bank`.`Accounts` (`idAccounts`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Accounts_has_Suscriptions_Suscriptions1`
    FOREIGN KEY (`suscription_id`)
    REFERENCES `bank`.`Suscriptions` (`idSuscriptions`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;