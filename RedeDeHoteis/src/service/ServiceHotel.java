package service;

import dao.IDao;
import model.Hotel;

import java.util.List;

public class ServiceHotel {

    private final IDao<Hotel> daoHotel;

    public ServiceHotel(IDao<Hotel> daoHotel) {
        this.daoHotel = daoHotel;
    }

    public Hotel criarHotel(Hotel hotel) {
        return daoHotel.criar(hotel);
    }

    public Hotel buscarId(String id) {
        return daoHotel.buscarPorId(id);
    }

    public void excluirHotel(String id) {
        daoHotel.buscarPorId(id);
    }

    public List<Hotel> buscarTodos() {
        return daoHotel.buscatTodos();
    }
}
