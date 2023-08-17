package dao.impl;

import dao.ConfiguracaoJdbc;
import dao.IDao;
import model.Avaliacao;
import model.Endereco;
import model.Hotel;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HotelH2Dao implements IDao<Hotel> {

    private static final Logger log = Logger.getLogger(HotelH2Dao.class);
    private ConfiguracaoJdbc configuracaoJdbc = new ConfiguracaoJdbc();

    private static final String SQL_BUSCAR_POR_ID = "SELECT * FROM Hotel WHERE id = ?";
    private static final String SQL_CRIACAO = """
            INSERT INTO Hotel(id, nome, avaliacao, rua, numero, cidade, estado) VALUES (?, ?, ?, ?, ?, ?, ?);
            	""";

    private static final String SQL_EXCLUIR = "DELETE FROM Hotel WHERE id = ?";

    private static final String SQL_BUSCAR_TODOS = "SELECT * FROM hotel";

    @Override
    public Hotel criar(Hotel hotel) {
        log.info("Criando nova rede de hotel");
        Connection connection = configuracaoJdbc.getConnection();

        try(PreparedStatement statement = connection.prepareStatement(SQL_CRIACAO)) {
            statement.setString(1, hotel.getId());
            statement.setString(2, hotel.getNomeDaFilial());
            statement.setString(3, hotel.getAvaliacao().name());
            statement.setString(4, hotel.getRua());
            statement.setInt(5, hotel.getNumero());
            statement.setString(6, hotel.getCidade());
            statement.setString(7, hotel.getEstado());
            statement.execute();
        } catch (Exception e) {
            log.error(e);
            return null;
        }
        log.info(hotel.getNomeDaFilial());
        return hotel;
    }

    @Override
    public Hotel buscarPorId(String id) {
        Connection connection = configuracaoJdbc.getConnection();
        log.info("Buscando rede por ID: " + id);

        try(PreparedStatement statement = connection.prepareStatement(SQL_BUSCAR_POR_ID)) {
            statement.setString(1, id);

            log.info("Executando busca por id");
            ResultSet resultSet = statement.executeQuery();
            Hotel hotel = null;

            log.info("Lendo o resultado encontrado");
            while (resultSet.next()) {
                Avaliacao avaliacao;
                hotel = new Hotel(resultSet.getString(1),
                    resultSet.getString(2),
                    Avaliacao.valueOf(resultSet.getString(3)),
                    resultSet.getString(4),
                    resultSet.getInt(5),
                    resultSet.getString(6),
                    resultSet.getString(7));
            }
            log.info(hotel);
            return hotel;
        } catch (Exception e) {
            log.error(e);
            return null;
        }


    }

    @Override
    public void excluir(String id) {
        log.info("Excluindo Hotel por ID:" + id);
        Connection connection = configuracaoJdbc.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_EXCLUIR)) {
            preparedStatement.setString(1, id);

            log.info("Executando exclusão de hotel por ID");
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Override
    public List<Hotel> buscatTodos() {
        log.info("Buscando todas as redes de hoteis");
        Connection connection = configuracaoJdbc.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_BUSCAR_TODOS)) {
            List<Hotel> listaDeHoteis = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            Hotel hotel = null;
            while (resultSet.next()) {
                Avaliacao avaliacao;
                hotel = new Hotel(resultSet.getString(1),
                        resultSet.getString(2),
                        Avaliacao.valueOf(resultSet.getString(3)),
                        resultSet.getString(4),
                        resultSet.getInt(5),
                        resultSet.getString(6),
                        resultSet.getString(7));
                        listaDeHoteis.add(hotel);
            }
            preparedStatement.close();
            log.info("[HOTEIS ENCONTRADOS]:" + listaDeHoteis);
            return listaDeHoteis;
        } catch (Exception e) {
            log.error(e);
        }
        return null;
    }
}
