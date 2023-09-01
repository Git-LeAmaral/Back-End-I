package br.com.digitalhouse.produtos.produto.dao;

import br.com.digitalhouse.produtos.produto.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
