package br.com.temjobs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.temjobs.domain.Habilidade;

@Repository
public interface HabilidadeRepository extends JpaRepository<Habilidade, Long> {

}
