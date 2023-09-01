package br.com.digitalhouse.produtos.produto.domain.service;

import br.com.digitalhouse.produtos.produto.domain.entity.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    Produto criarProduto(Produto produto);
    Optional<Produto> buscarPorId(Integer id);

    List<Produto> buscarPorTodos();

    void excluir(Integer id);
}
