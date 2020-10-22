package br.com.prog3.trabalhofinalpc3.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prog3.trabalhofinalpc3.domain.Categoria;
import br.com.prog3.trabalhofinalpc3.dto.CategoriaDTO;

import br.com.prog3.trabalhofinalpc3.repository.CategoriaRepository;

@Service

public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria save(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	public List<CategoriaDTO> findAll() {
		return categoriaRepository.findAll().stream().map(categoria -> new CategoriaDTO(categoria)).collect(Collectors.toList());
	}

	public Optional<Categoria> findById(Long id) {
		return categoriaRepository.findById(id);
	}

	public Categoria update(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	public void deleteById(Long id) {
		categoriaRepository.deleteById(id);
	}

	
	}


