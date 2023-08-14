package dao;

import java.util.List;
import java.util.Optional;

public interface IDao<ENTIDADE> {

    ENTIDADE criar(ENTIDADE entidade);

    ENTIDADE buscarPorId(String id);

    void excluir(String id);

    List<ENTIDADE> buscatTodos();

}
