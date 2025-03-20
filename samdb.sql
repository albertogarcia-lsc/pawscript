-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: samdb
-- ------------------------------------------------------
-- Server version	5.7.14-log

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
-- Table structure for table `profesores`
--

DROP TABLE IF EXISTS `profesores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profesores` (
  `numProfesor` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `RFC` varchar(13) NOT NULL,
  `Administrador` tinyint(1) DEFAULT '0',
  `correo` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`numProfesor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesores`
--

LOCK TABLES `profesores` WRITE;
/*!40000 ALTER TABLE `profesores` DISABLE KEYS */;
INSERT INTO `profesores` VALUES (1,'ab','das','GABA040419HBC',NULL,'alberto12435@gmail.com','faksd'),(2,'Eli','Serna','GABA040419HBB',1,'elirainbow@gmail.com','eli'),(648,'Adrian','Ramos','LMA951103H34',NULL,'jackyrms22@gmail.com','bedoyaramos123'),(5646,'Gerardo','Moreno','GMR567843J78',NULL,'gera@gmail.com','tilin'),(55656,'Adrian','Ramos','JBR951103H34',NULL,'jackyrms22@gmail.com','bedoyaramos123'),(65748,'Adrian','Ramos','BRJ951103H34',NULL,'jackyrms22@gmail.com','bedoyaramos123');
/*!40000 ALTER TABLE `profesores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidades`
--

DROP TABLE IF EXISTS `unidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unidades` (
  `claveUnidadAprendizaje` int(11) NOT NULL,
  `nombreUnidad` varchar(30) NOT NULL,
  `horas_clase` int(11) DEFAULT NULL,
  `horas_taller` int(11) DEFAULT NULL,
  `horas_laboratorio` int(11) DEFAULT NULL,
  PRIMARY KEY (`claveUnidadAprendizaje`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidades`
--

LOCK TABLES `unidades` WRITE;
/*!40000 ALTER TABLE `unidades` DISABLE KEYS */;
INSERT INTO `unidades` VALUES (1,'Matematicas',1,1,1),(2,'Español',100,0,1),(3,'Español',100,0,1),(10,'REACT',1,1,1);
/*!40000 ALTER TABLE `unidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios_unidades`
--

DROP TABLE IF EXISTS `usuarios_unidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios_unidades` (
  `numProfesor` int(11) NOT NULL,
  `claveUnidadAprendizaje` int(11) NOT NULL,
  PRIMARY KEY (`numProfesor`,`claveUnidadAprendizaje`),
  KEY `claveUnidadAprendizaje` (`claveUnidadAprendizaje`),
  CONSTRAINT `usuarios_unidades_ibfk_1` FOREIGN KEY (`numProfesor`) REFERENCES `profesores` (`numProfesor`),
  CONSTRAINT `usuarios_unidades_ibfk_2` FOREIGN KEY (`claveUnidadAprendizaje`) REFERENCES `unidades` (`claveUnidadAprendizaje`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios_unidades`
--

LOCK TABLES `usuarios_unidades` WRITE;
/*!40000 ALTER TABLE `usuarios_unidades` DISABLE KEYS */;
INSERT INTO `usuarios_unidades` VALUES (5646,1),(648,10);
/*!40000 ALTER TABLE `usuarios_unidades` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-20 12:36:23
