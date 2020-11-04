package br.com.temjobs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.temjobs.domain.Pessoa;
import br.com.temjobs.repository.PessoaRepository;

@Service
public class PessoaService {
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa salvar(Pessoa pessoa) {
		return this.pessoaRepository.save(pessoa);
	}
	
	public Pessoa atualizar(Pessoa pessoa) {
		return this.pessoaRepository.save(pessoa);
	}
	
	public List<Pessoa> listar() {
		return this.pessoaRepository.findAll();
	}
	
	public Optional<Pessoa> pesqusarPorId(Long id) {
		return this.pessoaRepository.findById(id);
	}
	
	public void remover(Pessoa pessoa) {
		this.pessoaRepository.delete(pessoa);
	}
	
	public void removerPorId(Long id) {
		this.pessoaRepository.deleteById(id);
	}
}
