package br.com.prog3.trabalhofinalpc3.dto;

import br.com.prog3.trabalhofinalpc3.domain.Categoria;

public class CategoriaDTO {

	private Long id;
	private String nome;
	private Double desconto;

	public CategoriaDTO(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
		this.desconto = categoria.getdesconto();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double desconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

}
