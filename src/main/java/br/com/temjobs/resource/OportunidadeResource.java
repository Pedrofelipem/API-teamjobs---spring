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

import br.com.temjobs.domain.Oportunidade;
import br.com.temjobs.service.OportunidadeService;

@RestController
@RequestMapping("/oportunidades")
public class OportunidadeResource {
	@Autowired
	private OportunidadeService oportunidadeService;
	
	@GetMapping
	public List<Oportunidade> listar() {
		return this.oportunidadeService.listar();
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Oportunidade> pesquisarPorId(@PathVariable("id") Long id) {
		return this.oportunidadeService.pesquisarPorId(id)
				.map(oportunidade -> ResponseEntity.ok(oportunidade))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Oportunidade> salvar(@Validated @RequestBody Oportunidade oportunidade) {
		Oportunidade salvarOportunidade = this.oportunidadeService.salvar(oportunidade);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
				.buildAndExpand(salvarOportunidade.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping
	public Oportunidade atualizar(@Validated @RequestBody Oportunidade oportunidade) {
		return this.oportunidadeService.atualizar(oportunidade);
	}
	
	@DeleteMapping
	public void remover(@RequestBody Oportunidade oportunidade) {
		this.oportunidadeService.remover(oportunidade);
	}
	
	@DeleteMapping(value = "{id}")
	public void removerPorId(@PathVariable("id") Long id) {
		this.oportunidadeService.removerPorId(id);
	}
}
