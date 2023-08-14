package dao.impl;

import dao.ConfiguracaoJdbc;
import dao.IDao;
import model.Hotel;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class HotelH2Dao implements IDao<Hotel> {

    private static final Logger log = Logger.getLogger(HotelH2Dao.class);
    private ConfiguracaoJdbc configuracaoJdbc = new ConfiguracaoJdbc();

    private static final String SQL_BUSCAR_POR_ID = "SELECT * FROM Hotel WHERE id = ?";
    private static final String SQL_CRIACAO = """
            	INSERT INTO Hotel(nome, endereco, avaliacao) VALUES (?, ?, ?)
            	INSERT INTO Endereco(rua, nome, cidade, estado) VALUES (?, ?, ?, ?)
            	""";

    private static final String SQL_EXCLUIR = "DELETE FROM Hotel WHERE id = ?";

    private static final String SQL_BUSCAR_TODOS = "SELECT * FROM hotel";

    @Override
    public Hotel criar(Hotel hotel) {
        Connection connection = configuracaoJdbc.getConnection();

        try(PreparedStatement statement = connection.prepareStatement(SQL_CRIACAO)) {
            statement.setString(1, hotel.getNomeDaFilial());
            statement.setString(2, hotel.getEndereco().toString());
            statement.setString(3, hotel.getAvaliacao().name());
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hotel;
    }

    @Override
    public Hotel buscarPorId(String id) {
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
