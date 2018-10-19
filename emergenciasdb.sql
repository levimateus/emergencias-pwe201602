-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               10.1.19-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for emergenciasdb
CREATE DATABASE IF NOT EXISTS `emergenciasdb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `emergenciasdb`;

-- Dumping structure for table emergenciasdb.funcionario
CREATE TABLE IF NOT EXISTS `funcionario` (
  `func_id` int(11) NOT NULL AUTO_INCREMENT,
  `func_nome` varchar(255) CHARACTER SET utf8 NOT NULL,
  `func_sobrenome` varchar(255) CHARACTER SET utf8 NOT NULL,
  `func_email` varchar(255) CHARACTER SET utf8 NOT NULL,
  `func_cpf` varchar(255) CHARACTER SET utf8 NOT NULL,
  `func_endereco` varchar(255) CHARACTER SET utf8 NOT NULL,
  `func_login` varchar(255) CHARACTER SET utf8 NOT NULL,
  `func_senha` varchar(255) CHARACTER SET utf8 NOT NULL,
  `func_nivel` varchar(255) NOT NULL,
  `func_cargo` varchar(255) NOT NULL,
  `func_nasc_dt` varchar(255) NOT NULL,
  `ocorrencia_id` int(11),
  PRIMARY KEY (`func_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table emergenciasdb.funcionario: ~1 rows (approximately)
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` (`func_id`, `func_nome`, `func_sobrenome`, `func_email`, `func_cpf`, `func_endereco`, `func_login`, `func_senha`, `func_nivel`, `func_cargo`, `func_nasc_dt`, `ocorrencia_id`) VALUES
	(0, 'teste', 'teste', 'teste', 'teste', 'teste', 'teste', '123', 'teste', 'atendente', 'teste', 1);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;

-- Dumping structure for table emergenciasdb.ocorrencia
CREATE TABLE IF NOT EXISTS `ocorrencia` (
  `ocorrencia_id` int(11) NOT NULL AUTO_INCREMENT,
  `ocorrencia_estado` varchar(10) DEFAULT NULL,
  `ocorrencia_nivel` int(11) DEFAULT NULL,
  `ocorrencia_descricao` varchar(1000) CHARACTER SET utf8 DEFAULT NULL,
  `ocorrencia_comentarios` varchar(1000) CHARACTER SET utf8 DEFAULT NULL,
  `ocorrencia_registro_dt` varchar(255) DEFAULT NULL,
  `ocorrencia_data` varchar(255) DEFAULT NULL,
  `rua_id` int(11) DEFAULT NULL,
  `funcionario_id` int(11) DEFAULT NULL,
  `sensor_id` int(11) DEFAULT NULL,
  `ocorrencia_veiculo_tipo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ocorrencia_id`),
  KEY `rua_id` (`rua_id`),
  KEY `funcionario_id` (`funcionario_id`),
  KEY `sensor_id` (`sensor_id`),
  CONSTRAINT `ocorrencia_ibfk_1` FOREIGN KEY (`rua_id`) REFERENCES `rua` (`rua_id`),
  CONSTRAINT `ocorrencia_ibfk_2` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`func_id`),
  CONSTRAINT `ocorrencia_ibfk_4` FOREIGN KEY (`sensor_id`) REFERENCES `sensor` (`sensor_id`),
  CONSTRAINT `ocorrencia_ibfk_5` FOREIGN KEY (`ocorrencia_id`) REFERENCES `veiculo` (`ocorrencia_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table emergenciasdb.ocorrencia: ~0 rows (approximately)
/*!40000 ALTER TABLE `ocorrencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `ocorrencia` ENABLE KEYS */;

-- Dumping structure for table emergenciasdb.regiao
CREATE TABLE IF NOT EXISTS `regiao` (
  `regiao_id` int(11) NOT NULL AUTO_INCREMENT,
  `regiao_nome` varchar(255) CHARACTER SET utf8 NOT NULL,
  `regiao_qt_ocorrencia` int(11) NOT NULL,
  `regiao_periculosidade` float NOT NULL,
  PRIMARY KEY (`regiao_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table emergenciasdb.regiao: ~4 rows (approximately)
/*!40000 ALTER TABLE `regiao` DISABLE KEYS */;
INSERT INTO `regiao` (`regiao_id`, `regiao_nome`, `regiao_qt_ocorrencia`, `regiao_periculosidade`) VALUES
	(1, 'Regiao Fogo', 0, 0),
	(2, 'Regiao Agua', 0, 0),
	(3, 'Regiao Grama', 0, 0),
	(4, 'Regiao Fantasma', 0, 0);
/*!40000 ALTER TABLE `regiao` ENABLE KEYS */;

-- Dumping structure for table emergenciasdb.rua
CREATE TABLE IF NOT EXISTS `rua` (
  `rua_id` int(11) NOT NULL AUTO_INCREMENT,
  `rua_nome` varchar(255) CHARACTER SET utf8 NOT NULL,
  `rua_status` int(11) NOT NULL,
  `regiao_id` int(11) NOT NULL,
  `rua_loc_x` int(11) NOT NULL,
  `rua_loc_y` int(11) NOT NULL,
  PRIMARY KEY (`rua_id`),
  KEY `regiao_id` (`regiao_id`),
  CONSTRAINT `rua_ibfk_1` FOREIGN KEY (`regiao_id`) REFERENCES `regiao` (`regiao_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table emergenciasdb.rua: ~24 rows (approximately)
/*!40000 ALTER TABLE `rua` DISABLE KEYS */;
INSERT INTO `rua` (`rua_id`, `rua_nome`, `rua_status`, `regiao_id`, `rua_loc_x`, `rua_loc_y`) VALUES
	(1, 'Rua vulpix', 1, 1, 1, 0),
	(2, 'Rua Ninetails', 1, 1, 2, 1),
	(3, 'Rua Growlite', 1, 1, 3, 0),
	(4, 'Rua Arcanine', 1, 1, 3, 2),
	(5, 'Rua Charmander', 1, 1, 0, 1),
	(6, 'rua Charmeleon', 1, 1, 0, 3),
	(7, 'Rua Charizard', 1, 1, 1, 2),
	(8, 'Rua Blaziken', 1, 1, 2, 3),
	(9, 'Rua Lapras', 1, 2, 5, 0),
	(10, 'Rua Staryu', 1, 2, 4, 1),
	(11, 'Rua Starmie', 1, 2, 6, 1),
	(12, 'Rua Vaporeon', 1, 2, 5, 2),
	(13, 'Rua Kyogre', 1, 2, 4, 3),
	(14, 'Rua Blastoise', 1, 2, 6, 3),
	(15, 'Rua Gastly', 1, 4, 5, 4),
	(16, 'Rua Hunter', 1, 4, 6, 5),
	(17, 'Rua gengar', 1, 4, 4, 5),
	(18, 'Rua Giratina', 1, 4, 5, 6),
	(19, 'Rua Bulbasauro', 1, 3, 1, 4),
	(20, 'Rua Ivysauro', 1, 3, 3, 4),
	(21, 'Rua Venosauro', 1, 3, 2, 5),
	(22, 'Rua Chikorita', 1, 3, 0, 5),
	(23, 'Rua Bayleef', 1, 3, 1, 6),
	(24, 'Rua Meganium', 1, 3, 3, 6);
/*!40000 ALTER TABLE `rua` ENABLE KEYS */;

-- Dumping structure for table emergenciasdb.sensor
CREATE TABLE IF NOT EXISTS `sensor` (
  `sensor_id` int(11) NOT NULL AUTO_INCREMENT,
  `sensor_estado` tinyint(1) NOT NULL,
  `sensor_tipo` int(11) NOT NULL,
  `rua` int(11) NOT NULL,
  PRIMARY KEY (`sensor_id`),
  KEY `rua` (`rua`),
  CONSTRAINT `sensor_ibfk_1` FOREIGN KEY (`rua`) REFERENCES `rua` (`rua_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table emergenciasdb.sensor: ~0 rows (approximately)
/*!40000 ALTER TABLE `sensor` DISABLE KEYS */;
/*!40000 ALTER TABLE `sensor` ENABLE KEYS */;

-- Dumping structure for table emergenciasdb.veiculo
CREATE TABLE IF NOT EXISTS `veiculo` (
  `veiculo_id` int(11) NOT NULL AUTO_INCREMENT,
  `veiculo_tipo` varchar(50) CHARACTER SET utf8 NOT NULL,
  `veiculo_estado` varchar(10) CHARACTER SET utf8 NOT NULL,
  `veiculo_placa` varchar(10) CHARACTER SET utf8 NOT NULL,
  `rua_id` int(11) NOT NULL,
  `ocorrencia_id` int(11) NOT NULL,
  PRIMARY KEY (`veiculo_id`),
  KEY `rua` (`rua_id`),
  KEY `ocorrencia_id` (`ocorrencia_id`),
  CONSTRAINT `veiculo_ibfk_1` FOREIGN KEY (`rua_id`) REFERENCES `rua` (`rua_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table emergenciasdb.veiculo: ~0 rows (approximately)
/*!40000 ALTER TABLE `veiculo` DISABLE KEYS */;
/*!40000 ALTER TABLE `veiculo` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
