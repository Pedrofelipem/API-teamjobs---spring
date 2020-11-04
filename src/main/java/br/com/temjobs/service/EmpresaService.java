package br.com.temjobs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.temjobs.domain.Empresa;
import br.com.temjobs.domain.Oportunidade;
import br.com.temjobs.repository.EmpresaRepository;
import br.com.temjobs.repository.OportunidadeRepository;

@Service
public class EmpresaService {
	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired
	private OportunidadeRepository oportunidadeRepository;
	
	public Empresa salvar(Empresa empresa) {
		if(empresa.getOportunidades().size() > 0) {
			List<Oportunidade> oportunidades = new ArrayList<>();
			
			for(Oportunidade oportunidade:empresa.getOportunidades()) {
				if(oportunidade.getId() != null) {
					Optional<Oportunidade> oportunidadeGerenciada = this.oportunidadeRepository.findById(oportunidade.getId());
					oportunidadeGerenciada.get().setEmpresa(empresa);
					oportunidades.add(oportunidadeGerenciada.get());
				} else {
					empresa.setOportunidades(oportunidades);
					oportunidade.setEmpresa(empresa);
					oportunidades.add(oportunidade);
				}
			}
			empresa.setOportunidades(oportunidades);
		}
		
		return this.empresaRepository.save(empresa);
	}
	
	public Empresa atualizar(Empresa empresa) {
		return this.empresaRepository.save(empresa);
	}
	
	public List<Empresa> listar() {
		return this.empresaRepository.findAll();
	}
	
	public Optional<Empresa> pesquisarPorId(Long id) {
		return this.empresaRepository.findById(id);
	}
	
	public void remover(Empresa empresa) {
		this.empresaRepository.delete(empresa);
	}
	
	public void removerPorId(Long id) {
		this.empresaRepository.deleteById(id);
	}
}
