package br.com.temjobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.temjobs.domain.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
