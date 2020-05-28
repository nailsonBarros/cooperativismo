package br.com.compasso.cooperativismo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.compasso.cooperativismo.model.Sessao;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Long>{

	Optional<Sessao> findByPautaId(Long pautaId);

}
