-- MySQL dump 10.13  Distrib 5.5.54, for Win64 (AMD64)
--
-- Host: localhost    Database: lesson6
-- ------------------------------------------------------
-- Server version	5.5.54

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `index_type`
--

DROP TABLE IF EXISTS `index_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `index_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `index_type`
--

LOCK TABLES `index_type` WRITE;
/*!40000 ALTER TABLE `index_type` DISABLE KEYS */;
INSERT INTO `index_type` VALUES (1,'身高',10),(2,'体重',20),(3,'血压',30),(4,'血糖',40),(5,'血脂',50);
/*!40000 ALTER TABLE `index_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `phone` varchar(32) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `job` int(11) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'李强',1,55,'15188880000','2018-11-25',1,'江苏省南京市鼓楼区东南大学'),(2,'徐璐',0,35,'15188880001','2018-11-25',2,'江苏省南京市鼓楼区东南大学'),(3,'高晓攀',0,42,'15188880002','2018-11-25',3,'江苏省南京市鼓楼区河海大学'),(4,'王美凤',0,38,'15188880003','2018-11-25',4,'江苏省南京市江宁区南京工程学院');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_index`
--

DROP TABLE IF EXISTS `user_index`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_index` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `index_type` int(11) DEFAULT NULL,
  `index_content` int(11) DEFAULT NULL,
  `collect_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_index`
--

LOCK TABLES `user_index` WRITE;
/*!40000 ALTER TABLE `user_index` DISABLE KEYS */;
INSERT INTO `user_index` VALUES (1,1,20,67,'2018-12-01'),(2,1,20,66,'2018-12-02'),(3,1,20,69,'2018-12-03'),(4,1,20,68,'2018-12-04'),(5,1,20,68,'2018-12-05'),(6,1,20,67,'2018-12-06'),(7,1,20,67,'2018-12-07'),(8,1,20,65,'2018-12-08'),(9,1,20,69,'2018-12-09'),(10,1,20,69,'2018-12-10'),(11,1,20,68,'2018-12-11'),(12,1,20,68,'2018-12-12'),(13,1,20,69,'2018-12-13'),(14,1,20,68,'2018-12-14'),(15,1,20,70,'2018-12-15'),(16,1,20,70,'2018-12-16'),(17,1,20,69,'2018-12-17'),(18,1,20,67,'2018-12-18'),(19,1,20,69,'2018-12-19'),(20,1,20,69,'2018-12-20'),(21,1,20,69,'2018-12-21'),(22,1,20,67,'2018-12-22'),(23,1,20,67,'2018-12-23'),(24,1,20,69,'2018-12-24'),(25,1,20,66,'2018-12-25'),(26,1,20,66,'2018-12-26'),(27,1,20,66,'2018-12-27'),(28,1,20,67,'2018-12-28'),(29,1,20,70,'2018-12-29'),(30,1,20,66,'2018-12-30'),(31,1,20,67,'2018-12-31'),(32,1,40,9,'2018-12-01'),(33,1,40,8,'2018-12-02'),(34,1,40,7,'2018-12-03'),(35,1,40,11,'2018-12-04'),(36,1,40,9,'2018-12-05'),(37,1,40,11,'2018-12-06'),(38,1,40,12,'2018-12-07'),(39,1,40,11,'2018-12-08'),(40,1,40,8,'2018-12-09'),(41,1,40,12,'2018-12-10'),(42,1,40,10,'2018-12-11'),(43,1,40,10,'2018-12-12'),(44,1,40,12,'2018-12-13'),(45,1,40,8,'2018-12-14'),(46,1,40,9,'2018-12-15'),(47,1,40,11,'2018-12-16'),(48,1,40,10,'2018-12-17'),(49,1,40,7,'2018-12-18'),(50,1,40,8,'2018-12-19'),(51,1,40,8,'2018-12-20'),(52,1,40,8,'2018-12-21'),(53,1,40,10,'2018-12-22'),(54,1,40,10,'2018-12-23'),(55,1,40,9,'2018-12-24'),(56,1,40,9,'2018-12-25'),(57,1,40,8,'2018-12-26'),(58,1,40,10,'2018-12-27'),(59,1,40,10,'2018-12-28'),(60,1,40,11,'2018-12-29'),(61,1,40,12,'2018-12-30'),(62,1,40,7,'2018-12-31');
/*!40000 ALTER TABLE `user_index` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-19 10:28:26
