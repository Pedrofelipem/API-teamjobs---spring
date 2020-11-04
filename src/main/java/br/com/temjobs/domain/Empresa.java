package br.com.temjobs.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Empresa {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "empresa_id")
	private Long Id;
	
	@NotEmpty(message = "O nome da empresa é obrigatório!")
	private String nome;
	
	@Column(unique = true)
	@Email(message = "Informe um email valido")
	@NotEmpty(message = "O email da empresa é obrigatório!")
	private String email;
	
	@NotEmpty(message = "O site da empresa é obrigatório!")
	private String site;
	
	@JsonIgnoreProperties("empresa")
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
	private List<Oportunidade> oportunidades;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public List<Oportunidade> getOportunidades() {
		return oportunidades;
	}

	public void setOportunidades(List<Oportunidade> oportunidades) {
		this.oportunidades = oportunidades;
	}
}
