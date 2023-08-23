package br.com.digitalhouse.veiculos.dao;

import java.util.List;
import java.util.Optional;

public interface IDao<Tipo> {

    Tipo criar(Tipo entidade);
    Optional<Tipo> buscarPorId(Integer id);
    List<Tipo> buscarTodos();
    Tipo atualizar(Tipo veiculo);
    void excluir(Integer id);
}
