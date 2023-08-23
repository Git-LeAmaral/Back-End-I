package dao.impl;

import dao.ConfiguracaoJDBC;
import dao.IDao;
import model.Materia;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MateriaDaoH2 implements IDao<Materia> {
    private static final Logger log = Logger.getLogger(MateriaDaoH2.class);
    private ConfiguracaoJDBC configuracaoJDBC;

    public MateriaDaoH2(ConfiguracaoJDBC configuracaoJDBC) {
        this.configuracaoJDBC = configuracaoJDBC;
    }


    @Override
    public Materia salvar(Materia materia) {
        Connection connection = configuracaoJDBC.getConnection();
        log.info("Criando conxão com Banco de dados");
        Statement statement = null;

        String query = String.format("INSERT INTO materias(nome) VALUES('%s')", materia.getNome());
        log.info("Inserindo dados no banco");

        try {
            statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();

            if (keys.next())
                materia.setId(keys.getInt(1));
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info(materia.getNome());
        return materia;
    }

    @Override
    public List<Materia> buscarTodos() {
        Connection connection = configuracaoJDBC.getConnection();
        log.info("Criando conexão com banco");
        Statement statement = null;
        String query = String.format("SELECT * FROM materias");
        List<Materia> materias = new ArrayList<>();
        log.info("Realizando busca de materias inseridas...");

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            log.info("Busca realizada com sucesso!");
            while (resultSet.next()) {
                materias.add(new Materia(resultSet.getInt("id"), resultSet.getString("nome")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info(materias);
        return materias;
    }
}
