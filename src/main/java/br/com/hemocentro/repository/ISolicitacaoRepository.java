package br.com.hemocentro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hemocentro.model.Solicitacao;

public interface ISolicitacaoRepository extends JpaRepository<Solicitacao, Long> {
	
//	@Query("select s from Setor s order by s.nome")
//	List<Solicitacao> orderByNome();
		
}
