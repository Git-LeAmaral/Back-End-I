package br.com.digitalhouse.dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;

public final class ConfiguracaoJdbc {
    private static final Logger log = Logger.getLogger(ConfiguracaoJdbc.class);
    private String driver;
    private String urlBancoDeDados;
    private String usuario;
    private String senha;
    private Connection connection;

    public ConfiguracaoJdbc() {
        this.driver = "org.h2.Driver";
        this.urlBancoDeDados = "jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'create.sql'";
        this.usuario = "sa";
        this.senha = "";
    }

    public Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(urlBancoDeDados, usuario, senha);
            } catch (Exception e) {
                log.error("VISHH!!! não consegui me comunicar com o banco de dados!!!", e);
            }
        }
        return connection;
    }
}

