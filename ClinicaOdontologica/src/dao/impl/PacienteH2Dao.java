package dao.impl;

import dao.ConfiguracaoJdbc;
import dao.IDao;
import model.Paciente;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.Instant;
import java.util.Optional;

public class PacienteH2Dao implements IDao<Paciente, Integer> {
    private ConfiguracaoJdbc configuracaoJdbc = new ConfiguracaoJdbc();

    private static final String SQL_BUSCA_POR_ID = "SELECT * FROM Paciente WHERE id = ?";
    private static final String SQL_CRIACAO = """
            INSERT INTO Paciente(nome, sobrenome, rg, data_cadastro) VALUES(?, ?, ?, ?);
            INSERT INTO Endereco(rua, numero, cidade, bairro) VALUES(?, ?, ?, ?)
            """;

    private static final String SQL_ATUALIZACAO = """
            UPADTE Paciente SET nome = ?, sobrenome = ?, rg = ?, data_cadastro = ? WHERE id = ?;
            UPADTE Endreco SET rua = ?, numero = ?, cidade = ?, bairro = ? WHERE id = ?;
            """;

    private static final String SQL_EXCLUSAO = "DELETE FROM Paciente WHERE id = ?";


    @Override
    public Paciente criar(Paciente paciente) {
        Connection connection = configuracaoJdbc.getConnection();

        try(PreparedStatement statement = connection.prepareStatement(SQL_CRIACAO)) {
            statement.setString(1, paciente.getNome());
            statement.setString(2, paciente.getSobrenome());
            statement.setString(3, paciente.getRg());
            statement.setDate(4, new Date(Instant.now().toEpochMilli()));
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return paciente;
    }

    @Override
    public Optional<Paciente> buscarPorId(Integer id) {
        return Optional.empty();
    }

    @Override
    public void excluir(Integer id) {

    }

    @Override
    public Paciente atualizar(Integer id, Paciente entidade) {
        return null;
    }
}
