package br.com.digitalhouse.produtos.produto.api;

import br.com.digitalhouse.produtos.produto.domain.entity.Produto;
import br.com.digitalhouse.produtos.produto.domain.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto) {
        return produtoService.criarProduto(produto);
    }

    @GetMapping("{id}")
    Produto buscarPorId(@PathVariable Integer id) {
        return  produtoService.buscarPorId(id).orElseThrow();
    }

    @GetMapping
    List<Produto> buscarPorTodos() {
        return produtoService.buscarPorTodos();
    }

    @DeleteMapping("{id}")
    void excluir(@PathVariable Integer id) {
        produtoService.excluir(id);
    }
}
