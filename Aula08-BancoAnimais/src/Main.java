import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    private static final String SQL_CREATE_TABLE = """
            DROP TABLE IF EXISTS Animal;
            CREATE TABLE Animal(
                  id    VARCHAR(36) PRIMARY KEY,
                  nome  VARCHAR(100) NOT NULL,
                  tipo  VARCHAR(100) NOT NULL
            );
            """;

    private static final String PITOCO = "INSERT INTO Animal values('uuid_1', 'pitoco', 'CACHORRO')";
    private static final String SUZI = "INSERT INTO Animal values('uuid_2', 'suzi', 'CACHORRO')";
    private static final String MEAU = "INSERT INTO Animal values('uuid_3', 'meau', 'GATO')";
    private static final String MARYLU = "INSERT INTO Animal values('uuid_4', 'marylu', 'VACA')";
    private static final String DRAGAO = "INSERT INTO Animal values('uuid_5', 'dragao', 'DRAGAO DE COMODO')";

    private static final String  SQL_GET_ALL = "SELECT * FROM Animal";
    private static final String  SQL_DELETE_PITOCO = "DELETE FROM Animal WHERE id='uuid_1'";

    public static void main(String[] args) {


        final Logger log = Logger.getLogger(Main.class);
            Connection connection;

        try {

            connection = getConnection();
            log.info("Criando Statement");
            Statement statement = connection.createStatement();

            log.info("Iniciando banco de dados");
            statement.execute(SQL_CREATE_TABLE);

            log.info("Inserindo animais no banco");
            statement.execute(PITOCO);
            statement.execute(MEAU);
            statement.execute(SUZI);
            statement.execute(MARYLU);
            statement.execute(DRAGAO);

            log.info("Executando getAll no banco");
            statement.executeQuery(SQL_GET_ALL);

            ResultSet resultSet = statement.executeQuery(SQL_GET_ALL);




            log.info("Logando valores retornados do banco");
            while (resultSet.next()) {
                log.info("id: %s nome: %s tipo: %s".formatted(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3)));
            }

            log.info("DELETANDO o coitado do pitoco");
            statement.execute(SQL_DELETE_PITOCO);
            resultSet = statement.executeQuery(SQL_GET_ALL);

            log.info("Logando valores retornados do banco");
            while (resultSet.next()) {
                log.info("id: %s nome: %s tipo: %s".formatted(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3)));
            }


            } catch (Exception e) {
                log.error(e);
            }
        }

        public static Connection getConnection() throws Exception {
            Class.forName("org.h2.Driver").newInstance();
            return DriverManager.getConnection("jdbc:h2:/db/test", "sa", "");
        }
    }
