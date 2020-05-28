package br.com.compasso.cooperativismo.controller.dto;

import br.com.compasso.cooperativismo.model.Sessao;
import lombok.Data;

@Data
public class ResultadoVotacaoDTO {
	
	private String statusVotacao;
	private Long totalVotos;
	private Long votosSim;
	private Long votosNao;
	private Sessao sessao;


}
