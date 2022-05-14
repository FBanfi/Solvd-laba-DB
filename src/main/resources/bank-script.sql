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

INSERT INTO Accounts (balance,cbu,alias) VALUES (100000,123123123,'123.account');
INSERT INTO Accounts (balance,cbu,alias) VALUES (1000000,456456456,'456.account');
INSERT INTO Accounts (balance,cbu,alias) VALUES (10000000,789789789,'789.account');
INSERT INTO Phones (number) VALUES (42121258);
INSERT INTO Managers (name,last_name,phone_id) VALUES ('Albus','Dumbledore',1);
INSERT INTO Clients (name,last_name,date_of_birth,document,email,account_id,manager_id) VALUES ('Harry','Potter','31/07/1980',21123456,'harrypotter@gmail.com',1,1);
INSERT INTO Clients (name,last_name,date_of_birth,document,email,account_id,manager_id) VALUES ('Hermione','Granger','19/09/1979',22123456,'hermionegranger@gmail.com',2,1);
INSERT INTO Clients (name,last_name,date_of_birth,document,email,account_id,manager_id) VALUES ('Ron','Weasley','01/03/1980',21153445,'ronweasley@gmail.com',3,1);
INSERT INTO Phones (number,client_id) VALUES (42897452,1);
INSERT INTO Phones (number,client_id) VALUES (42963214,2);
INSERT INTO Phones (number,client_id) VALUES (42560145,3);
INSERT INTO Assistants (name,last_name) VALUES ('Snape','Severus');
INSERT INTO Benefits (benefit) VALUES ('50% of discount in Sport Centers');
INSERT INTO Deposits (money,account_id) VALUES (100,1);
INSERT INTO Withdrawals (money,account_id) VALUES (200,2);
INSERT INTO Investments (money,description,account_id) VALUES (1000,'Bitcoins in Binance',2);
INSERT INTO Credits (money,interest,expiration,account_id) VALUES (10000,0.3,'10/10/2023',1);
INSERT INTO Transactions (money,destinationCBU,account_id) VALUES (1000,456456456,3);
INSERT INTO Debts (money,deadline,account_id) VALUES (500,'20/12/23',2);
INSERT INTO Payments (money,place,account_id) VALUES (500,'Dunkin Donuts',3);
INSERT INTO Suscriptions (service,monthly_cost) VALUES ('Netflix',2);
INSERT INTO Cards (number,account_id) VALUES (123654789,1);
INSERT INTO Cards (number,account_id) VALUES (321456987,2);
INSERT INTO Cards (number,account_id) VALUES (789654123,3);
INSERT INTO Cards (number,account_id) VALUES (987654321,1);
INSERT INTO Cards (number,account_id) VALUES (987456321,1);

DELETE FROM Cards WHERE idCards=1;
DELETE FROM Transactions WHERE destinationCBU=456456456;
DELETE FROM Suscriptions WHERE service='Netflix';
DELETE FROM Assistants WHERE name='Snape';
DELETE FROM Managers WHERE idManagers<2;

UPDATE Phones SET number=42856314 WHERE client_id=1;
UPDATE Clients SET name='James' WHERE name='Harry';
UPDATE Accounts SET alias='wingardium leviosa' WHERE idAccounts=2;
UPDATE Suscriptions SET service="Disney Plus" WHERE monthly_cost>=2;
UPDATE Debts SET deadline='01/01/20024' WHERE money=500;
UPDATE Cards SET number=147852369 WHERE idCards=5;

SELECT a.balance,a.alias,c.number FROM Cards c JOIN Accounts a on a.idAccounts=c.account_id;
SELECT a.balance,a.alias,c.number FROM Cards c JOIN Accounts a WHERE a.idAccounts=1 AND c.number>780000000;
SELECT c.name,c.last_name,p.number FROM Phones p LEFT JOIN Clients c ON c.idClients=p.idPhones;
SELECT c.name,c.last_name,p.number FROM Phones p RIGHT JOIN Clients c ON c.idClients=p.idPhones;
SELECT AVG(number),idCards FROM Cards GROUP BY idCards HAVING AVG(number)>580000000 AND idCards>1;