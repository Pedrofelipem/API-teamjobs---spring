package br.com.temjobs.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Oportunidade {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "oportunidade_id")
	private Long id;
	
	@NotEmpty(message = "O título da oportunidade é obrigatório!")
	private String titulo;
	
	@NotEmpty(message = "A descrição da oportunidade é obrigatória!")
	private String descricao;
	
	@NotEmpty(message ="A data de início da oportunidade é obrigatória!")
	private String dataInicio;
	
	@NotEmpty(message ="A data de término da oportunidade é obrigatória!")
	private String dataTermino;
	
	@NotNull(message ="A empresa da oportunidade não pode ser nula!")
	@JsonIgnoreProperties("oportunidades")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="empresa_id")
	private Empresa empresa;
	
	@NotNull(message ="A lista de habilidades não pode ser nula!")
	@NotEmpty(message ="Informe as habilidades para a vaga!")
	@ManyToMany
	@JoinTable(
		name = "oportunidade_habilidade",
		joinColumns = @JoinColumn(name ="oportunidade_id"),
		inverseJoinColumns = @JoinColumn(name ="habilidade_id")
	)
	private List<Habilidade> habilidades;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Habilidade> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(List<Habilidade> habilidades) {
		this.habilidades = habilidades;
	}
}
