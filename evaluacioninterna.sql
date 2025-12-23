-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.3-rc-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for evaluacioninterna
DROP DATABASE IF EXISTS `evaluacioninterna`;
CREATE DATABASE IF NOT EXISTS `evaluacioninterna` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `evaluacioninterna`;

-- Dumping structure for table evaluacioninterna.numeropreguntas
DROP TABLE IF EXISTS `numeropreguntas`;
CREATE TABLE IF NOT EXISTS `numeropreguntas` (
  `NoPreguntas` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table evaluacioninterna.numeropreguntas: ~1 rows (approximately)
/*!40000 ALTER TABLE `numeropreguntas` DISABLE KEYS */;
INSERT INTO `numeropreguntas` (`NoPreguntas`) VALUES
	(50);
/*!40000 ALTER TABLE `numeropreguntas` ENABLE KEYS */;

-- Dumping structure for table evaluacioninterna.preguntasexamen
DROP TABLE IF EXISTS `preguntasexamen`;
CREATE TABLE IF NOT EXISTS `preguntasexamen` (
  `IDpreguntas` int(11) NOT NULL AUTO_INCREMENT,
  `IDpregunta` int(11) NOT NULL DEFAULT '0',
  `Lectura` varchar(300) DEFAULT NULL,
  `Pregunta` varchar(200) DEFAULT NULL,
  `OpcionA` varchar(150) DEFAULT NULL,
  `OpcionB` varchar(150) DEFAULT NULL,
  `OpcionC` varchar(150) DEFAULT NULL,
  `OpcionD` varchar(150) DEFAULT NULL,
  `Correcta` varchar(150) DEFAULT NULL,
  `Explicacion` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`IDpreguntas`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;

-- Dumping data for table evaluacioninterna.preguntasexamen: ~50 rows (approximately)
/*!40000 ALTER TABLE `preguntasexamen` DISABLE KEYS */;
INSERT INTO `preguntasexamen` (`IDpreguntas`, `IDpregunta`, `Lectura`, `Pregunta`, `OpcionA`, `OpcionB`, `OpcionC`, `OpcionD`, `Correcta`, `Explicacion`) VALUES
	(32, 1, '1Aectura', 'TextoLeer', 'OpcionA', 'OpcionB', 'OpcionC', 'OpcionD', 'OpcionA', 'ExplicacionA\r'),
	(33, 2, '2Amigos', 'Tonterias', 'OlaA', 'OlaB', 'OlaC', 'OlaD', 'OlaB', 'ExplicacionB\r'),
	(34, 3, '3Aectura', 'TextoLeer', 'OpcionA', 'OpcionB', 'OpcionC', 'OpcionD', 'OpcionA', 'ExplicacionA\r'),
	(35, 4, '4Amigos', 'Tonterias', 'OlaA', 'OlaB', 'OlaC', 'OlaD', 'OlaB', 'ExplicacionB\r'),
	(36, 5, '5Aectura', 'TextoLeer', 'OpcionA', 'OpcionB', 'OpcionC', 'OpcionD', 'OpcionA', 'ExplicacionA\r'),
	(37, 6, '6Amigos', 'Tonterias', 'OlaA', 'OlaB', 'OlaC', 'OlaD', 'OlaB', 'ExplicacionB\r'),
	(38, 7, '7Aectura', 'TextoLeer', 'OpcionA', 'OpcionB', 'OpcionC', 'OpcionD', 'OpcionA', 'ExplicacionA\r'),
	(39, 8, '8Amigos', 'Tonterias', 'OlaA', 'OlaB', 'OlaC', 'OlaD', 'OlaB', 'ExplicacionB\r'),
	(40, 9, '9Aectura', 'TextoLeer', 'OpcionA', 'OpcionB', 'OpcionC', 'OpcionD', 'OpcionA', 'ExplicacionA\r'),
	(41, 10, '10Amigos', 'Tonterias', 'OlaA', 'OlaB', 'OlaC', 'OlaD', 'OlaB', 'ExplicacionB\r'),
	(42, 11, '11Aectura', 'TextoLeer', 'OpcionA', 'OpcionB', 'OpcionC', 'OpcionD', 'OpcionA', 'ExplicacionA\r'),
	(43, 12, '12Amigos', 'Tonterias', 'OlaA', 'OlaB', 'OlaC', 'OlaD', 'OlaB', 'ExplicacionB\r'),
	(44, 13, '13Aectura', 'TextoLeer', 'OpcionA', 'OpcionB', 'OpcionC', 'OpcionD', 'OpcionA', 'ExplicacionA\r'),
	(45, 14, '14Amigos', 'Tonterias', 'OlaA', 'OlaB', 'OlaC', 'OlaD', 'OlaB', 'ExplicacionB\r'),
	(46, 15, '15Aectura', 'TextoLeer', 'OpcionA', 'OpcionB', 'OpcionC', 'OpcionD', 'OpcionA', 'ExplicacionA\r'),
	(47, 16, '16Amigos', 'Tonterias', 'OlaA', 'OlaB', 'OlaC', 'OlaD', 'OlaB', 'ExplicacionB\r'),
	(48, 17, '17Aectura', 'TextoLeer', 'OpcionA', 'OpcionB', 'OpcionC', 'OpcionD', 'OpcionA', 'ExplicacionA\r'),
	(49, 18, '18Amigos', 'Tonterias', 'OlaA', 'OlaB', 'OlaC', 'OlaD', 'OlaB', 'ExplicacionB\r'),
	(50, 19, '19Aectura', 'TextoLeer', 'OpcionA', 'OpcionB', 'OpcionC', 'OpcionD', 'OpcionA', 'ExplicacionA\r'),
	(51, 20, '20Amigos', 'Tonterias', 'OlaA', 'OlaB', 'OlaC', 'OlaD', 'OlaB', 'ExplicacionB\r'),
	(52, 21, '21Aectura', 'TextoLeer', 'OpcionA', 'OpcionB', 'OpcionC', 'OpcionD', 'OpcionA', 'ExplicacionA\r'),
	(53, 22, '22Amigos', 'Tonterias', 'OlaA', 'OlaB', 'OlaC', 'OlaD', 'OlaB', 'ExplicacionB\r'),
	(54, 23, '23Aectura', 'TextoLeer', 'OpcionA', 'OpcionB', 'OpcionC', 'OpcionD', 'OpcionA', 'ExplicacionA\r'),
	(55, 24, '24Amigos', 'Tonterias', 'OlaA', 'OlaB', 'OlaC', 'OlaD', 'OlaB', 'ExplicacionB\r'),
	(56, 25, '25Aectura', 'TextoLeer', 'OpcionA', 'OpcionB', 'OpcionC', 'OpcionD', 'OpcionA', 'ExplicacionA\r'),
	(57, 26, '26Amigos', 'Tonterias', 'OlaA', 'OlaB', 'OlaC', 'OlaD', 'OlaB', 'ExplicacionB\r'),
	(58, 27, '27Aectura', 'TextoLeer', 'OpcionA', 'OpcionB', 'OpcionC', 'OpcionD', 'OpcionA', 'ExplicacionA\r'),
	(59, 28, '28Amigos', 'Tonterias', 'OlaA', 'OlaB', 'OlaC', 'OlaD', 'OlaB', 'ExplicacionB\r'),
	(60, 29, '29Aectura', 'TextoLeer', 'OpcionA', 'OpcionB', 'OpcionC', 'OpcionD', 'OpcionA', 'ExplicacionA\r'),
	(61, 30, '30Amigos', 'Tonterias', 'OlaA', 'OlaB', 'OlaC', 'OlaD', 'OlaB', 'ExplicacionB\r'),
	(62, 31, '31Aectura', 'TextoLeer', 'OpcionA', 'OpcionB', 'OpcionC', 'OpcionD', 'OpcionA', 'ExplicacionA\r'),
	(63, 32, '32Amigos', 'Tonterias', 'OlaA', 'OlaB', 'OlaC', 'OlaD', 'OlaB', 'ExplicacionB\r'),
	(64, 33, '33Aectura', 'TextoLeer', 'OpcionA', 'OpcionB', 'OpcionC', 'OpcionD', 'OpcionA', 'ExplicacionA\r'),
	(65, 34, '34Amigos', 'Tonterias', 'OlaA', 'OlaB', 'OlaC', 'OlaD', 'OlaB', 'ExplicacionB\r'),
	(66, 35, '35Aectura', 'TextoLeer', 'OpcionA', 'OpcionB', 'OpcionC', 'OpcionD', 'OpcionA', 'ExplicacionA\r'),
	(67, 36, '36Amigos', 'Tonterias', 'OlaA', 'OlaB', 'OlaC', 'OlaD', 'OlaB', 'ExplicacionB\r'),
	(68, 37, '37Aectura', 'TextoLeer', 'OpcionA', 'OpcionB', 'OpcionC', 'OpcionD', 'OpcionA', 'ExplicacionA\r'),
	(69, 38, '38Amigos', 'Tonterias', 'OlaA', 'OlaB', 'OlaC', 'OlaD', 'OlaB', 'ExplicacionB\r'),
	(70, 39, '39Aectura', 'TextoLeer', 'OpcionA', 'OpcionB', 'OpcionC', 'OpcionD', 'OpcionA', 'ExplicacionA\r'),
	(71, 40, '40Amigos', 'Tonterias', 'OlaA', 'OlaB', 'OlaC', 'OlaD', 'OlaB', 'ExplicacionB\r'),
	(72, 41, '41Aectura', 'TextoLeer', 'OpcionA', 'OpcionB', 'OpcionC', 'OpcionD', 'OpcionA', 'ExplicacionA\r'),
	(73, 42, '42Amigos', 'Tonterias', 'OlaA', 'OlaB', 'OlaC', 'OlaD', 'OlaB', 'ExplicacionB\r'),
	(74, 43, '43Aectura', 'TextoLeer', 'OpcionA', 'OpcionB', 'OpcionC', 'OpcionD', 'OpcionA', 'ExplicacionA\r'),
	(75, 44, '44Amigos', 'Tonterias', 'OlaA', 'OlaB', 'OlaC', 'OlaD', 'OlaB', 'ExplicacionB\r'),
	(76, 45, '45Aectura', 'TextoLeer', 'OpcionA', 'OpcionB', 'OpcionC', 'OpcionD', 'OpcionA', 'ExplicacionA\r'),
	(77, 46, '46Amigos', 'Tonterias', 'OlaA', 'OlaB', 'OlaC', 'OlaD', 'OlaB', 'ExplicacionB\r'),
	(78, 47, '47Aectura', 'TextoLeer', 'OpcionA', 'OpcionB', 'OpcionC', 'OpcionD', 'OpcionA', 'ExplicacionA\r'),
	(79, 48, '48Amigos', 'Tonterias', 'OlaA', 'OlaB', 'OlaC', 'OlaD', 'OlaB', 'ExplicacionB\r'),
	(80, 49, '49Aectura', 'TextoLeer', 'OpcionA', 'OpcionB', 'OpcionC', 'OpcionD', 'OpcionA', 'ExplicacionA\r'),
	(81, 50, '50Amigos', 'Tonterias', 'OlaA', 'OlaB', 'OlaC', 'OlaD', 'OlaB', 'ExplicacionB\r');
/*!40000 ALTER TABLE `preguntasexamen` ENABLE KEYS */;

-- Dumping structure for table evaluacioninterna.sesiones
DROP TABLE IF EXISTS `sesiones`;
CREATE TABLE IF NOT EXISTS `sesiones` (
  `IDsesion` int(11) NOT NULL AUTO_INCREMENT,
  `IDusuario` int(11) NOT NULL,
  `codigo` varchar(100) NOT NULL,
  `noP1` int(11) DEFAULT NULL,
  `noP2` int(11) DEFAULT NULL,
  `noP3` int(11) DEFAULT NULL,
  `noP4` int(11) DEFAULT NULL,
  `noP5` int(11) DEFAULT NULL,
  `noP6` int(11) DEFAULT NULL,
  `noP7` int(11) DEFAULT NULL,
  `noP8` int(11) DEFAULT NULL,
  `noP9` int(11) DEFAULT NULL,
  `noP10` int(11) DEFAULT NULL,
  `noP11` int(11) DEFAULT NULL,
  `noP12` int(11) DEFAULT NULL,
  `noP13` int(11) DEFAULT NULL,
  `noP14` int(11) DEFAULT NULL,
  `noP15` int(11) DEFAULT NULL,
  `noP16` int(11) DEFAULT NULL,
  `noP17` int(11) DEFAULT NULL,
  `noP18` int(11) DEFAULT NULL,
  `noP19` int(11) DEFAULT NULL,
  `noP20` int(11) DEFAULT NULL,
  `noP21` int(11) DEFAULT NULL,
  `noP22` int(11) DEFAULT NULL,
  `noP23` int(11) DEFAULT NULL,
  `noP24` int(11) DEFAULT NULL,
  `noP25` int(11) DEFAULT NULL,
  `reP1` varchar(150) DEFAULT 'respuestaVacia',
  `reP2` varchar(150) DEFAULT 'respuestaVacia',
  `reP3` varchar(150) DEFAULT 'respuestaVacia',
  `reP4` varchar(150) DEFAULT 'respuestaVacia',
  `reP5` varchar(150) DEFAULT 'respuestaVacia',
  `reP6` varchar(150) DEFAULT 'respuestaVacia',
  `reP7` varchar(150) DEFAULT 'respuestaVacia',
  `reP8` varchar(150) DEFAULT 'respuestaVacia',
  `reP9` varchar(150) DEFAULT 'respuestaVacia',
  `reP10` varchar(150) DEFAULT 'respuestaVacia',
  `reP11` varchar(150) DEFAULT 'respuestaVacia',
  `reP12` varchar(150) DEFAULT 'respuestaVacia',
  `reP13` varchar(150) DEFAULT 'respuestaVacia',
  `reP14` varchar(150) DEFAULT 'respuestaVacia',
  `reP15` varchar(150) DEFAULT 'respuestaVacia',
  `reP16` varchar(150) DEFAULT 'respuestaVacia',
  `reP17` varchar(150) DEFAULT 'respuestaVacia',
  `reP18` varchar(150) DEFAULT 'respuestaVacia',
  `reP19` varchar(150) DEFAULT 'respuestaVacia',
  `reP20` varchar(150) DEFAULT 'respuestaVacia',
  `reP21` varchar(150) DEFAULT 'respuestaVacia',
  `reP22` varchar(150) DEFAULT 'respuestaVacia',
  `reP23` varchar(150) DEFAULT 'respuestaVacia',
  `reP24` varchar(150) DEFAULT 'respuestaVacia',
  `reP25` varchar(150) DEFAULT 'respuestaVacia',
  `abierta` varchar(5) DEFAULT NULL COMMENT 'Only true or false',
  `punteo` int(11) DEFAULT NULL,
  `horaInicio` time DEFAULT NULL,
  `horaFinal` time DEFAULT NULL,
  `fecha` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IDsesion`,`IDusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8;

-- Dumping data for table evaluacioninterna.sesiones: ~9 rows (approximately)
/*!40000 ALTER TABLE `sesiones` DISABLE KEYS */;
INSERT INTO `sesiones` (`IDsesion`, `IDusuario`, `codigo`, `noP1`, `noP2`, `noP3`, `noP4`, `noP5`, `noP6`, `noP7`, `noP8`, `noP9`, `noP10`, `noP11`, `noP12`, `noP13`, `noP14`, `noP15`, `noP16`, `noP17`, `noP18`, `noP19`, `noP20`, `noP21`, `noP22`, `noP23`, `noP24`, `noP25`, `reP1`, `reP2`, `reP3`, `reP4`, `reP5`, `reP6`, `reP7`, `reP8`, `reP9`, `reP10`, `reP11`, `reP12`, `reP13`, `reP14`, `reP15`, `reP16`, `reP17`, `reP18`, `reP19`, `reP20`, `reP21`, `reP22`, `reP23`, `reP24`, `reP25`, `abierta`, `punteo`, `horaInicio`, `horaFinal`, `fecha`) VALUES
	(75, 2005003391, '20050033913627/08/2018 08:50:26', 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 'A', 'C2', 'DD', 'AAA', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'false', 1, '08:50:26', '08:50:50', '2018/08/17'),
	(76, 2005003391, '200500339188927/08/2018 08:50:57', 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 'A', 'B2', 'CC', 'DDD', 'BBBB', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'false', 4, '08:50:57', '08:51:14', '2018/08/18'),
	(77, 2005003391, '20050033919527/08/2018 08:51:18', 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 'A', 'B2', 'CC', 'DDD', 'AAAA', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'false', 5, '08:51:18', '08:51:36', '2018/08/19'),
	(78, 2005003390, '200500339099427/08/2018 08:51:47', 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 'A', 'B2', 'CC', 'DDD', 'AAAA', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'false', 5, '08:51:47', '08:52:07', '2018/08/20'),
	(79, 2005003390, '200500339011627/08/2018 08:52:10', 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 'A', 'B2', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'false', 2, '08:52:10', '08:52:19', '2018/08/21'),
	(80, 2005003391, '20050033913628/08/2018 18:32:27', 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 'A', 'B2', 'CC', 'DDD', 'BBBB', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'false', 4, '18:32:27', '18:32:58', '2018/08/28'),
	(81, 2005003391, '200500339148829/08/2018 16:25:47', 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 'OpcionA', 'OlaB', 'OpcionA', 'OlaB', 'OpcionD', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'false', 4, '16:25:47', '16:26:09', '2018/08/29'),
	(82, 2005003391, '200500339137429/08/2018 16:26:42', 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 'OpcionA', 'OlaB', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'false', 2, '16:26:42', '16:26:57', '2018/08/29'),
	(83, 2005003391, '200500339160030/08/2018 11:48:43', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'respuestaVacia', 'false', 1, '11:48:43', '11:49:31', '2018/08/30');
/*!40000 ALTER TABLE `sesiones` ENABLE KEYS */;

-- Dumping structure for table evaluacioninterna.usuario
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `ID usuario` int(11) NOT NULL,
  `Nombres` varchar(50) NOT NULL,
  `Apellidos` varchar(50) NOT NULL,
  `Profesor` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`ID usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table evaluacioninterna.usuario: ~2 rows (approximately)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`ID usuario`, `Nombres`, `Apellidos`, `Profesor`) VALUES
	(875684456, 'Juan', 'Perez', 'false'),
	(2005003391, 'Javier', 'Avalos', 'false');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
