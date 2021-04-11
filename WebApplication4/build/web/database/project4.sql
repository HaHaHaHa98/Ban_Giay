-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: shopping
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `userName` varchar(100) NOT NULL,
  `passWord` varchar(100) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('a','a',0),('ando','ando',0),('anh','anh',0),('b','b',0),('duynam','duynam',0),('hoang','hoang',1),('quangle','quangle',0),('tamdo98','tamdo98',0),('tando','tando',0),('tranhuy','tranhuy',0),('vando','vando',0);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `size` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `codeProduct` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,37,100,'1'),(2,38,100,'1'),(3,39,100,'1'),(4,40,100,'1'),(5,37,100,'2'),(6,38,100,'2'),(7,39,100,'2'),(8,40,100,'2'),(9,37,100,'3'),(10,38,100,'3'),(11,39,100,'3'),(12,40,100,'3'),(13,37,100,'4'),(14,38,100,'4'),(15,39,100,'4'),(16,40,100,'4'),(17,37,100,'5'),(18,38,100,'5'),(19,39,100,'5'),(20,40,100,'5'),(21,37,100,'6'),(22,38,100,'6'),(23,39,100,'6'),(24,40,100,'6'),(25,37,100,'7'),(26,38,100,'7'),(27,39,100,'7'),(28,40,100,'7'),(29,37,100,'8'),(30,38,100,'8'),(31,39,100,'8'),(32,40,100,'8'),(33,37,100,'9'),(34,38,100,'9'),(35,39,100,'9'),(36,40,100,'9'),(37,37,100,'10'),(38,38,100,'10'),(39,39,100,'10'),(40,40,100,'10'),(41,37,100,'11'),(42,38,100,'11'),(43,39,100,'11'),(44,40,100,'11'),(45,37,100,'12'),(46,38,100,'12'),(47,39,100,'12'),(48,40,100,'12'),(49,37,100,'13'),(50,38,100,'13'),(51,39,100,'13'),(52,40,100,'13'),(53,37,100,'14'),(54,38,100,'14'),(55,39,100,'14'),(56,40,100,'14'),(57,37,100,'15'),(58,38,100,'15'),(59,39,100,'15'),(60,40,100,'15'),(61,37,100,'16'),(62,38,100,'16'),(63,39,100,'16'),(64,40,100,'16'),(65,37,100,'17'),(66,38,100,'17'),(67,39,100,'17'),(68,40,100,'17'),(69,37,100,'18'),(70,38,100,'18'),(71,39,100,'18'),(72,40,100,'18'),(73,37,100,'19'),(74,38,100,'19'),(75,39,100,'19'),(76,40,100,'19'),(77,37,100,'20'),(78,38,100,'20'),(79,39,100,'20'),(80,40,100,'20'),(81,37,100,'21'),(82,38,100,'21'),(83,39,100,'21'),(84,40,100,'21'),(85,37,100,'22'),(86,38,100,'22'),(87,39,100,'22'),(88,40,100,'22'),(89,37,100,'23'),(90,38,100,'23'),(91,39,100,'23'),(92,40,100,'23'),(93,37,100,'24'),(94,38,100,'24'),(95,39,100,'24'),(96,40,100,'24'),(97,37,100,'25'),(98,38,100,'25'),(99,39,100,'25'),(100,40,100,'25'),(101,37,100,'26'),(102,38,100,'26'),(103,39,100,'26'),(104,40,100,'26'),(105,37,100,'27'),(106,38,100,'27'),(107,39,100,'27'),(108,40,100,'27'),(109,37,100,'28'),(110,38,100,'28'),(111,39,100,'28'),(112,40,100,'28');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) NOT NULL,
  `userName` varchar(100) NOT NULL,
  `unitPrice` double NOT NULL,
  `checkoutDate` date NOT NULL,
  `idItem` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,1,'tando',2000000,'2019-12-05','78'),(2,1,'tando',3100000,'2019-12-05','58'),(3,1,'tando',4500000,'2019-12-05','26'),(4,123,'tando',555,'2019-12-05','1'),(5,1,'tando',2000000,'2019-12-05','82'),(6,33,'tando',4500000,'2019-12-05','38'),(7,1,'tando',4500000,'2019-12-05','38'),(8,1,'tando',3100000,'2019-12-05','42'),(9,1,'tando',4500000,'2019-12-05','62'),(10,1,'tando',4500000,'2019-12-05','26');
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `userName` varchar(100) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shoes`
--

DROP TABLE IF EXISTS `shoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shoes` (
  `code` varchar(10) NOT NULL,
  `name` varchar(45) NOT NULL,
  `brand` varchar(45) NOT NULL,
  `price` double NOT NULL,
  `type` varchar(45) NOT NULL,
  `object` varchar(45) NOT NULL,
  `image` varchar(45) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shoes`
--

LOCK TABLES `shoes` WRITE;
/*!40000 ALTER TABLE `shoes` DISABLE KEYS */;
INSERT INTO `shoes` VALUES ('1','ULTRABOOST 19','ADIDAS',4300000,'GIÀY THỂ THAO','NAM','ULTRABOOST 19'),('10','ALPHABOUNCE BEYOND','ADIDAS',4500000,'GIÀY THỂ THAO','NAM','ALPHABOUNCE BEYOND 2.0'),('11','PROPHERE','ADIDAS',3100000,'GIÀY SNEAKER','NAM','PROPHERE'),('12','POD-S3.1','ADIDAS',2900000,'GIÀY THỂ THAO','NAM','POD-S3.1'),('13','ADAPT BB MAG','NIKE',5000000,'GIÀY SNEAKER','NAM','ADAPT BB MAG'),('14','MARVIN MESH PANELLED','CALVIN KLEIN JEANS',4500000,'GIÀY SNEAKER','NAM','MARVIN MESH PANELLED'),('15','AIR JORDAN 1','JORDAN',3100000,'GIÀY SNEAKER','NAM','AIR JORDAN 1 RETRO \'FEARLESS\''),('16','KAYANO 5 OG','ASICS',4500000,'GIÀY SNEAKER','NAM','KAYANO 5 OG'),('17','PROPHERE','ADIDAS',3100000,'GIÀY SNEAKER','NAM','PROPHERE'),('18','ALPHABOUNCE BEYOND_2','ADIDAS',4500000,'GIÀY THỂ THAO','NAM','ALPHABOUNCE BEYOND 2.0'),('19','ULTRABOOST 29','ADIDAS',4500000,'GIÀY THỂ THAO','NU','ULTRABOOST 19'),('2','MARATHON TECH','ADIDAS',3000000,'GIÀY THỂ THAO','NAM','MARATHON TECH'),('20','ACE SNEAKER','GUCCI',2000000,'GIÀY SNEAKER','NU','ACE SNEAKER WITH GUCCI BLADE'),('21','IVORY RHYTON LEATHER','GUCCI',2000000,'GIÀY SNEAKER','NU','IVORY RHYTON GUCCI LOGO LEATHER SNEAKER'),('22','LOGO LOW TOP','MOSCHINO',2000000,'GIÀY SNEAKER','NU','LOGO LOW TOP SNEAKERS'),('23','X AMBUSH AIR','NIKE',2000000,'GIÀY SNEAKER','NU','X AMBUSH AIR MAX 180 HI-TOP SNEAKERS'),('24','REN MESH-LAYER','Y-3',2000000,'GIÀY SNEAKER','NU','REN MESH-LAYER SNEAKERS'),('25','PAINT SPLATTER','ASICS',2000000,'GIÀY SNEAKER','NU','PAINT SPLATTER SNEAKERS'),('26','X VIVIENNE WESTWOOD','ASICS',2000000,'GIÀY SNEAKER','NU','X VIVIENNE WESTWOOD HYPERGEL-LYTE SNEAKERS'),('27','KYRIE 5 \'SPONGEBOB','NIKE',2000000,'GIÀY SNEAKER','NU','KYRIE 5 \'SPONGEBOB SQUAREPANTS\' SNEAKERS'),('28','KYRIE 5 HIGH-TOP ','NIKE',2000000,'GIÀY SNEAKER','NU','KYRIE 5 HIGH-TOP SNEAKERS'),('3','SENSEBOOST GO','ADIDAS',3000000,'GIÀY THỂ THAO','NAM','SENSEBOOST GO'),('4','NMD_R1','ADIDAS',4500000,'GIÀY THỂ THAO','NAM','NMD_R1'),('5','S&L STAR WARS','ADIDAS',4500000,'GIÀY THỂ THAO','NAM','ULTRABOOST S&L STAR WARS'),('6','ZX TORSION','ADIDAS',4500000,'GIÀY THỂ THAO','NAM','ZX TORSION'),('7','NITE JOGGER','ADIDAS',4500000,'GIÀY SNEAKER','NAM','NITE JOGGER'),('8','ALPHABOUNCE RC 2.0','ADIDAS',4500000,'GIÀY THỂ THAO','NAM','ALPHABOUNCE RC 2.0'),('9','QUESTAR FLOW','ADIDAS',2000000,'GIÀY THỂ THAO','NAM','QUESTAR FLOW');
/*!40000 ALTER TABLE `shoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(100) NOT NULL,
  `lastName` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `userName` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (3,'Tân','Đỗ','Hà Đông','0123456789','tando'),(4,'huy','tran','ha dong','0123456789','huytran'),(5,'Hoàng','Đỗ','ha dong','0123456789','hoang'),(6,'Vân','Đỗ','Hà Đông - Hà Nội','01273175099','vando'),(7,'An','Đỗ','Hà Đông - Hà Nội','01273175099','ando'),(8,'An01','Đỗ','Hà Đông - Hà Nội','01273175099','ando'),(9,'Nam','Duy','Thanh Xuân - Hà Nội','01273175099','duynam'),(10,'Tâm','Đỗ','Thanh Xuân - Hà Nội','01273175099','tamdo98'),(11,'Quang','le','Nam truc','01233456867','quangle'),(12,'Hâm','Đỗ','Thanh Xuân - Hà Nội','01273175099','a'),(13,'b','b','b','b','b');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'shopping'
--

--
-- Dumping routines for database 'shopping'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-05 23:12:28
