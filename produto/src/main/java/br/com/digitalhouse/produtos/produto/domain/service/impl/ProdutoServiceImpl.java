package br.com.digitalhouse.produtos.produto.domain.service.impl;

import br.com.digitalhouse.produtos.produto.dao.ProdutoRepository;
import br.com.digitalhouse.produtos.produto.domain.entity.Produto;
import br.com.digitalhouse.produtos.produto.domain.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Produto criarProduto(Produto produto) {

        return produtoRepository.save(produto);
    }

    @Override
    public Optional<Produto> buscarPorId(Integer id) {

        return produtoRepository.findById(id);
    }

    @Override
    public List<Produto> buscarPorTodos() {

        return produtoRepository.findAll();
    }

    @Override
    public void excluir(Integer id) {
        produtoRepository.deleteById(id);
    }
}
