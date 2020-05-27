package br.com.compasso.cooperativismo.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compasso.cooperativismo.controller.dto.ResultadoVotacaoDTO;
import br.com.compasso.cooperativismo.exception.PautaNotFoundException;
import br.com.compasso.cooperativismo.exception.SessaoNotFoundException;
import br.com.compasso.cooperativismo.model.Pauta;
import br.com.compasso.cooperativismo.model.Sessao;
import br.com.compasso.cooperativismo.repository.PautaRepository;
import br.com.compasso.cooperativismo.repository.SessaoRepository;
import br.com.compasso.cooperativismo.repository.VotoRepository;
import br.com.compasso.cooperativismo.service.IPautaService;
import br.com.compasso.cooperativismo.util.Constants;

@Service
public class PautaService implements IPautaService{

	@Autowired
	private PautaRepository pautaRepository;
	
	@Autowired 
	private VotoRepository votoRepository;
	
	@Autowired 
	private SessaoRepository sessaoRepository;
	
	@Override
	public Pauta savePauta(Pauta pauta) {
		return pautaRepository.save(pauta);
	}

	public ResultadoVotacaoDTO resultadoVotacao(Long pautaId) {
		ResultadoVotacaoDTO resultadoVotacao = new ResultadoVotacaoDTO();
		
		Optional<Sessao> optionalSessao = sessaoRepository.findByPautaId(pautaId);
		
		if(optionalSessao.isPresent()) {
			resultadoVotacao.setSessao(optionalSessao.get());
		}else {
			throw new SessaoNotFoundException(Constants.SESSAO_NOT_FOUND);
		}
		
		if(LocalDateTime.now().isAfter(resultadoVotacao.getSessao().getDataFim())) {
			resultadoVotacao.setStatusVotacao(Constants.RESULTADO_FINAL);
		}else if(LocalDateTime.now().isBefore(resultadoVotacao.getSessao().getDataInicio())){
			resultadoVotacao.setStatusVotacao(Constants.SESSAO_NAO_INICIADA);
		}else {
			resultadoVotacao.setStatusVotacao(Constants.RESULTADO_PARCIAL);
		}
		
		resultadoVotacao.setVotosSim(
				votoRepository.countBySessaoIdAndValor(resultadoVotacao.getSessao().getId(), Constants.SIM));
		resultadoVotacao.setVotosNao(
				votoRepository.countBySessaoIdAndValor(resultadoVotacao.getSessao().getId(), Constants.NAO));
		
		resultadoVotacao.setTotalVotos(resultadoVotacao.getVotosSim()+resultadoVotacao.getVotosNao());
		
		
		return resultadoVotacao;
	}

}
