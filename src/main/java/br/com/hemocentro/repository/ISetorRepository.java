package br.com.hemocentro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.hemocentro.model.Setor;

public interface ISetorRepository extends JpaRepository<Setor, Long> {
	
	@Query("select s from Setor s order by s.nome")
	List<Setor> orderByNome();
	
	List<Setor> findBySigla(String sigla);

}
