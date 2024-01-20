CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `student_directory`;

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `enrolled_year` int DEFAULT NULL,
  `registration_code` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `student` VALUES 
	(1,'Leslie Andrews','leslie@yahoo.com',2002,'TAX322'),
	(2,'Emma Baumgarten','emma@yahoo.com',2002,'TAX661'),
	(3,'Avani Gupta','avani@gmail.com',1999,'SFS142'),
	(4,'Yuri Petrov','yuri@yahoo.com',2005,'TAX772'),
	(5,'Juan Vega','juan@gmail.com',1999,'SFS521');

