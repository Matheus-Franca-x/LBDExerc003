USE master
GO
DROP DATABASE viagem

CREATE DATABASE viagem
GO
USE viagem
GO
CREATE TABLE motorista
(
	codigo				INT 		NOT NULL,
	nome				VARCHAR(40) NOT NULL,
	naturalidade		VARCHAR(40) NOT NULL
	PRIMARY KEY (codigo)
)
GO
CREATE TABLE onibus
(
	placa				CHAR(7) 	NOT NULL,
	marca				VARCHAR(15) NOT NULL,
	ano					INT 		NOT NULL,
	descricao			VARCHAR(20) NOT NULL
	PRIMARY KEY (placa)
)
GO
CREATE TABLE viagem
(
	codigo				INT 		NOT NULL,
	onibus_placa		CHAR(7) 	NOT NULL,
	motorista_codigo	INT 		NOT NULL,
	hora_saida			INT 		NOT NULL CHECK(hora_saida >= 0),
	hora_chegada		INT 		NOT NULL CHECK(hora_chegada >= 0),
	partida				VARCHAR(40) NOT NULL,
	destino				VARCHAR(40) NOT NULL
	PRIMARY KEY (codigo)
	FOREIGN KEY (onibus_placa) REFERENCES onibus (placa),
	FOREIGN KEY (motorista_codigo) REFERENCES motorista (codigo)
)

INSERT INTO motorista (codigo, nome, naturalidade) VALUES
(12341, 'Julio Cesar', 'São Paulo'),
(12342, 'Mario Carmo', 'Americana'),
(12343, 'Lucio Castro', 'Campinas'),
(12344, 'André Figueiredo', 'São Paulo'),
(12345, 'Luiz Carlos', 'São Paulo'),
(12346, 'Carlos Roberto', 'Campinas'),
(12347, 'João Paulo', 'São Paulo')

INSERT INTO onibus (placa, marca, ano, descricao) VALUES
('adf0965', 'Mercedes', 2009, 'Leito'),
('bhg7654', 'Mercedes', 2012, 'Sem Banheiro'),
('dtr2093', 'Mercedes', 2017, 'Ar Condicionado'),
('gui7625', 'Volvo', 2014, 'Ar Condicionado'),
('jhy9425', 'Volvo', 2018, 'Leito'),
('lmk7485', 'Mercedes', 2015, 'Ar Condicionado'),
('aqw2374', 'Volvo', 2014, 'Leito')

INSERT INTO viagem (codigo, onibus_placa, motorista_codigo, hora_saida, hora_chegada, partida, destino) VALUES
(101, 'adf0965', 12343, 10, 12, 'São Paulo', 'Campinas'),
(102, 'gui7625', 12341, 7, 12, 'São Paulo', 'Araraquara'),
(103, 'bhg7654', 12345, 14, 22, 'São Paulo', 'Rio de Janeiro'),
(104, 'dtr2093', 12344, 18, 21, 'São Paulo', 'Sorocaba'),
(105, 'aqw2374', 12342, 11, 17, 'São Paulo', 'Ribeirão Preto'),
(106, 'jhy9425', 12347, 10, 19, 'São Paulo', 'São José do Rio Preto'),
(107, 'lmk7485', 12346, 13, 20, 'São Paulo', 'Curitiba'),
(108, 'adf0965', 12343, 14, 16, 'Campinas', 'São Paulo'),
(109, 'gui7625', 12341, 14, 19, 'Araraquara', 'São Paulo'),
(110, 'bhg7654', 12345, 0, 8, 'Rio de Janeiro', 'São Paulo'),
(111, 'dtr2093', 12344, 22, 1, 'Sorocaba', 'São Paulo'),
(112, 'aqw2374', 12342, 19, 5, 'Ribeirão Preto', 'São Paulo'),
(113, 'jhy9425', 12347, 22, 7, 'São José do Rio Preto', 'São Paulo'),
(114, 'lmk7485', 12346, 0, 7, 'Curitiba', 'São Paulo')


