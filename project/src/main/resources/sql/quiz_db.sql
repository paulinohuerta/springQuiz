CREATE DATABASE IF NOT EXISTS `quiz` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `quiz`;


# Dumping structure for table pregunta
DROP TABLE IF EXISTS `pregunta`;
CREATE TABLE IF NOT EXISTS `pregunta` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `texto` varchar(60) NOT NULL,
  `link`  varchar(100) NOT NULL,
  `op1` varchar(20) NOT NULL,
  `op2` varchar(20) NOT NULL,
  `op3` varchar(20) NOT NULL,
  `op4` varchar(20) NOT NULL,
  `well` varchar(5) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Contains information about pregunta table';

INSERT INTO PREGUNTA (texto,link,op1,op2,op3,op4,well) VALUES ('Autor del lenguaje','http://servidor.iespoligonosur.org/Materiales/Modulos/ED/fotos/b1.jpg','python','ruby','rust','ninguna','4');

INSERT INTO PREGUNTA (texto,link,op1,op2,op3,op4,well) VALUES ('Quién descubrió América','http://servidor.iespoligonosur.org','rebeca','lopera','Colón','ninguna','3');

INSERT INTO PREGUNTA (texto,link,op1,op2,op3,op4,well) VALUES ('Disfrutamos sus tutoriales de','http://servidor.iespoligonosur.org/Materiales/Modulos/ED/fotos/b0.jpg','java8','nokogiri','java/spring/jsf','ninguna','4');
