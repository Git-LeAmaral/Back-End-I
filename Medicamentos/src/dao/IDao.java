package dao;

import model.Medicamento;

import java.util.List;

public interface IDao<E> {

    E buscarPorId(Integer id);
    E criar(E entidade);
    void excluir(Integer id);
    List<E> buscarTodos();


}
