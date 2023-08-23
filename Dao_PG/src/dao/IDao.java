package dao;

import java.util.List;

public interface IDao<Generic> {

    public Generic salvar(Generic generic);
    public List<Generic> buscarTodos();
}
