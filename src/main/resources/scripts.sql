create schema research;

CREATE TABLE `research`.`T_COURSE` (
  `COURSE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `COURSE_DESCRIPTION` varchar(100) NOT NULL,
  `COURSE_INSTRUCTOR` varchar(100) NOT NULL,
  `COURSE_NAME` varchar(100) NOT NULL,
  PRIMARY KEY (`COURSE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `research`.`T_STUDENT` (
  `STD_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `STD_EMAIL` varchar(100) NOT NULL,
  `STD_FIRST_NAME` varchar(100) NOT NULL,
  `STD_LAST_NAME` varchar(100) NOT NULL,
  PRIMARY KEY (`STD_ID`),
  UNIQUE KEY `UK_aptiuvcsydt3t6yprmkkaqjn1` (`STD_EMAIL`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `research`.`T_COURSE_STUDENTS` (
  `COURSE_ID` bigint(20) NOT NULL,
  `STD_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`COURSE_ID`,`STD_ID`),
  KEY `FK_STD_ID` (`STD_ID`),
  CONSTRAINT `FK_COURSE_ID` FOREIGN KEY (`STD_ID`) REFERENCES `t_student` (`STD_ID`),
  CONSTRAINT `FK_STD_ID` FOREIGN KEY (`COURSE_ID`) REFERENCES `t_course` (`COURSE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `research`.`T_COURSE` (`COURSE_ID`,`COURSE_DESCRIPTION`,`COURSE_INSTRUCTOR`,`COURSE_NAME`) VALUES (1,'Learn Java within 30 days','Mera','JAVA');
INSERT INTO `research`.`T_COURSE` (`COURSE_ID`,`COURSE_DESCRIPTION`,`COURSE_INSTRUCTOR`,`COURSE_NAME`) VALUES (2,'Spring section now includes over 6.5 hours of new videos','John','Spring');
