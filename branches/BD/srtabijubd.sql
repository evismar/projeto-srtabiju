-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: 29/12/2012 às 21h29min
-- Versão do Servidor: 5.5.16
-- Versão do PHP: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `srtabijubd`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `categoria`
--

CREATE TABLE IF NOT EXISTS `categoria` (
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Extraindo dados da tabela `categoria`
--

INSERT INTO `categoria` (`id_categoria`, `descricao`, `nome`) VALUES
(2, 'Colares de todos os tipos', 'Colar'),
(3, 'Pulseiras de todos os tipos', 'Pulseira'),
(4, 'Brincos  de todos os tipos', 'Brincos');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `celular` varchar(255) DEFAULT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  `id_endereco` int(11) DEFAULT NULL,
  `gestor` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_cliente`),
  KEY `FK96841DDAFF098A3F` (`id_endereco`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=22 ;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `celular`, `cpf`, `data_nascimento`, `email`, `login`, `nome`, `senha`, `telefone`, `id_endereco`, `gestor`) VALUES
(12, '', '111222334', '1111-12-12', 'evismar97@hotmail.com', '', 'Testando', '', '', 14, 0),
(13, '', '03333317493', NULL, 'teomar.melo@gmail.com', 'teomar', 'Zé', '085471', '86796294', NULL, 0),
(14, '', '03333317493', NULL, 'teomar.melo@gmail.com', 'teomar', 'Zé', '085471', '86796294', NULL, 0),
(15, '', '03333317493', NULL, 'teomar.melo@gmail.com', 'teomar', 'Zé', '085471', '86796294', NULL, 0),
(16, '', '111222334', '1111-12-12', '', '', 'Testando', '', '', 15, 0),
(17, '', '08033125470', '1111-12-12', '', '', 'Testando', '', '', 16, 0),
(18, '', '111222334', '1111-12-12', '', '', 'Testando', '', '', 17, 0),
(19, '', '08033125470', '1111-12-12', '', '', 'gabriela jôse candida dos santos', '', '', 18, 0),
(20, '', '11111', '1111-12-12', '', 'gestor', 'gestor', 'gestor', '', 19, 1),
(21, '', '111222334', '1111-12-12', '', 'cliente', 'cliente', 'cliente', '', 20, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE IF NOT EXISTS `endereco` (
  `id_endereco` int(11) NOT NULL AUTO_INCREMENT,
  `bairro` varchar(255) DEFAULT NULL,
  `cep` varchar(255) DEFAULT NULL,
  `cidade` varchar(255) DEFAULT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `rua` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_endereco`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`id_endereco`, `bairro`, `cep`, `cidade`, `complemento`, `estado`, `numero`, `rua`) VALUES
(14, '', '', '', '', '', '', ''),
(15, '', '', '', '', '', '', ''),
(16, '', '', '', '', '', '', ''),
(17, '', '', '', '', '', '', ''),
(18, '', '', '', '', '', '', ''),
(19, '', '', '', '', '', '', ''),
(20, '', '', '', '', '', '', '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `estoque`
--

CREATE TABLE IF NOT EXISTS `estoque` (
  `id_estoque` int(11) NOT NULL AUTO_INCREMENT,
  `categoria` int(11) DEFAULT NULL,
  `produto` int(11) DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_estoque`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `formadepagamento`
--

CREATE TABLE IF NOT EXISTS `formadepagamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `formaDePagamento` varchar(255) DEFAULT NULL,
  `vezes` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `formadepagamento`
--

INSERT INTO `formadepagamento` (`id`, `formaDePagamento`, `vezes`) VALUES
(1, NULL, 3),
(2, 'Teste', 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `itemdepedido`
--

CREATE TABLE IF NOT EXISTS `itemdepedido` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idPedido` int(11) DEFAULT NULL,
  `produto` int(11) DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `id_pedido` int(11) DEFAULT NULL,
  `id_produto` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK304D5B796AE044B9` (`id_pedido`),
  KEY `FK304D5B79BE41B077` (`id_pedido`),
  KEY `FK304D5B79378459A5` (`id_produto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedido`
--

CREATE TABLE IF NOT EXISTS `pedido` (
  `id_pedido` int(11) NOT NULL AUTO_INCREMENT,
  `id_cliente` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_pedido`),
  KEY `FK8E420365C2FFC7A7` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE IF NOT EXISTS `produto` (
  `id_Produto` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  `id_categoria` int(11) DEFAULT NULL,
  `id_estoque` int(11) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `preco` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_Produto`),
  KEY `FK50C666D99FD25D59` (`id_categoria`),
  KEY `FK50C666D9AFBBC0A3` (`id_estoque`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`id_Produto`, `descricao`, `id_categoria`, `id_estoque`, `nome`, `preco`) VALUES
(1, 'bla bla bla', NULL, NULL, '', 'Colar');

--
-- Restrições para as tabelas dumpadas
--

--
-- Restrições para a tabela `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `FK96841DDAFF098A3F` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`id_endereco`);

--
-- Restrições para a tabela `itemdepedido`
--
ALTER TABLE `itemdepedido`
  ADD CONSTRAINT `FK304D5B79378459A5` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id_Produto`),
  ADD CONSTRAINT `FK304D5B796AE044B9` FOREIGN KEY (`id_pedido`) REFERENCES `produto` (`id_Produto`),
  ADD CONSTRAINT `FK304D5B79BE41B077` FOREIGN KEY (`id_pedido`) REFERENCES `pedido` (`id_pedido`);

--
-- Restrições para a tabela `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `FK8E420365C2FFC7A7` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`);

--
-- Restrições para a tabela `produto`
--
ALTER TABLE `produto`
  ADD CONSTRAINT `FK50C666D99FD25D59` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`),
  ADD CONSTRAINT `FK50C666D9AFBBC0A3` FOREIGN KEY (`id_estoque`) REFERENCES `estoque` (`id_estoque`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
