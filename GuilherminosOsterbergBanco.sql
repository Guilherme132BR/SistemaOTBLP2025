-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.2    Database: db_guilherminososterberg
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.28-MariaDB

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
-- Table structure for table `clienteotb`
--

DROP TABLE IF EXISTS `clienteotb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clienteotb` (
  `IdClienteOTB` int(11) NOT NULL,
  `Fk_UsuarioOTB` int(11) NOT NULL,
  `NomeOTB` varchar(45) NOT NULL,
  `SobreNomeOTB` varchar(45) NOT NULL,
  `CPFOTB` varchar(45) NOT NULL,
  `EnderecoOTB` varchar(45) NOT NULL,
  `PaisOTB` varchar(45) NOT NULL,
  `BairroOTB` varchar(45) NOT NULL,
  `CidadeOTB` varchar(45) NOT NULL,
  `TelefoneOTB` varchar(45) NOT NULL,
  `CelularOTB` varchar(45) NOT NULL,
  PRIMARY KEY (`IdClienteOTB`),
  KEY `Fk_UsuarioOTB_idx` (`Fk_UsuarioOTB`),
  CONSTRAINT `Fk_UsuarioOTB` FOREIGN KEY (`Fk_UsuarioOTB`) REFERENCES `usuariootb` (`IdUsuarioOTB`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clienteotb`
--

LOCK TABLES `clienteotb` WRITE;
/*!40000 ALTER TABLE `clienteotb` DISABLE KEYS */;
INSERT INTO `clienteotb` VALUES (123,1,'Guilherme ','Vieira Osterberg','09464273135','Rua Carlos James Machinsky','Brasil','Parque dos Ipês 2','Ponta Porã','67 9 999281562','67 9 999281562');
/*!40000 ALTER TABLE `clienteotb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comprasotb`
--

DROP TABLE IF EXISTS `comprasotb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comprasotb` (
  `IdComprasOTB` int(11) NOT NULL,
  `DataComprasOTB` date NOT NULL,
  `TotalOTB` decimal(11,2) NOT NULL,
  `Fk_ClienteOTB` int(9) NOT NULL,
  `Fk_FornecedorOTB` int(9) NOT NULL,
  PRIMARY KEY (`IdComprasOTB`),
  KEY `Fk_ClienteOTB_idx` (`Fk_ClienteOTB`),
  KEY `Fk_FornecedorOTB_idx` (`Fk_FornecedorOTB`),
  CONSTRAINT `Fk_ClienteOTB` FOREIGN KEY (`Fk_ClienteOTB`) REFERENCES `clienteotb` (`IdClienteOTB`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Fk_FornecedorOTB` FOREIGN KEY (`Fk_FornecedorOTB`) REFERENCES `fornecedorotb` (`IdFornecedorOTB`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comprasotb`
--

LOCK TABLES `comprasotb` WRITE;
/*!40000 ALTER TABLE `comprasotb` DISABLE KEYS */;
INSERT INTO `comprasotb` VALUES (123,'2005-12-29',312.00,123,123),(134,'2025-12-29',245.00,123,123),(1243,'2025-12-29',124.00,123,123),(908796,'2005-12-29',32.00,123,123);
/*!40000 ALTER TABLE `comprasotb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comprasprodutosotb`
--

DROP TABLE IF EXISTS `comprasprodutosotb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comprasprodutosotb` (
  `IdComprasProdutosOTB` int(9) NOT NULL,
  `QuantidadeOTB` varchar(45) NOT NULL,
  `ValorUnidadeOTB` decimal(11,2) NOT NULL,
  `TotalOTB` decimal(11,2) NOT NULL,
  `Fk_ComprasOTB` int(9) NOT NULL,
  `Fk_ProdutosOTB` int(9) NOT NULL,
  PRIMARY KEY (`IdComprasProdutosOTB`),
  KEY `Fk_Compras_idx` (`Fk_ComprasOTB`),
  KEY `Fk_ProdutoOTB_idx` (`Fk_ProdutosOTB`),
  CONSTRAINT `Fk_Compras` FOREIGN KEY (`Fk_ComprasOTB`) REFERENCES `comprasotb` (`IdComprasOTB`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Fk_ProdutoOTB` FOREIGN KEY (`Fk_ProdutosOTB`) REFERENCES `produtootb` (`idProdutoOTB`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comprasprodutosotb`
--

LOCK TABLES `comprasprodutosotb` WRITE;
/*!40000 ALTER TABLE `comprasprodutosotb` DISABLE KEYS */;
/*!40000 ALTER TABLE `comprasprodutosotb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fornecedorotb`
--

DROP TABLE IF EXISTS `fornecedorotb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fornecedorotb` (
  `IdFornecedorOTB` int(11) NOT NULL,
  `Fk_UsuarioOTB` int(9) NOT NULL,
  `NomeOTB` varchar(45) NOT NULL,
  `CPFOTB` varchar(45) NOT NULL,
  `DataNascOTB` date NOT NULL,
  PRIMARY KEY (`IdFornecedorOTB`),
  KEY `Fk_UsuarioOTB_idx` (`Fk_UsuarioOTB`),
  CONSTRAINT `Fk_UsuarioFornecedorOTB` FOREIGN KEY (`Fk_UsuarioOTB`) REFERENCES `usuariootb` (`IdUsuarioOTB`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornecedorotb`
--

LOCK TABLES `fornecedorotb` WRITE;
/*!40000 ALTER TABLE `fornecedorotb` DISABLE KEYS */;
INSERT INTO `fornecedorotb` VALUES (123,1,'Guilherme Vieira Osterberg','09464273135','2005-12-29'),(12341354,1,'Guilherme','094.642.731-35','2005-12-29');
/*!40000 ALTER TABLE `fornecedorotb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtootb`
--

DROP TABLE IF EXISTS `produtootb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produtootb` (
  `idProdutoOTB` int(9) NOT NULL,
  `NomeOTB` varchar(45) NOT NULL,
  `PrecoOTB` decimal(11,2) NOT NULL,
  `EstoqueOTB` varchar(45) NOT NULL,
  `Marca` varchar(45) NOT NULL,
  PRIMARY KEY (`idProdutoOTB`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtootb`
--

LOCK TABLES `produtootb` WRITE;
/*!40000 ALTER TABLE `produtootb` DISABLE KEYS */;
INSERT INTO `produtootb` VALUES (123,'I5 12400F',700.00,'Disponivel','Intel'),(1234,'I3 10100',400.00,'Disponivel','Intel');
/*!40000 ALTER TABLE `produtootb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuariootb`
--

DROP TABLE IF EXISTS `usuariootb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuariootb` (
  `IdUsuarioOTB` int(9) NOT NULL,
  `NomeOTB` varchar(45) NOT NULL,
  `ApelidoOTB` varchar(45) NOT NULL,
  `CPFOTB` varchar(45) NOT NULL,
  `DataNascOTB` date NOT NULL,
  `SenhaOTB` varchar(45) NOT NULL,
  `Ativo` varchar(1) NOT NULL,
  `Nivel` int(11) NOT NULL,
  PRIMARY KEY (`IdUsuarioOTB`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuariootb`
--

LOCK TABLES `usuariootb` WRITE;
/*!40000 ALTER TABLE `usuariootb` DISABLE KEYS */;
INSERT INTO `usuariootb` VALUES (1,'Guilherme Vieira Osterberg','Guilherme132BR','542.159.601-00','2025-12-29','132546879Gui@','S',2),(123,'Guillherme Vieira Osterberg','Guilherme132BR','094.642.731-35','2005-12-29','132546879Gui','S',2);
/*!40000 ALTER TABLE `usuariootb` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-12-13  1:22:47
