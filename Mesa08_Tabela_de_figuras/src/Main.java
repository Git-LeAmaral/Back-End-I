import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.*;

public class Main {

    private static final String SQL_CREATE_TABLE = """
            DROP TABLE IF EXISTS Figura;
            CREATE TABLE Figura(
                Id      VARCHAR(13) PRIMARY KEY,
                Nome    VARCHAR(50) NOT NULL,
                Cor     VARCHAR(50) NOT NULL
            );
            
            """;

    private static final String QUADRADO_AZUL =
            "INSERT INTO Figura VALUES('uuid_1', 'Quadrado', 'Azul')";
    private static final String QUADRADO_VERMELHO =
            "INSERT INTO Figura VALUES('uuid-2', 'Quadrado', 'Vermelho')";
    private static final String QUADRADO_AMARELO =
            "INSERT INTO Figura VALUES('uuid-3', 'Quadrado', 'Amarelo')";
    private static final String CIRCULO_AZUL =
            "INSERT INTO Figura VALUES('uuid-4', 'Circulo', 'Azul')";
    private static final String CIRCULO_VERMELHO =
            "INSERT INTO Figura VALUES('uuid-5', 'Circulo', 'Vermelho')";



    private static final String SQL_BUSCA_POR_COR = "SELECT * FROM Figura WHERE Cor = 'Vermelho'";
    private static final String SQL_TODAS_FIGURAS = "SELECT * FROM Figura";
/*
    private static final String SQL_INSERT = """
            INSERT INTO Figuras (Id, Nome, Cor)
            VALUES (?, ?, ?);
            """;

 */

    public static void main(String[] args) {

        final Logger log = Logger.getLogger(Main.class);

        Connection connection;
/*
        Figuras figura01 = new Figuras(1,"Circulo", "Azul");
        Figuras figura02 = new Figuras(2,"Circulo2", "Vermelho");
        Figuras figura03 = new Figuras(3,"Quadrado2", "Rosa");
        Figuras figura04 = new Figuras(4,"Quadrado3", "Amarelo");
        Figuras figura05 = new Figuras(5,"Quadrado4", "Vermelho");
 */

        try {
            log.info("Iniciando conexão");
            connection = getConnection();

            log.info("Criando Statement");
            Statement statement = connection.createStatement();

            log.info("Criando tabela Figuras no banco de dados");
            statement.execute(SQL_CREATE_TABLE);

            log.info("Inserindo figuras no banco de dados");
            statement.execute(CIRCULO_AZUL);
            statement.execute(CIRCULO_VERMELHO);
            statement.execute(QUADRADO_VERMELHO);
            statement.execute(QUADRADO_AZUL);
            statement.execute(QUADRADO_AMARELO);

            log.info("Selecionando todas as Figuras do banco de dados");
            statement.executeQuery(SQL_TODAS_FIGURAS);



            log.info("Fazendo busca por figuras de cor Vermelha");
            ResultSet resultSet = statement.executeQuery(SQL_BUSCA_POR_COR);

            while (resultSet.next()) {
                log.info("| id: %s | figura: %s | cor: %s |".formatted(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                ));
/*
                System.out.println(resultSet.getInt(1)
                        + " " + resultSet.getString(2)
                        + " " + resultSet.getString(3));

 */
            }



        } catch (Exception e) {
            log.error(e);
        }

    }

    private static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:file:./db/test", "sa", "");
    }
}