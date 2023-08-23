package br.com.digitalhouse.veiculos.dao.impl;

import br.com.digitalhouse.veiculos.dao.ConfiguracaoJdbc;
import br.com.digitalhouse.veiculos.dao.IDao;
import br.com.digitalhouse.veiculos.model.MarcaEnum;
import br.com.digitalhouse.veiculos.model.Veiculo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class VeiculoH2Dao implements IDao<Veiculo> {

    private static final String SQL_CRIACAO_VEICULO = """
            INSERT INTO Veiculo(marca, nome, cor, placa) VALUES(?, ?, ?, ?);
            """;

    private static final String SQL_BUSCA_POR_ID = """
            SELECT v.id, v.marca, v.nome, v.cor, v.placa
            FROM Veiculo v WHERE v.id = ?
            """;

    private static final String SQL_BUSCAR_TODOS = """
            SELECT v.id, v.marca, v.nome, v.cor, v.placa FROM Veiculo v
            """;

    private static final String SQL_ATUALIZAR_VEICULO = """
            UPDATE Veiculo SET marca = ?, nome = ?, cor = ?, placa = ? WHERE id = ?
            """;

    private static final String SQL_ECLUIR_VEICULO_POR_ID = """
            DELETE FROM Veiculo WHERE id = ?
            """;

    private final ConfiguracaoJdbc configuracaoJdbc = new ConfiguracaoJdbc();

    @Override
    public Veiculo criar(Veiculo entidade) {

        log.info("[VEICULO_H2]: Resgatando conexão para persistir os dados!");
        Connection connection = configuracaoJdbc.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(SQL_CRIACAO_VEICULO, Statement.RETURN_GENERATED_KEYS)) {
            log.info("[VEICULO_H2]: Configurando persistencia que retorna id");
            log.info(entidade.toString());
            statement.setString(1, entidade.getMarca().name());
            statement.setString(2, entidade.getNome());
            statement.setString(3, entidade.getCor());
            statement.setInt(4, entidade.getPlaca());
            log.info("[VEICULO_H2]: Executando script de persistencia do veiculo: " + entidade);
            statement.execute();
            log.info("[VEICULO_H2]: Buscando id retornado da criação do veiculo");
            ResultSet resultado = statement.getGeneratedKeys();
            while (resultado.next()) {
                entidade.setId(resultado.getInt(1));
            }
            log.info("[VEICULO_H2]: id encontrado: " + entidade.getId());
            return entidade;
        } catch (Exception e) {
            log.error("HUUMM!!!, Alguma coisa deu errado!", e);
            return null;
        }
    }

    @Override
    public Optional<Veiculo> buscarPorId(Integer id) {
        log.info("[VEICULO_H2]: Buscando veiculo por ID" + id);
        Connection connection = configuracaoJdbc.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(SQL_BUSCA_POR_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            Veiculo veiculo = null;
            while (resultSet.next()) {
                veiculo = this.getVeiculoByResultSet(resultSet);
                log.info("Veiculo encontrado: " + veiculo);
            }
            return Optional.ofNullable(veiculo);
        } catch (Exception e) {
            log.error("Vish!!! Um erro inesperado aconteceu!", e);
            return Optional.empty();
        }
    }

    @Override
    public List<Veiculo> buscarTodos() {
        log.info("[VEICULO_H2]: Buscando todos os Veiculos salvos no banco de dados (h2)...");
        Connection connection = configuracaoJdbc.getConnection();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_BUSCAR_TODOS);

            List<Veiculo> veiculos = new ArrayList<>();
            while (resultSet.next()) {
                Veiculo veiculo = getVeiculoByResultSet(resultSet);
                log.info("Veiculo encontrado com identificação: " + veiculo.getId());
                veiculos.add(veiculo);
            }
            return veiculos;
        } catch (Exception e) {
            log.error("Vish!!! Um erro inesperado aconteceu!", e);
            return Collections.emptyList();
        }
    }

    @Override
    public Veiculo atualizar(Veiculo veiculo) {
        log.info("[VEICULO_H2]: Atualizando dados do Veiculo)...");
        Connection connection = configuracaoJdbc.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(SQL_ATUALIZAR_VEICULO)) {
            statement.setString(1, veiculo.getMarca().name());
            statement.setString(2, veiculo.getNome());
            statement.setString(3, veiculo.getCor());
            statement.setInt(4, veiculo.getPlaca());
            statement.setInt(5, veiculo.getId());
            log.info("[VEICULO_H2]: Executando atualização física");
            statement.executeUpdate();
            return veiculo;
        } catch (Exception e) {
            log.error("Vish!!! Um erro inesperado aconteceu!", e);
            return null;
        }
    }

    @Override
    public void excluir(Integer id) {
        Connection connection = configuracaoJdbc.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(SQL_ECLUIR_VEICULO_POR_ID)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            log.error("Vish!!! Um erro inesperado aconteceu!", e);
        }
    }

    private Veiculo getVeiculoByResultSet(ResultSet resultSet) throws SQLException {
        Veiculo veiculo;
        Integer id = resultSet.getInt(1);
        MarcaEnum marca = MarcaEnum.valueOf(resultSet.getString(2));
        String nome = resultSet.getString(3);
        String cor = resultSet.getString(4);
        Integer placa = resultSet.getInt(5);
        veiculo = new Veiculo(id, marca, nome, cor, placa);
        return veiculo;
    }
}
