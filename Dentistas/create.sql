DROP TABLE IF EXISTS Dentista;

CREATE TABLE Dentista(
        ID                    INT PRIMARY KEY AUTO_INCREMENT ,
        NOME                  VARCHAR(255) NOT NULL,
        CRO                   VARCHAR(80)  NOT NULL,
        DATA_NASCIMENTO        DATE         NOT NULL,
        ESPECIALIDADE   VARCHAR(80)  NOT NULL

);