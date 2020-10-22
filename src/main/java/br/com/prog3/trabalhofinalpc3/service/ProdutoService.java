package br.com.prog3.trabalhofinalpc3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prog3.trabalhofinalpc3.domain.Produto;
import br.com.prog3.trabalhofinalpc3.repository.ProdutoRepository;

@Service

public class ProdutoService {
	
	@Autowired
	private ProdutoRepository ProdutoRepository;

	public Produto save(Produto produto) {
		return ProdutoRepository.save(produto);
	}

	public List<Produto> findAll() {
		return (List<Produto>) ProdutoRepository.findAll();
	}

	public Optional<Produto> findById(Long id) {
		return ProdutoRepository.findById(id);
	}

	public Produto update(Produto produto) {
		return ProdutoRepository.save(produto);
	}

	public void deleteById(Long id) {
		ProdutoRepository.deleteById(id);
	}
}



