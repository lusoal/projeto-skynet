create database if not exists skynet;

use skynet;

create table if not exists precadastro(
	documento bigint not null primary key,
	tipo varchar(30) not null,
    status boolean not null,
    nome varchar(100) not null
);

create table if not exists cadastro(
	documento bigint not null primary key,
    nome varchar(100) not null,
    tipo varchar(100) not null,
    email varchar(150) not null,
    endereco varchar(300) not null,
    telefoneFixo int(10),
    telefoneCelular int(11) not null,
    nomeContato varchar(100) not null,
    documentoContato bigint not null,
    emailContato varchar(150) not null,
    senha varchar(12) not null,
    site varchar(200),
    dataAbertura datetime
);

create table if not exists usuarioAdicional(
	documento bigint not null primary key,
    documentoPrincipal bigint not null,
    nome varchar(100) not null,
    email varchar(150) not null,
    perfil varchar(11) not null,
    senha varchar(12) not null
);

ALTER TABLE `usuarioAdicional` ADD CONSTRAINT `fk_docPrincipal` FOREIGN KEY ( `documentoPrincipal` ) REFERENCES `cadastro` ( `documento` );

create table if not exists downloadArquivos(
	id int auto_increment not null primary key,
    documentoAdm bigint not null,
    nome varchar(40),
    conteudo MEDIUMBLOB not null
);

ALTER TABLE `downloadArquivos` ADD CONSTRAINT `fk_docAdm` FOREIGN KEY ( `documentoAdm` ) REFERENCES `cadastro` ( `documento` );

create table if not exists uploadArquivos(
	id int auto_increment not null primary key,
    documentoPrincipal bigint not null,
    nome varchar(40),
    conteudo MEDIUMBLOB not null
);

ALTER TABLE `uploadArquivos` ADD CONSTRAINT `fk_documenti` FOREIGN KEY ( `documentoPrincipal` ) REFERENCES `cadastro` ( `documento` );

