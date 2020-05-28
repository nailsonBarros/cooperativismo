package br.com.compasso.cooperativismo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.compasso.cooperativismo.model.Voto;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long>{
	
	Optional<Voto> findBySessaoIdAndAssociadoId (Long sessaoId,Long associadoId);
	
	Long countBySessaoIdAndValor (Long sessaoId, String valor);

}
