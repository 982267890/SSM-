-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: questionbank
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comments` (
  `questionId` int(3) NOT NULL,
  `anwers` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`questionId`),
  UNIQUE KEY `questionId` (`questionId`),
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`questionId`) REFERENCES `question` (`questionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (0,'你猜一猜我回复了什么啊！','a'),(1,'你猜一猜我回复了什么','andmin');
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `questionId` int(3) NOT NULL,
  `questionNum` int(3) NOT NULL,
  `questionName` varchar(255) NOT NULL,
  `zanNum` int(3) NOT NULL DEFAULT '0',
  `watchNum` int(3) NOT NULL DEFAULT '0',
  `commentsNum` int(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`questionId`),
  UNIQUE KEY `questionId` (`questionId`),
  UNIQUE KEY `questionName` (`questionName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (0,20,'JS基础',67,982,30),(1,32,'Vue',167,1132,81);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questioncontent`
--

DROP TABLE IF EXISTS `questioncontent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questioncontent` (
  `questionId` int(3) NOT NULL,
  `questionCont` varchar(255) NOT NULL,
  `quesetionAnser` varchar(255) DEFAULT NULL,
  `abcd` varchar(5) DEFAULT NULL,
  `code` varchar(255) NOT NULL,
  KEY `questionId` (`questionId`),
  CONSTRAINT `questioncontent_ibfk_1` FOREIGN KEY (`questionId`) REFERENCES `question` (`questionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questioncontent`
--

LOCK TABLES `questioncontent` WRITE;
/*!40000 ALTER TABLE `questioncontent` DISABLE KEYS */;
INSERT INTO `questioncontent` VALUES (1,'将数组扁平化并去除其中重复数据，最终得到一个升序且不重复的数组',NULL,NULL,'var arr=[[1,2,2],[3,4,5,5],[6,7,8,9]]'),(1,'我们需要向对线person添加什么，以致执行[...person]时获得形如[\'Lydia Hallie\',21]的输出？','对面默认并不是可迭代的，巴拉巴拉小魔仙，全身变','C','const person={name:\'Lydia Hallie\',age:21} [...person]'),(0,'这里是题目1号',NULL,NULL,'console.log(\'hello world\')'),(0,'我们需要？？出？？','这是参考答案，巴拉巴拉黑魔仙，全身变','A','alert(\'Are you ok?!\')');
/*!40000 ALTER TABLE `questioncontent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time`
--

DROP TABLE IF EXISTS `time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `time` (
  `t` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time`
--

LOCK TABLES `time` WRITE;
/*!40000 ALTER TABLE `time` DISABLE KEYS */;
/*!40000 ALTER TABLE `time` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `userpwd` varchar(255) NOT NULL,
  `solveNum` int(3) NOT NULL DEFAULT '0',
  `dayNum` int(5) NOT NULL DEFAULT '0',
  `ideaNum` int(5) NOT NULL DEFAULT '0',
  `role` varchar(10) DEFAULT 'editor',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (0,'admin','root',-1,-1,-1,'admin'),(1,'a','123',10,10,10,'editor'),(5,'b','123',0,0,0,'editor');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-14  0:56:45
