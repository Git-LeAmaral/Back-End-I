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
import java.util.List;

public class HotelH2Dao implements IDao<Hotel> {

    private static final Logger log = Logger.getLogger(HotelH2Dao.class);
    private ConfiguracaoJdbc configuracaoJdbc = new ConfiguracaoJdbc();

    private static final String SQL_BUSCAR_POR_ID = "SELECT * FROM Hotel WHERE id = ?";
    private static final String SQL_CRIACAO = """
            	INSERT INTO Hotel(id, nome, endereco, avaliacao) VALUES (?, ?, ?, ?);
            	INSERT INTO Endereco(rua, numero, cidade, estado) VALUES (?, ?, ?, ?)
            	""";

    private static final String SQL_EXCLUIR = "DELETE FROM Hotel WHERE id = ?";

    private static final String SQL_BUSCAR_TODOS = "SELECT * FROM hotel";

    @Override
    public Hotel criar(Hotel hotel) {
        log.info("Criando nova rede de hotel");
        Connection connection = configuracaoJdbc.getConnection();

        try(PreparedStatement statement = connection.prepareStatement(SQL_CRIACAO)) {
            statement.setString(1, hotel.getNomeDaFilial());
            statement.setString(2, hotel.getEndereco().toString());
            statement.setString(3, hotel.getAvaliacao().name());
            statement.setString(4, hotel.getAvaliacao().name());
            statement.setString(5, hotel.getEndereco().getRua());
            statement.setInt(6, hotel.getEndereco().getNumero());
            statement.setString(7, hotel.getEndereco().getCidade());
            statement.setString(8, hotel.getEndereco().getEstado());
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info(hotel);
        return hotel;
    }

    @Override
    public Hotel buscarPorId(String id) {
        Connection connection = configuracaoJdbc.getConnection();
        log.info("Buscando rede por ID: " + id);

        try(PreparedStatement statement = connection.prepareStatement(SQL_BUSCAR_POR_ID)) {
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            Hotel hotel = null;

            while (resultSet.next()) {
                String hotelId = resultSet.getString(1);
                String nomeHotel = resultSet.getString(2);

                String rua = resultSet.getString(3);
                Integer numero = resultSet.getInt(4);
                String cidade = resultSet.getString(5);
                String estado = resultSet.getString(6);
                //String avaliacaoRede = resultSet.getString(7);
                Avaliacao classificacao = Avaliacao.valueOf(resultSet.getString(8));
                Endereco endereco = new Endereco(rua, numero, cidade, estado);
                hotel = new Hotel(hotelId, nomeHotel, endereco, classificacao);

                statement.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @Override
    public void excluir(String id) {

    }

    @Override
    public List<Hotel> buscatTodos() {
        return null;
    }
}
