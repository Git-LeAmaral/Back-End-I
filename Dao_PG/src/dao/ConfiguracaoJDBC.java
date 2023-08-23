package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConfiguracaoJDBC {
    private String driver;
    private String urlBancoDeDados;
    private String usuario;
    private String senha;
    private Connection connection;

    public ConfiguracaoJDBC(String driver,
                            String urlBancoDeDados,
                            String usuario, String senha, Connection connection) {
        this.driver = driver;
        this.urlBancoDeDados = urlBancoDeDados;
        this.usuario = usuario;
        this.senha = senha;
        this.connection = connection;
    }

    public ConfiguracaoJDBC() {
        this.driver = "org.h2.Driver";
        this.urlBancoDeDados = "jdbc:h2:~/materias;INIT=RUNSCRIPT FROM 'create.sql'";
        this.usuario = "sa";
        this.senha = "";
    }

    public Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(urlBancoDeDados, usuario, senha);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
