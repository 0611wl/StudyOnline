/*
SQLyog Enterprise Trial - MySQL GUI v7.11 
MySQL - 5.6.38 : Database - study
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`study` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `study`;

/*Table structure for table `chapter` */

DROP TABLE IF EXISTS `chapter`;

CREATE TABLE `chapter` (
  `chapterId` int(11) NOT NULL AUTO_INCREMENT,
  `chapterName` varchar(50) NOT NULL,
  `chapterDescription` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`chapterId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `chapter` */

insert  into `chapter`(`chapterId`,`chapterName`,`chapterDescription`) values (1,'绪论',NULL),(2,'前言',NULL),(3,'TCP',NULL);

/*Table structure for table `chapter2course` */

DROP TABLE IF EXISTS `chapter2course`;

CREATE TABLE `chapter2course` (
  `chapterId` int(11) NOT NULL DEFAULT '0',
  `courseId` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`chapterId`,`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `chapter2course` */

insert  into `chapter2course`(`chapterId`,`courseId`) values (1,10021),(2,10021),(3,10022);

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `courseId` int(11) NOT NULL,
  `courseName` varchar(50) NOT NULL,
  `maxSize` int(11) NOT NULL DEFAULT '200',
  PRIMARY KEY (`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `course` */

insert  into `course`(`courseId`,`courseName`,`maxSize`) values (10021,'计算机网络',200),(10022,'操作系统',200),(10023,'计算机组成原理',200),(10024,'数据库原理',200);

/*Table structure for table `course2teacher` */

DROP TABLE IF EXISTS `course2teacher`;

CREATE TABLE `course2teacher` (
  `courseId` int(11) NOT NULL DEFAULT '0',
  `teacherId` varchar(15) NOT NULL DEFAULT '',
  PRIMARY KEY (`courseId`,`teacherId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `course2teacher` */

insert  into `course2teacher`(`courseId`,`teacherId`) values (10021,'2014021055'),(10022,'2014021055'),(10023,'2014021055'),(10024,'2014512155');

/*Table structure for table `material` */

DROP TABLE IF EXISTS `material`;

CREATE TABLE `material` (
  `materialId` int(11) NOT NULL AUTO_INCREMENT,
  `materialType` int(11) DEFAULT NULL,
  `materialName` varchar(50) NOT NULL,
  `materialPath` varchar(250) NOT NULL,
  `materialFileName` varchar(250) NOT NULL,
  PRIMARY KEY (`materialId`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

/*Data for the table `material` */

insert  into `material`(`materialId`,`materialType`,`materialName`,`materialPath`,`materialFileName`) values (35,1,'C++ primer中文版.pdf','E:\\eclipse-workspace\\StudyOnline\\WebContent\\material/C++ primer中文版.pdf',''),(36,1,'Erlang编程指南.pdf','E:\\eclipse-workspace\\StudyOnline\\WebContent\\material/Erlang编程指南.pdf',''),(37,1,'custom_fonts.pdf','E:\\eclipse-workspace\\StudyOnline\\WebContent\\material/custom_fonts.pdf',''),(38,1,'2018_SPRING_DEV.pdf','E:\\eclipse-workspace\\StudyOnline\\WebContent\\material/2018_SPRING_DEV.pdf',''),(39,3,'环保小视频.mp4','E:\\eclipse-workspace\\StudyOnline\\WebContent\\material/环保小视频.mp4',''),(40,1,'C++ primer中文版.pdf','E:\\eclipse-workspace\\StudyOnline\\WebContent\\material/C++ primer中文版.pdf',''),(41,1,'1.pdf','/StudyOnline/material//1.pdf',''),(42,1,'1.pdf','/StudyOnline/material/1.pdf',''),(43,1,'1.pdf','/StudyOnline/material/1.pdf',''),(44,1,'1.pdf','/StudyOnline/material/1.pdf',''),(46,1,'1.pdf','/StudyOnline/material/1.pdf',''),(47,1,'1.pdf','/StudyOnline/material/1.pdf',''),(48,1,'1.pdf','/StudyOnline/material/1.pdf',''),(49,1,'1.pdf','/StudyOnline/material/1.pdf',''),(50,1,'1.pdf','/StudyOnline/material/1.pdf',''),(51,1,'NetProg_Lab_1-3.pdf','/StudyOnline/material/NetProg_Lab_1-3.pdf','');

/*Table structure for table `material2chapter` */

DROP TABLE IF EXISTS `material2chapter`;

CREATE TABLE `material2chapter` (
  `materialId` int(11) NOT NULL DEFAULT '0',
  `chapterId` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`materialId`,`chapterId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `material2chapter` */

insert  into `material2chapter`(`materialId`,`chapterId`) values (1,1);

/*Table structure for table `material2course` */

DROP TABLE IF EXISTS `material2course`;

CREATE TABLE `material2course` (
  `materialId` int(11) NOT NULL DEFAULT '0',
  `courseId` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`materialId`,`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `material2course` */

insert  into `material2course`(`materialId`,`courseId`) values (35,10021),(36,10021),(37,10021),(38,10021),(39,10021),(40,10021),(41,10021),(42,10021),(43,10021),(44,10021),(46,10021),(47,10021),(48,10021),(49,10021),(50,10021),(51,10021);

/*Table structure for table `multiplechoice` */

DROP TABLE IF EXISTS `multiplechoice`;

CREATE TABLE `multiplechoice` (
  `multipleChoiceId` int(11) NOT NULL AUTO_INCREMENT,
  `multipleChoiceQuestion` varchar(500) NOT NULL,
  `multipleChoiceA` varchar(5) DEFAULT NULL,
  `multipleChoiceB` varchar(5) DEFAULT NULL,
  `multipleChoiceC` varchar(5) DEFAULT NULL,
  `multipleChoiceD` varchar(5) DEFAULT NULL,
  `multipleChoiceE` varchar(5) DEFAULT NULL,
  `multipleChoiceF` varchar(5) DEFAULT NULL,
  `multipleChoiceAnswer` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`multipleChoiceId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `multiplechoice` */

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `studentId` varchar(20) NOT NULL DEFAULT '',
  `name` varchar(15) NOT NULL,
  `faculty` varchar(50) NOT NULL,
  `specializeClass` varchar(50) NOT NULL,
  `telphone` varchar(15) NOT NULL,
  `email` varchar(20) NOT NULL,
  `photo` mediumblob,
  `status` int(1) NOT NULL,
  `password` varchar(15) NOT NULL,
  PRIMARY KEY (`studentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`studentId`,`name`,`faculty`,`specializeClass`,`telphone`,`email`,`photo`,`status`,`password`) values ('2014021009','刘旺旺','计算机与控制工程','计本142','18843562486','586321455@qq.com',NULL,1,'0611wl'),('2014021055','伍俊佳','计算机与控制工程','计本142','18714317363','960628772@qq.com',NULL,1,'0611wl'),('2014024548','董路畅','计算机与控制工程学院','计本142','18652314585','960628772@qq.com',NULL,1,'0611wl');

/*Table structure for table `student2course` */

DROP TABLE IF EXISTS `student2course`;

CREATE TABLE `student2course` (
  `courseId` int(11) NOT NULL DEFAULT '0',
  `studentId` varchar(20) NOT NULL DEFAULT '',
  `state` int(11) DEFAULT '0',
  PRIMARY KEY (`courseId`,`studentId`),
  KEY `studentId` (`studentId`),
  CONSTRAINT `student2course_ibfk_1` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`),
  CONSTRAINT `student2course_ibfk_2` FOREIGN KEY (`studentId`) REFERENCES `student` (`studentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student2course` */

insert  into `student2course`(`courseId`,`studentId`,`state`) values (10021,'2014021009',1),(10021,'2014021055',1),(10021,'2014024548',0),(10022,'2014021009',0),(10022,'2014021055',1);

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `teacherId` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  `name` varchar(15) NOT NULL,
  `faculty` varchar(50) NOT NULL,
  `specialize` varchar(50) DEFAULT NULL,
  `telphone` varchar(15) NOT NULL,
  `email` varchar(20) NOT NULL,
  PRIMARY KEY (`teacherId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `teacher` */

insert  into `teacher`(`teacherId`,`password`,`name`,`faculty`,`specialize`,`telphone`,`email`) values ('2014021055','0611wl','伍俊佳','计算机与控制工程学院','教授','18714317363','960628772@qq.com'),('2014512155','0611wl','李大辉','计算机与控制工程学院','教授','18714317363','960628772@qq.com'),('2015466654','0611wl','xxx','计算机与控制工程学院','教授','18714317363','960628772@qq.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
