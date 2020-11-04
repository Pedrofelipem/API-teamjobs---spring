package br.com.temjobs.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Pessoa {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "pessoa_id")
	private Long id;
	
	@NotEmpty(message = "O nome da pessoa é obrigatório!")
	private String nome;
	
	@Column(unique = true)
	@Email(message = "Informe um email valido")
	@NotEmpty(message = "O email da pessoa é obrigatório!")
	private String email;
	
	@NotEmpty(message = "A data de nascimento da pessoa é obrigatório!")
	private String dataNascimento;
	
	@NotEmpty(message = "O sexo da pessoa é obrigatório!")
	private String sexo;
	
	@ManyToMany
	@JoinTable(
		name = "pessoa_habilidade",
		joinColumns = @JoinColumn(name = "pessoa_id"),
		inverseJoinColumns = @JoinColumn(name = "habilidade_id")
	)
	
	@NotNull(message = "A lista de habilidades não pode ser nula!")
	@NotEmpty(message = "Informe as habilidade da pessoa")
	private List<Habilidade> habilidades;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public List<Habilidade> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(List<Habilidade> habilidades) {
		this.habilidades = habilidades;
	}
}
