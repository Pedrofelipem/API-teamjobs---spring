package br.com.temjobs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Habilidade {
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "habilidade_id")
	private Long id;
	
	@NotEmpty(message = "O nome da habilidade é obrigatório!")
	private String nome;
	
	@NotEmpty(message = "A descrição da habilidade é obrigatória!")
	private String descricao;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
