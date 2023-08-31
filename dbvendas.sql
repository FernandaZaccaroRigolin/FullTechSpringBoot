CREATE DATABASE  IF NOT EXISTS `dbvendas`;
USE `dbvendas`;

CREATE TABLE `tb_clientes` (
  `CPF` 			varchar(11) NOT NULL,
  `NOME` 			varchar(45) NOT NULL,
  `EMAIL` 			varchar(45) NOT NULL,
  `TELEFONE` 		varchar(45) NOT NULL,
  PRIMARY KEY (`CPF`)
);

CREATE TABLE `tb_pedidos`
(
    `ID`            	int  not null AUTO_INCREMENT,
	`CPF`     			varchar(11) not null,
	`DATA`           	datetime not null,
	`NUMEROPEDIDO`   	varchar(20) not null,
	PRIMARY KEY (`ID`),
	FOREIGN KEY (`CPF`) REFERENCES `tb_clientes` (`CPF`)
);

CREATE TABLE `tb_produtos`
(
    `ID`             int not null AUTO_INCREMENT,
	`DESCRICAO`      varchar(50) not null,
	`UNIDADE`        varchar(10) not null,
	`PRECO`          double not null,      
	PRIMARY KEY (`ID`)
);

CREATE TABLE `tb_itens`
(
    `ID`             int not null AUTO_INCREMENT,
	`IDPEDIDO`       int not null,
	`IDPRODUTO`      int not null,
    `PRECO`			 double not null,
	`QUANTIDADE`     double not null,
	PRIMARY KEY (`ID`),
	FOREIGN KEY (`IDPEDIDO`) REFERENCES tb_pedidos (`ID`),
	FOREIGN KEY (`IDPRODUTO`) REFERENCES tb_produtos (`ID`)
);
