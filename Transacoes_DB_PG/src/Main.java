import java.sql.*;

public class Main {

    private static final String SQL_CREATE_TABLE = """
            DROP TABLE IF EXISTS USUARIO; 
            CREATE TABLE USUARIO(
                Id INT PRIMARY KEY,
                Nome VARCHAR(100) NOT NULL,
                Email VARCHAR(100) NOT NULL,
                Saldo numeric(15, 2) NOT NULL
            );
            
            """;

    private static final String SQL_INSERT = """
            INSERT INTO USUARIO (Id, Nome, Email, Saldo)
            VALUES (?, ?, ?, ?);
            """;

    private static final String SQL_UPDATE = "UPDATE USUARIO SET Saldo = ? WHERE Email = ?";

    public static void main(String[] args) throws Exception {

        Usuario usuario01 = new Usuario("Leandro", "leandro@gmail.com", 50d);

        Connection connection = null;

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);

            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
            psInsert.setInt(1, 1);
            psInsert.setString(2, usuario01.getNome());
            psInsert.setString(3, usuario01.getEmail());
            psInsert.setDouble(4, usuario01.getSaldo());

            psInsert.execute();

            connection.setAutoCommit(false);

            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
            psUpdate.setDouble(1, usuario01.aumentarSaldo(10d));
            psUpdate.setString(2, usuario01.getEmail());
            psUpdate.execute();

            connection.commit();

            connection.setAutoCommit(true);

            String exemploSql = "SELECT * FROM USUARIO";
            Statement status = connection.createStatement();
            ResultSet resultado = status.executeQuery(exemploSql);

            while (resultado.next()) {
                System.out.println(resultado.getInt(1)
                        + " " + resultado.getString(2)
                        + " " + resultado.getString(3)
                        + " " + resultado.getDouble(4));
            }

        } catch (Exception error) {

            error.printStackTrace();
            connection.rollback();

        } finally {
            connection.close();
        }

    }

    private static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    }
}