package br.com.temjobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.temjobs.domain.Oportunidade;

@Repository
public interface OportunidadeRepository extends JpaRepository<Oportunidade, Long> {

}
