package br.com.prog3.trabalhofinalpc3.resources;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.prog3.trabalhofinalpc3.domain.Categoria;
import br.com.prog3.trabalhofinalpc3.dto.CategoriaDTO;
import br.com.prog3.trabalhofinalpc3.service.CategoriaService;

@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaResource {

	@Autowired
	private CategoriaService categoriaService;

	@PostMapping
	public Categoria save(@RequestBody Categoria categoria) {
		return categoriaService.save(categoria);
	}

	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		List<CategoriaDTO> categoria = categoriaService.findAll();
		if (categoria == null || categoria.isEmpty()) {
			return new ResponseEntity<List<CategoriaDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CategoriaDTO>>(categoria, HttpStatus.OK);
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<?> findById(@PathVariable Long id) {
		return categoriaService.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Categoria> update(@PathVariable("id") Long id, @RequestBody Categoria categoria) {
		return categoriaService.findById(id).map(record -> {
			
			record.setNome(categoria.getNome());
			record.setDesconto(categoria.getdesconto());
			Categoria updated = categoriaService.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return categoriaService.findById(id).map(record -> {
			categoriaService.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}}

	