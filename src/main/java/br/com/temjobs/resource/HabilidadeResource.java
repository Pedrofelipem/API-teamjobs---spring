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

import br.com.temjobs.domain.Habilidade;
import br.com.temjobs.service.HabilidadeService;

@RestController
@RequestMapping("/habilidades")
public class HabilidadeResource {
	@Autowired
	private HabilidadeService habilidadeService;
	
	@GetMapping
	public List<Habilidade> listar() {
		return this.habilidadeService.listar();
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Habilidade> pesquisarPorId(@PathVariable("id") Long id) {
		return this.habilidadeService.pesquisarPorId(id)
				.map(habilidade -> ResponseEntity.ok(habilidade))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Habilidade> salvar(@Validated @RequestBody Habilidade habilidade) {
		Habilidade salvarHabilidade = this.habilidadeService.salvar(habilidade);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(salvarHabilidade.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping
	public Habilidade atualizar(@Validated @RequestBody Habilidade habilidade) {
		return this.habilidadeService.atualizar(habilidade);
	}
	
	@DeleteMapping
	public void remover(@RequestBody Habilidade habilidade) {
		this.habilidadeService.remover(habilidade);
	}
	
	@DeleteMapping(value = "{id}")
	public void removerPorId(@PathVariable("id") Long id) {
		this.habilidadeService.removerPorId(id);
	}
}
