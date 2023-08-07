package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class FactoryConnection {

    private static Connection connection;
    private static final  String SQL_INIT_DB = """
            DROP TABLE IF EXISTS Conta;
            CREATE TABLE Conta(
                id    VARCHAR(36) PRIMARY KEY,
                nome  VARCHAR(100) NOT NULL,
                nome  VARCHAR(19) NOT NULL,
                saldo INT NOT NULL
            );
            
            """;

    public static Connection getConnection() throws Exception {
        if (connection == null) {
            Class.forName("org.h2.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:h2:/db/test", "sa", "");

            Statement statement = connection.createStatement();
            statement.execute(SQL_INIT_DB);
        }
        return connection;
    }
}
