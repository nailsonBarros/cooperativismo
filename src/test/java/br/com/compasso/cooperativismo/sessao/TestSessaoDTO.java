package br.com.compasso.cooperativismo.sessao;

import javax.validation.constraints.NotNull;

import br.com.compasso.cooperativismo.controller.dto.PautaIdDTO;
import lombok.Data;

@Data
public class TestSessaoDTO {
	
	private String dataInicio;
	
	private String dataFim;
	
	@NotNull
	private PautaIdDTO pauta;

}
