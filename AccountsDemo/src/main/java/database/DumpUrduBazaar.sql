CREATE DATABASE  IF NOT EXISTS `urdu-bazaar` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `urdu-bazaar`;
-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: urdu-bazaar
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `account_types`
--

DROP TABLE IF EXISTS `account_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_types` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(200) NOT NULL DEFAULT 'N/A',
  `active` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9076 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_types`
--

LOCK TABLES `account_types` WRITE;
/*!40000 ALTER TABLE `account_types` DISABLE KEYS */;
INSERT INTO `account_types` VALUES (1000,'Asset',1),(2000,'Liability',1),(3000,'Expenses',1),(4000,'Revenue',1),(5000,'Equity',1);
/*!40000 ALTER TABLE `account_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `account_type_fk` int DEFAULT '0',
  `active` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `account_type_fk_idx` (`account_type_fk`),
  CONSTRAINT `account_type_fk` FOREIGN KEY (`account_type_fk`) REFERENCES `account_types` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9122 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES (9076,'Bank',1000,1),(9077,'Accounts Receivable',1000,1),(9078,'Exchange on Foreign Receivables',1000,1),(9079,'Inventory',1000,1),(9080,'Equipment',1000,1),(9081,'Accumulated Depreciation Equipment',1000,1),(9082,'Revenue Collected in Advance (deposit)',2000,1),(9083,'Accounts Payable',2000,1),(9084,'Exchange on Foreign Payables',2000,1),(9085,'Sales Tax Payable',2000,1),(9086,'Accrued Income Tax Payable',2000,1),(9087,'Credit card',2000,1),(9088,'Retained Earnings',5000,1),(9089,'Salary',3000,1),(9090,'Sales',4000,1),(9091,'Cash Discounts',4000,1),(9092,'Cost of Goods Sold',3000,1),(9093,'Auto Supplies',3000,1),(9094,'Office Supplies',3000,1),(9095,'Courier',3000,1),(9096,'Telephone',3000,1),(9097,'Postage',3000,1),(9098,'Banking Charges',3000,1),(9099,'Meals and Entertainment',3000,1),(9100,'Travelling',3000,1),(9101,'Professional Fees',3000,1),(9102,'Business Taxes and Licenses',3000,1),(9103,'Charitable Donations',3000,1),(9104,'Courses and Training',3000,1),(9105,'Dues and Memberships',3000,1),(9106,'Magazines and Books',3000,1),(9107,'Promo and Gifts',3000,1),(9108,'Freight',3000,1),(9109,'Rent on Building',3000,1),(9110,'Business Use of Home',3000,1),(9111,'Electricity',3000,1),(9112,'Insurance',3000,1),(9113,'Water',3000,1),(9114,'Property Taxes',3000,1),(9115,'Depreciation Equipment',3000,1),(9116,'Gain/Loss Disposal of Assets',3000,1),(9117,'Misc Income and Expense',3000,1),(9118,'Gain/Loss Foreign Exchange',3000,1),(9119,'Bad Debts',3000,1),(9120,'Purchase Discounts',3000,1),(9121,'Income Tax',3000,1);
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `credit_account`
--

DROP TABLE IF EXISTS `credit_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `credit_account` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(200) DEFAULT NULL,
  `entry_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `amount` double NOT NULL DEFAULT '0',
  `general_fk` int DEFAULT NULL,
  `user_id_fk` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `account_fk_idx` (`general_fk`),
  CONSTRAINT `credit_general_fk` FOREIGN KEY (`general_fk`) REFERENCES `general_ledgers` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credit_account`
--

LOCK TABLES `credit_account` WRITE;
/*!40000 ALTER TABLE `credit_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `credit_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `debit_account`
--

DROP TABLE IF EXISTS `debit_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `debit_account` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(200) DEFAULT NULL,
  `entry_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `amount` double NOT NULL DEFAULT '0',
  `general_fk` int DEFAULT NULL,
  `user_id_fk` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_fk_idx` (`user_id_fk`),
  KEY `debit_general_fk_idx` (`general_fk`),
  CONSTRAINT `debit_general_fk` FOREIGN KEY (`general_fk`) REFERENCES `general_ledgers` (`id`),
  CONSTRAINT `user_fk` FOREIGN KEY (`user_id_fk`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `debit_account`
--

LOCK TABLES `debit_account` WRITE;
/*!40000 ALTER TABLE `debit_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `debit_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `general_ledgers`
--

DROP TABLE IF EXISTS `general_ledgers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `general_ledgers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `description` varchar(200) NOT NULL DEFAULT 'N/A',
  `opening_balance` float NOT NULL DEFAULT '0',
  `closing_balance` float NOT NULL DEFAULT '0',
  `debit` float NOT NULL DEFAULT '0',
  `credit` float NOT NULL DEFAULT '0',
  `account_fk` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `account_fk_idx` (`account_fk`),
  CONSTRAINT `account_fk` FOREIGN KEY (`account_fk`) REFERENCES `accounts` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `general_ledgers`
--

LOCK TABLES `general_ledgers` WRITE;
/*!40000 ALTER TABLE `general_ledgers` DISABLE KEYS */;
/*!40000 ALTER TABLE `general_ledgers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `cnic` varchar(45) DEFAULT NULL,
  `dob` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `cell` varchar(45) DEFAULT NULL,
  `active` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-23 14:08:30
