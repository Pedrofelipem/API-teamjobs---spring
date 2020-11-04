package br.com.temjobs.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.temjobs.domain.Pessoa;
import br.com.temjobs.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public List<Pessoa> listar() {
		return this.pessoaService.listar();
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Pessoa> pesquisarPorId(@PathVariable("id") Long id) {
		return this.pessoaService.pesqusarPorId(id)
				.map(pessoa -> ResponseEntity.ok(pessoa))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> salvar(@Validated @RequestBody Pessoa pessoa) {
		Pessoa salvarPessoa = this.pessoaService.salvar(pessoa);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
				.buildAndExpand(salvarPessoa.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping
	public Pessoa atualizar(@Validated @RequestBody Pessoa pessoa) {
		return this.pessoaService.atualizar(pessoa);
	}
	
	@DeleteMapping
	public void remover(@RequestBody Pessoa pessoa) {
		this.pessoaService.remover(pessoa);
	}
	
	@DeleteMapping(value = "{id}")
	public void removerPorId(@PathVariable("id") Long id) {
		this.pessoaService.removerPorId(id);
	}
}
