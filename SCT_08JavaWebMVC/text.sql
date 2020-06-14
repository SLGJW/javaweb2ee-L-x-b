/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 5.5.40 : Database - text
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`text` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `text`;

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `cid` int(10) NOT NULL AUTO_INCREMENT,
  `cname` varchar(10) NOT NULL,
  `tid` int(10) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `c_t` (`tid`),
  CONSTRAINT `c_t` FOREIGN KEY (`tid`) REFERENCES `teacher` (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=10010 DEFAULT CHARSET=utf8;

/*Data for the table `course` */

insert  into `course`(`cid`,`cname`,`tid`) values (10001,'语文',2020001),(10002,'数学',2020002),(10003,'英语',2020003),(10004,'物理',NULL),(10005,'化学',NULL),(10006,'生物',NULL),(10007,'美术',NULL),(10008,'音乐',NULL),(10009,'体育',NULL);

/*Table structure for table `stu_cou` */

DROP TABLE IF EXISTS `stu_cou`;

CREATE TABLE `stu_cou` (
  `sid` int(10) NOT NULL,
  `cid` int(10) NOT NULL,
  `scores` double(5,2) DEFAULT NULL,
  KEY `sid_sid` (`sid`),
  KEY `cid_cid` (`cid`),
  CONSTRAINT `sid_sid` FOREIGN KEY (`sid`) REFERENCES `student` (`sid`),
  CONSTRAINT `cid_cid` FOREIGN KEY (`cid`) REFERENCES `course` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stu_cou` */

insert  into `stu_cou`(`sid`,`cid`,`scores`) values (2020101,10001,NULL),(2020102,10001,NULL),(2020103,10001,NULL),(2020104,10001,NULL),(2020105,10001,NULL),(2020101,10003,NULL);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `sid` int(10) NOT NULL AUTO_INCREMENT,
  `sname` varchar(10) NOT NULL,
  `sclass` varchar(10) NOT NULL,
  `phone_number` varchar(11) NOT NULL,
  `password` varchar(16) NOT NULL,
  `age` int(2) NOT NULL,
  `sex` int(2) NOT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=2020106 DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`sid`,`sname`,`sclass`,`phone_number`,`password`,`age`,`sex`) values (2020101,'小明','高一一班','14758586939','123456',16,1),(2020102,'小亮','高一二班','15025801475','123456',16,1),(2020103,'小红','高二一班','15985236924','123456',17,0),(2020104,'小黄','高二一班','11232122132','123456',17,0),(2020105,'小黑','高三一班','36925800147','123456',18,1);

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `tid` int(10) NOT NULL,
  `tname` varchar(10) NOT NULL,
  `sex` int(2) NOT NULL,
  `email` varchar(30) DEFAULT NULL,
  `phone_number` varchar(11) NOT NULL,
  `PASSWORD` varchar(16) NOT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `teacher` */

insert  into `teacher`(`tid`,`tname`,`sex`,`email`,`phone_number`,`PASSWORD`) values (2020001,'张三',1,'zhangsan@qq.com','1383838438','123456'),(2020002,'李四',0,'lisi@qq.com','1585858358','123456'),(2020003,'王五',1,'wangwu@qq.com','1898989689','123456');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
