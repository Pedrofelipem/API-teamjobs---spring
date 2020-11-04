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

import br.com.temjobs.domain.Empresa;
import br.com.temjobs.service.EmpresaService;

@RestController
@RequestMapping("/empresas")
public class EmpresaResource {
	@Autowired
	private EmpresaService empresaService;
	
	@GetMapping
	public List<Empresa> listar() {
		return this.empresaService.listar();
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Empresa> pesquisarPorId(@PathVariable("id") Long id) {
		return this.empresaService.pesquisarPorId(id)
				.map(empresa -> ResponseEntity.ok(empresa))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Empresa> salvar(@Validated @RequestBody Empresa empresa) {
		Empresa salvarEmpresa = this.empresaService.salvar(empresa);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
				.buildAndExpand(salvarEmpresa.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping
	public Empresa atualizar(@Validated @RequestBody Empresa empresa) {
		return this.empresaService.atualizar(empresa);
	}
	
	@DeleteMapping
	public void remover(@RequestBody Empresa empresa) {
		this.empresaService.remover(empresa);
	}
	
	@DeleteMapping(value = "{id}")
	public void removerPorId(@PathVariable("id") Long id) {
		this.empresaService.removerPorId(id);
	}
}
