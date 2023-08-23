DROP TABLE IF EXISTS Veiculo;

CREATE TABLE Veiculo(
    id    INT PRIMARY KEY AUTO_INCREMENT,
    marca VARCHAR(255) NOT NULL,
    nome  VARCHAR(255) NOT NULL,
    cor   VARCHAR(255) NOT NULL,
    placa INT NOT NULL
);

INSERT INTO Veiculo(marca, nome, cor, placa)
VALUES ('VOLKSWAGEM', 'Golf', 'Preto', 5569);
INSERT INTO Veiculo(marca, nome, cor, placa)
VALUES ('TOYOTA', 'Corolla', 'Branco', 6632);
INSERT INTO Veiculo(marca, nome, cor, placa)
VALUES ('GM', 'Onix', 'Vermelho', 4877);
INSERT INTO Veiculo(marca, nome, cor, placa)
VALUES ('FIAT', 'Uno', 'verde', 3325);
INSERT INTO Veiculo(marca, nome, cor, placa)
VALUES ('FORD', 'Fusion', 'Preto', 7788);
INSERT INTO Veiculo(marca, nome, cor, placa)
VALUES ('VOLKSWAGEM', 'Fusca', 'Azul', 9865);