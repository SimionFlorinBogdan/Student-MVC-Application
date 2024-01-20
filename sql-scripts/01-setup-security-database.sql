USE `student_directory`;

DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `members`;


CREATE TABLE `members` (
  `user_id` varchar(50) NOT NULL,
  `pw` char(68) NOT NULL,
  `active` tinyint NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Default passwords here are: parola123
--

INSERT INTO `members`
VALUES
('john','{bcrypt}$2a$12$phtb1B6gZUFKNh2CgoKv9OAgIkX35.dES/TgO1FhWa61nd/FMOdXS',1),
('mary','{bcrypt}$2a$12$phtb1B6gZUFKNh2CgoKv9OAgIkX35.dES/TgO1FhWa61nd/FMOdXS',1),
('susan','{bcrypt}$2a$12$phtb1B6gZUFKNh2CgoKv9OAgIkX35.dES/TgO1FhWa61nd/FMOdXS',1);


CREATE TABLE `roles` (
  `user_id` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  UNIQUE KEY `authorities5_idx_1` (`user_id`,`role`),
  CONSTRAINT `authorities5_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `members` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `roles`
VALUES
('john','ROLE_STUDENT'),
('mary','ROLE_STUDENT'),
('mary','ROLE_DIRECTOR'),
('susan','ROLE_STUDENT'),
('susan','ROLE_DIRECTOR'),
('susan','ROLE_ADMIN');
