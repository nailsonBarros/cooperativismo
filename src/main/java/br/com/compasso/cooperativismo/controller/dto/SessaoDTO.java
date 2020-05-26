package br.com.compasso.cooperativismo.controller.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import br.com.compasso.cooperativismo.model.Pauta;
import lombok.Data;

@Data
public class SessaoDTO {
	
	
	private LocalDateTime dataInicio;
	
	private LocalDateTime dataFim;
	
	@NotNull
	private PautaIdDTO pauta;

}
