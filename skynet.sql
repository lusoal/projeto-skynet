-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: localhost    Database: skynet
-- ------------------------------------------------------
-- Server version	5.7.21-0ubuntu0.16.04.1
use skynet;
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
-- Table structure for table `cadAdm`
--

DROP TABLE IF EXISTS `cadAdm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cadAdm` (
  `documento` int(30) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `endereco` varchar(80) NOT NULL,
  `telefone` int(15) NOT NULL,
  `contato_documento` int(30) NOT NULL,
  `contato_nome` varchar(50) NOT NULL,
  `contato_email` varchar(50) NOT NULL,
  `senha` varchar(10) NOT NULL,
  PRIMARY KEY (`documento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cadAdm`
--

LOCK TABLES `cadAdm` WRITE;
/*!40000 ALTER TABLE `cadAdm` DISABLE KEYS */;
INSERT INTO `cadAdm` VALUES (111,'Matheus','largo da batata',996013142,2222,'Matheussao','matheus.c@gmail','123456');
/*!40000 ALTER TABLE `cadAdm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cadPublico`
--

DROP TABLE IF EXISTS `cadPublico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cadPublico` (
  `documento` int(30) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY (`documento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cadPublico`
--

LOCK TABLES `cadPublico` WRITE;
/*!40000 ALTER TABLE `cadPublico` DISABLE KEYS */;
INSERT INTO `cadPublico` VALUES (123456,'Cartorio',0);
/*!40000 ALTER TABLE `cadPublico` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-24 16:24:19
