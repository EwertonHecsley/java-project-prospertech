package prospertech.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import prospertech.desafio.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {
    
}
