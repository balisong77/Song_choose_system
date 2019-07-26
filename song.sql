/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.16 : Database - song
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`song` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `song`;

/*Table structure for table `information` */

DROP TABLE IF EXISTS `information`;

CREATE TABLE `information` (
  `singer` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `song` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone_num` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `college_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `class_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `to_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `message` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `date_time` datetime DEFAULT NULL,
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status_code` int(1) DEFAULT NULL,
  `is_anonymous` int(1) NOT NULL,
  `to_college` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;

/*Data for the table `information` */

insert  into `information`(`singer`,`song`,`name`,`phone_num`,`college_name`,`class_name`,`to_name`,`message`,`date_time`,`id`,`uuid`,`status_code`,`is_anonymous`,`to_college`) values ('zc','ascas','bbb','123','123','123','123','23123','2019-07-30 03:12:00',2,'qaeqw',2,0,NULL),('zsac','asdra','ccc','234','234','234','234','34234','2019-02-14 12:12:00',3,'qwe21',4,0,NULL),('qweqe','qwewq','ddd','345','345','345','345','345','2019-10-19 23:38:50',4,'2141qa',3,0,NULL),('wrw','qwrqr','eee','456','456','456','456','456','2020-07-31 23:39:02',5,'124124',1,0,NULL),('qwrwqr','qwrq','fff','123','aw','qwe','qwe','qwe','2019-07-05 12:12:00',6,'ae12e',4,0,NULL),('qwrwq','qwrqr','ggg','123456789','asdad','阿斯顿撒旦','按时大大','的非官方','2019-07-10 23:05:14',7,'123awe',4,0,NULL),('wetwe','wetwe','hhh','7867','678','678','678','678','2019-07-11 21:23:13',8,'1231q3eaw',4,0,NULL),('wetwet','wet','wetwe','rtuytr','rturtu','rtur','rturtu','turtu','2019-07-21 20:59:40',9,'124124awe',4,0,NULL),('','123','','','','','','','2019-07-05 23:23:00',53,'zGNpq9R8',4,0,NULL),('zzzzzzz','zzzzzzzzz','zzzzzzzz','111111111','zzzzzzzz','zzzzzz','zzzz','zzzzzzz','2019-10-31 12:12:00',54,'RYkfrUw1',1,0,NULL),('','泰山','','','','','','','2019-07-28 12:12:00',55,'ZUPTiGQj',3,0,NULL),('asd','123','asda','asd','asd','asd','asd','','2019-07-30 23:23:00',56,'nxMH2YJd',1,0,NULL),('rqwrq','qwerqw','rqwrq','qrq','qwrqrq','rqrqwr','wrqrq','wrqwrqwr','2019-10-31 12:24:00',57,'9ousb5Rc',1,0,NULL),('1111111','1111111','','','','','','','2019-07-01 11:11:00',58,'zk6ush6r',4,0,NULL),('23','23','23','23','23','23','23','23','2019-07-30 12:23:00',60,'23232',1,1,'23'),('9999999999','999999999','9999999999','9','999999999','9','','9','2019-07-28 11:11:00',61,'dtinPXkA',1,1,''),('周杰伦','晴天','','','','','','','2019-07-28 12:12:00',62,'WK2VPW9E',1,1,''),('aaa','climate','','','','','','','2019-07-31 11:11:00',63,'b9aVzcwf',1,1,''),('123','qwerqw','','','','','','','2019-07-27 23:23:00',64,'hSLbUafR',1,1,''),('','213123','','','','','','','2019-07-03 23:23:00',65,'yeWeVNq5',4,1,''),('345345','123','','','','','','','2019-07-12 04:45:00',66,'mqSfcEEq',4,0,''),('','234234','','','','','','','2019-07-26 03:43:00',67,'l7zAWzV5',4,0,'');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
