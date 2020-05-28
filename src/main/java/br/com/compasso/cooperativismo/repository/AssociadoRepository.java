package br.com.compasso.cooperativismo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.compasso.cooperativismo.model.Associado;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Long> {

	Optional<Associado> findByCpf(String cpf);

}
