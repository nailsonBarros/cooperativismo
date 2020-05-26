package br.com.compasso.cooperativismo.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compasso.cooperativismo.exception.AssociadoJaVotoException;
import br.com.compasso.cooperativismo.exception.AssociadoNotFoundException;
import br.com.compasso.cooperativismo.exception.SessaoFechadaException;
import br.com.compasso.cooperativismo.exception.SessaoNaoIniciadaException;
import br.com.compasso.cooperativismo.exception.SessaoNotFoundException;
import br.com.compasso.cooperativismo.model.Associado;
import br.com.compasso.cooperativismo.model.Sessao;
import br.com.compasso.cooperativismo.model.Voto;
import br.com.compasso.cooperativismo.repository.AssociadoRepository;
import br.com.compasso.cooperativismo.repository.SessaoRepository;
import br.com.compasso.cooperativismo.repository.VotoRepository;
import br.com.compasso.cooperativismo.service.IVotoService;
import br.com.compasso.cooperativismo.util.Constants;

@Service
public class VotoService implements IVotoService {

	@Autowired
	private VotoRepository votoRepository;

	@Autowired
	private SessaoRepository sessaoRepository;
	
	@Autowired
	private AssociadoRepository associadoRepository;

	public Voto saveVoto(Voto voto) throws Exception {

		if (StringUtils.isNotEmpty(voto.getSessao().getId().toString())) {

			Optional<Sessao> optionalSessao = sessaoRepository.findById(voto.getSessao().getId());

			if (optionalSessao.isPresent()) {
				voto.setSessao(optionalSessao.get());
			}else {
				throw new SessaoNotFoundException(Constants.SESSAO_NOT_FOUND);
			}

		}
		
		if(StringUtils.isNotEmpty(voto.getAssociado().getCpf())) {
			
			Optional<Associado> optionalAssociado = associadoRepository.findByCpf(voto.getAssociado().getCpf());
			
			if (optionalAssociado.isPresent()) {
				voto.setAssociado(optionalAssociado.get());
			}else {
				throw new AssociadoNotFoundException(Constants.ASSOCIADO_NOT_FOUND);
			}
			
		}
		
		if(LocalDateTime.now().isAfter(voto.getSessao().getDataFim())) {
			throw new SessaoFechadaException(Constants.SESSAO_FECHADA);		
		}
		
		if(LocalDateTime.now().isBefore(voto.getSessao().getDataInicio())) {
			throw new SessaoNaoIniciadaException(Constants.SESSAO_NAO_INICIADA);
		}
		
		Optional<Voto> optionalVoto = votoRepository.findBySessaoIdAndAssociadoId(voto.getSessao().getId(), voto.getAssociado().getId());

		if(optionalVoto.isPresent()) {
 			throw new AssociadoJaVotoException(Constants.ASSOCIADO_JA_VOTO);
		}
		
		return votoRepository.save(voto);
	}

}
