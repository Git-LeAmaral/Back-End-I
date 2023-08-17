package br.com.digitalhouse.service.impl;

import br.com.digitalhouse.dao.ConfiguracaoJdbc;
import br.com.digitalhouse.dao.IDao;
import br.com.digitalhouse.model.Dentista;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class DentistaH2Dao implements IDao<Dentista> {
    private static final Logger log = Logger.getLogger(DentistaH2Dao.class);
    private final ConfiguracaoJdbc configuracaoJdbc = new ConfiguracaoJdbc();
    private static final String SQL_CRIACAO_DENTISTA = """
            INSERT INTO Dentista(NOME, CRO, DATA_NASCIMENTO, ESPECIALIDADE) VALUES(?, ?, ?, ?);
            """;
    @Override
    public Dentista criar(Dentista entidade) {
        log.info("[dentista_h2]: resgatando conexão para persistir os dados");
        Connection connection = configuracaoJdbc.getConnection();

        try (PreparedStatement statement = connection
                .prepareStatement(SQL_CRIACAO_DENTISTA, Statement.RETURN_GENERATED_KEYS)) {
            log.info("[dentista_h2]: criando prepared statement que retorna id");
            statement.setString(1, entidade.getNome()); //Passando as informações da Classe Dentista para o statement
            statement.setString(2, entidade.getCro());
            statement.setDate(3, entidade.getDataNascimentoDate());
            statement.setString(4, entidade.getEspecialidade().name());
            log.info("[dentista_h2]: executando script no banco de dados");
            statement.execute();
            log.info("[dentista_h2]: buscando id retornado da criação do dentista");
            ResultSet resultado = statement.getGeneratedKeys();
            while (resultado.next()) {
                entidade.setId(resultado.getInt(1));
            }
            return entidade;
        } catch (Exception e) {
            log.error("Alguma coisa deu errado!");
            return null;
        }
    }

    @Override
    public Dentista buscarPorId(Integer id) {
        return null;
    }

    @Override
    public List<Dentista> buscarTodos() {
        return null;
    }

    @Override
    public Dentista atualizar(Dentista dentista) {
        return null;
    }

    @Override
    public void excluir(Integer id) {

    }
}
