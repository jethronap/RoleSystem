CREATE SCHEMA `PrivateSchool` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `PrivateSchool`.`Student` (
  `stId` INT NOT NULL AUTO_INCREMENT,
  `fname` VARCHAR(45) NOT NULL,
  `lname` VARCHAR(45) NOT NULL,
  `dob` DATE NOT NULL,
  `fees` float NOT NULL,
  PRIMARY KEY (`stId`));

CREATE TABLE IF NOT EXISTS `PrivateSchool`.`Trainer` (
  `trId` INT NOT NULL AUTO_INCREMENT,
  `fname` VARCHAR(45) NOT NULL,
  `lname` VARCHAR(45) NOT NULL,
  `subjOfTrainer` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`trId`));

CREATE TABLE IF NOT EXISTS `PrivateSchool`.`Assignment` (
  `asId` INT NOT NULL AUTO_INCREMENT,
  `assignTitle` VARCHAR(45) NOT NULL,
  `descr` VARCHAR(45) NOT NULL,
  `submissionDateTime` datetime NOT NULL,
  `minOralMark` DOUBLE NOT NULL,
  `minTotalMark` DOUBLE NOT NULL,
  PRIMARY KEY (`asId`));

CREATE TABLE IF NOT EXISTS `PrivateSchool`.`Course` (
  `coId` INT NOT NULL AUTO_INCREMENT,
  `courseTitle` VARCHAR(45) NOT NULL,
  `stream` VARCHAR(15) NOT NULL,
  `typeOfParticipation` VARCHAR(15) NOT NULL,
  `startDate` DATE NOT NULL,
  `endDate` DATE NOT NULL,
  PRIMARY KEY (`coId`));

CREATE TABLE IF NOT EXISTS `PrivateSchool`.`HeadMaster` (
  `hmId` INT NOT NULL AUTO_INCREMENT,
  `fname` VARCHAR(45) NOT NULL,
  `lname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`hmId`));


CREATE TABLE IF NOT EXISTS `PrivateSchool`.`CourseStudents` (
  `csId` INT NOT NULL AUTO_INCREMENT,
  `fk_st_id` INT NULL,
  `fk_co_id` INT NULL,
  PRIMARY KEY (`csId`),
  INDEX `id_idx1` (`fk_co_id` ASC) VISIBLE,
  INDEX `fk_students_id_idx` (`fk_st_id` ASC) VISIBLE,
  CONSTRAINT `fk_students_id`
    FOREIGN KEY (`fk_st_id`)
    REFERENCES `PrivateSchool`.`Student` (`stId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_co_id`
    FOREIGN KEY (`fk_co_id`)
    REFERENCES `PrivateSchool`.`Course` (`coId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE IF NOT EXISTS `PrivateSchool`.`CourseTrainers` (
  `ctId` INT NOT NULL AUTO_INCREMENT,
  `fk_tr_id` INT NULL,
  `fk_co_id` INT NULL,
  PRIMARY KEY (`ctId`),
  INDEX `id_idx1` (`fk_co_id` ASC) VISIBLE,
  INDEX `fk_trainers_id_idx` (`fk_tr_id` ASC) VISIBLE,
  CONSTRAINT `fk_trainers_id`
    FOREIGN KEY (`fk_tr_id`)
    REFERENCES `PrivateSchool`.`Trainer` (`trId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_co_tr_id`
    FOREIGN KEY (`fk_co_id`)
    REFERENCES `PrivateSchool`.`Course` (`coId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE IF NOT EXISTS `PrivateSchool`.`CourseAssignments` (
  `caId` INT NOT NULL AUTO_INCREMENT,
  `fk_as_id` INT NULL,
  `fk_co_id` INT NULL,
  PRIMARY KEY (`caId`),
  INDEX `id_idx1` (`fk_co_id` ASC) VISIBLE,
  INDEX `fk_assignments_id_idx` (`fk_as_id` ASC) VISIBLE,
  CONSTRAINT `fk_assignments_id`
    FOREIGN KEY (`fk_as_id`)
    REFERENCES `PrivateSchool`.`Assignment` (`asId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_co_as_id`
    FOREIGN KEY (`fk_co_id`)
    REFERENCES `PrivateSchool`.`Course` (`coId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE IF NOT EXISTS `PrivateSchool`.`StudentsAssignmentsCourse` (
	`sacId` INT NOT NULL AUTO_INCREMENT,
    `fk_cs_id` INT NULL,
    `fk_ca_id` INT NULL,
    `studentOralMark` DOUBLE NULL,
	`studentTotalMark` DOUBLE NULL,
	`assignmentSubmitted` TINYINT NULL,
    PRIMARY KEY (`sacId`),
    INDEX `id_idx_1` (`fk_cs_id` ASC) VISIBLE,
    INDEX `fk_ca_id_idx` (`fk_ca_id` ASC) VISIBLE,
    CONSTRAINT `fk_cs_id`
		FOREIGN KEY (`fk_cs_id`)
        REFERENCES `PrivateSchool`.`CourseStudents` (`csId`)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
	CONSTRAINT `fk_ca_id`
		FOREIGN KEY (`fk_ca_id`)
        REFERENCES `PrivateSchool`.`CourseAssignments` (`caId`)
        ON DELETE CASCADE
        ON UPDATE CASCADE);


CREATE TABLE IF NOT EXISTS `PrivateSchool`.`UserStudent` (
  `usId` INT NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(45) NULL,
  `passHashed` CHAR(32) NULL,
  `fk_st_id` INT NULL,
  PRIMARY KEY (`usId`),
  UNIQUE INDEX `userName_UNIQUE` (`userName` ASC) VISIBLE,
  CONSTRAINT `fk_st_id`
    FOREIGN KEY (`fk_st_id`)
    REFERENCES `PrivateSchool`.`Student` (`stId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE IF NOT EXISTS `PrivateSchool`.`UserTrainer` (
  `utId` INT NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(45) NULL,
  `passHashed` CHAR(32) NULL,
  `fk_tr_id` INT NULL,
  PRIMARY KEY (`utId`),
  UNIQUE INDEX `userName_UNIQUE` (`userName` ASC) VISIBLE,
  CONSTRAINT `fk_tr_id`
    FOREIGN KEY (`fk_tr_id`)
    REFERENCES `PrivateSchool`.`Trainer` (`trId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE IF NOT EXISTS `PrivateSchool`.`UserHeadMaster` (
  `uhId` INT NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(45) NULL,
  `passHashed` CHAR(32) NULL,
  `fk_hm_id` INT NULL,
  PRIMARY KEY (`uhId`),
  UNIQUE INDEX `userName_UNIQUE` (`userName` ASC) VISIBLE,
  CONSTRAINT `fk_hm_id`
    FOREIGN KEY (`fk_hm_id`)
    REFERENCES `PrivateSchool`.`HeadMaster` (`hmId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE IF NOT EXISTS `PrivateSchool`.`Day` (
  `dId` INT NOT NULL AUTO_INCREMENT,
  `SchoolDay` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`dId`));


CREATE TABLE IF NOT EXISTS `PrivateSchool`.`CourseDays` (
  `cdId` INT NOT NULL AUTO_INCREMENT,
  `fk_d_id` INT NULL,
  `fk_co_id` INT NULL,
  PRIMARY KEY (`cdId`),
  INDEX `id_idx1` (`fk_co_id` ASC) VISIBLE,
  INDEX `fk_days_id_idx` (`fk_d_id` ASC) VISIBLE,
  CONSTRAINT `fk_days_id`
    FOREIGN KEY (`fk_d_id`)
    REFERENCES `PrivateSchool`.`Day` (`dId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_cod_id`
    FOREIGN KEY (`fk_co_id`)
    REFERENCES `PrivateSchool`.`Course` (`coId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
