-- MySQL dump 10.13  Distrib 5.5.54, for Win64 (AMD64)
--
-- Host: localhost    Database: lesson7
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
-- Table structure for table `food`
--

DROP TABLE IF EXISTS `food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `food` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `description` varchar(512) DEFAULT NULL,
  `food_energy` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food`
--

LOCK TABLES `food` WRITE;
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
INSERT INTO `food` VALUES (1,'方便面','垃圾食品',472),(2,'小米','营养价值很高，含丰富的蛋白质和脂肪和维生素，它不仅供食用，入药有清热、清渴，滋阴，补脾肾和肠胃，利小便、治水泻等功效，又可酿酒',358),(3,'燕麦片','燕麦煮出来高度粘稠，其中beta葡聚糖健康成分所带来的，具有降血脂、降血糖、高饱腹的效果。',367),(4,'毛豆','毛豆，就是新鲜连荚的黄豆，晒干之后又称大豆。',123),(5,'山药','山药具有滋养强壮，助消化，敛虚汗，止泻之功效，主治脾虚腹泻、肺虚咳嗽。',56);
/*!40000 ALTER TABLE `food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sport`
--

DROP TABLE IF EXISTS `sport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sport` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `description` varchar(512) DEFAULT NULL,
  `consume_energy` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sport`
--

LOCK TABLES `sport` WRITE;
/*!40000 ALTER TABLE `sport` DISABLE KEYS */;
INSERT INTO `sport` VALUES (1,'游泳','人在水的浮力作用下产生向上漂浮，凭借浮力通过肢体有规律的运动，使身体在水中有规律运动的技能',175),(2,'田径','现代田径运动的分类不同，主要包括竞走、跑、跳跃、投掷以及由跑、跳、跃、投掷的部分项目组成的全能运动，共计四十多项。',450),(3,'篮球','起源于美国马萨诸塞州，是1891年12月21日由詹姆斯·奈史密斯创造，是奥运会核心比赛项目，是以手为中心的身体对抗性体育运动。',250),(4,'自行车','对心肺、腿十分有利。',330);
/*!40000 ALTER TABLE `sport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_food_history`
--

DROP TABLE IF EXISTS `user_food_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_food_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `food_id` int(11) DEFAULT NULL,
  `food_quantity` int(11) DEFAULT NULL,
  `collect_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_food_history`
--

LOCK TABLES `user_food_history` WRITE;
/*!40000 ALTER TABLE `user_food_history` DISABLE KEYS */;
INSERT INTO `user_food_history` VALUES (1,1,1,250,'2019-01-05'),(2,1,2,350,'2019-01-05'),(3,1,3,150,'2019-01-05'),(4,1,1,150,'2019-01-06'),(5,1,4,250,'2019-01-06'),(6,1,5,100,'2019-01-06');
/*!40000 ALTER TABLE `user_food_history` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_index`
--

LOCK TABLES `user_index` WRITE;
/*!40000 ALTER TABLE `user_index` DISABLE KEYS */;
INSERT INTO `user_index` VALUES (1,1,1,60,'2019-01-05'),(2,1,1,65,'2019-01-06'),(3,1,2,167,'2019-01-05'),(4,1,2,168,'2019-01-06');
/*!40000 ALTER TABLE `user_index` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_sport_history`
--

DROP TABLE IF EXISTS `user_sport_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_sport_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `sport_id` int(11) DEFAULT NULL,
  `sport_time` int(11) DEFAULT NULL,
  `collect_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_sport_history`
--

LOCK TABLES `user_sport_history` WRITE;
/*!40000 ALTER TABLE `user_sport_history` DISABLE KEYS */;
INSERT INTO `user_sport_history` VALUES (1,1,1,2,'2019-01-05'),(2,1,2,3,'2019-01-05'),(3,1,3,1,'2019-01-06'),(4,1,4,2,'2019-01-06'),(5,1,3,1,'2019-01-05'),(6,2,1,2,'2019-01-05'),(7,2,2,2,'2019-01-05'),(8,2,3,2,'2019-01-05');
/*!40000 ALTER TABLE `user_sport_history` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-06 10:21:04
