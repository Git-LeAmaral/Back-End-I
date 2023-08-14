package dao;

import java.util.Optional;

public interface IDao<E, I> {

    E criar(E entidade);

    Optional<E> buscarPorId(I id);

    void excluir(I id);

    E atualizar(I id, E entidade);

}
