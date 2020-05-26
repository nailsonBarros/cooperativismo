package br.com.compasso.cooperativismo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compasso.cooperativismo.model.Associado;
import br.com.compasso.cooperativismo.repository.AssociadoRepository;
import br.com.compasso.cooperativismo.service.IAssociadoService;

@Service
public class AssociadoService implements IAssociadoService{

	
	@Autowired
	private AssociadoRepository associadoRepository;
	
	@Override
	public Associado saveAssociado(Associado associado) {
		return associadoRepository.save(associado);
	}

}
