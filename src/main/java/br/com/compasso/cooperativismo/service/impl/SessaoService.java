package br.com.compasso.cooperativismo.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compasso.cooperativismo.exception.DataInicioIsAfterDataFimException;
import br.com.compasso.cooperativismo.exception.PautaNotFoundException;
import br.com.compasso.cooperativismo.model.Pauta;
import br.com.compasso.cooperativismo.model.Sessao;
import br.com.compasso.cooperativismo.repository.PautaRepository;
import br.com.compasso.cooperativismo.repository.SessaoRepository;
import br.com.compasso.cooperativismo.service.ISessaoService;
import br.com.compasso.cooperativismo.util.Constants;

@Service
public class SessaoService implements ISessaoService{
	
	@Autowired
	private SessaoRepository sessaoRepository;
	
	@Autowired
	private PautaRepository pautaRepository;
	
	@Override
	public Sessao saveSessao(Sessao sessao) throws Exception {
		
		LocalDateTime dataAtual = LocalDateTime.now();                                 

		if(sessao.getDataInicio() == null) {
			sessao.setDataInicio(dataAtual);
		}else if(sessao.getDataFim() == null){
			dataAtual = sessao.getDataInicio();
		}
		
		if(sessao.getDataFim() == null) {
			sessao.setDataFim(dataAtual.plusMinutes(1L));
		}
		
		if(sessao.getDataInicio().isAfter(sessao.getDataFim())) {
			throw new DataInicioIsAfterDataFimException(Constants.DATA_INICIO_IS_AFTER_DATA_FIM);
		}
		
		
		if(StringUtils.isNotEmpty(sessao.getPauta().getId().toString())) {
			Optional<Pauta> opitinalPauta = pautaRepository.findById(sessao.getPauta().getId());
			if(opitinalPauta.isPresent()) {
				sessao.setPauta(opitinalPauta.get());
				return sessaoRepository.save(sessao);
			}
		}
		
		throw new PautaNotFoundException(Constants.PAUTA_NOT_FOUND);
		
	}

}
