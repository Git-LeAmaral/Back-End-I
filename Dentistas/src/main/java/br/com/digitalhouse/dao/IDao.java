package br.com.digitalhouse.dao;

import br.com.digitalhouse.model.Dentista;

import java.util.List;

public interface IDao<T> {
    Dentista criar(T entidade);

    Dentista buscarPorId(Integer id);

    List<T> buscarTodos();

    T  atualizar(T dentista);

    void excluir(Integer id);
}
