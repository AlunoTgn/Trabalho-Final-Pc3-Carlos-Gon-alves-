package br.com.prog3.trabalhofinalpc3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.prog3.trabalhofinalpc3.domain.Produto;

@Repository

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

}
