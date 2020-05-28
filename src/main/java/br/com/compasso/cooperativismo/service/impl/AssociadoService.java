package br.com.compasso.cooperativismo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compasso.cooperativismo.exception.CpfInvalidoException;
import br.com.compasso.cooperativismo.feign.ValidaCpfFeignClient;
import br.com.compasso.cooperativismo.model.Associado;
import br.com.compasso.cooperativismo.repository.AssociadoRepository;
import br.com.compasso.cooperativismo.service.IAssociadoService;
import br.com.compasso.cooperativismo.util.Constants;

@Service
public class AssociadoService implements IAssociadoService{

	
	@Autowired
	private AssociadoRepository associadoRepository;
	
	@Autowired
	private ValidaCpfFeignClient validaCpfFeignClient;
	
	@Override
	public Associado saveAssociado(Associado associado) {
		
		try {
			
			validaCpfFeignClient.validaCpfDTO(associado.getCpf());
			
		} catch (Exception e) {
			
			throw new CpfInvalidoException(Constants.CPF_INVALIDO);
		}		
		
		return associadoRepository.save(associado);
	}

}
