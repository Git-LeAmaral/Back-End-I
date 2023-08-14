CREATE TABLE IF NOT EXISTS Medicamento(
    id      INT PRIMARY KEY,
    nome    VARCHAR(255) NOT NULL,
    tipo_laboratorio   VARCHAR(255),
    quantidade  INT NOT NULL,
    preco    DECIMAL NOT NULL
);