package br.com.hemocentro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.hemocentro.model.Bolsa;
import br.com.hemocentro.model.TipoSanguineo;

public interface IBolsaRepository extends JpaRepository<Bolsa, Long> {
	
	@Query("select b from Bolsa b order by b.codigo")
	List<Bolsa> orderByCodigo();
	
	@Query("select count(b) from Bolsa b where b.setor = 2 group by tipoSanguineo order by tipoSanguineo")
	List<Bolsa> countEstoqueBolsas();
	
	Long countByTipoSanguineo(TipoSanguineo tipoSanguineo);
	
	@Query("select count(b) from Bolsa b where b.setor = 2")
	Long countByBolsa();
	
}
