package br.com.compasso.cooperativismo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compasso.cooperativismo.model.Pauta;
import br.com.compasso.cooperativismo.repository.PautaRepository;
import br.com.compasso.cooperativismo.service.IPautaService;

@Service
public class PautaService implements IPautaService{

	@Autowired
	private PautaRepository pautaRepository;
	
	@Override
	public Pauta savePauta(Pauta pauta) {
		return pautaRepository.save(pauta);
	}

}
