package db;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class FactoryConnection {
    private static final Logger log = Logger.getLogger(FactoryConnection.class);

    private static Connection connection;
    private static final  String SQL_INIT_DB = """
            DROP TABLE IF EXISTS Conta;
            CREATE TABLE Conta(
                id    VARCHAR(36) PRIMARY KEY,
                nome  VARCHAR(100) NOT NULL,
                numero  VARCHAR(19) NOT NULL,
                saldo INT NOT NULL
            );
            
            """;

    public static Connection getConnection() throws Exception {
        log.info("Validando se existe uma conexão");
        if (connection == null) {
            log.info("Nenhuma conexão disponivel, criando nova conexão");

            Class.forName("org.h2.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:h2:/db/test", "sa", "");

            log.info("Criando tabela do banco de dados");

            Statement statement = connection.createStatement();
            statement.execute(SQL_INIT_DB);
        }
        return connection;
    }
}
