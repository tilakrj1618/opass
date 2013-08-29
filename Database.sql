/*
SQLyog Enterprise - MySQL GUI v7.02 
MySQL - 5.0.22-community-nt : Database - opass
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`opass` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `opass`;

/*Table structure for table `logindetails` */

DROP TABLE IF EXISTS `logindetails`;

CREATE TABLE `logindetails` (
  `username` varchar(50) default NULL,
  `uid` varchar(50) default NULL,
  `url` varchar(50) default NULL,
  `longtermpassword` varchar(50) default NULL,
  `phoneno` varchar(50) default NULL,
  `flag` varchar(5) default NULL,
  `otp` varchar(50) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `logindetails` */

insert  into `logindetails`(`username`,`uid`,`url`,`longtermpassword`,`phoneno`,`flag`,`otp`) values ('ss','ss','http://www.gmail.com','1466','+919942737177',NULL,'db5a861');

/*Table structure for table `userdetails` */

DROP TABLE IF EXISTS `userdetails`;

CREATE TABLE `userdetails` (
  `username` varchar(50) default NULL,
  `uid` varchar(15) default NULL,
  `url` varchar(50) default NULL,
  `longpassword` varchar(50) default NULL,
  `phoneno` varchar(15) default NULL,
  `flag` varchar(2) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `userdetails` */

insert  into `userdetails`(`username`,`uid`,`url`,`longpassword`,`phoneno`,`flag`) values ('vgv','dghf','sghff','744475','+919942737177','0'),('ss','ss','http://www.gmail.com','1466','+919942737177','0');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
