package br.com.compasso.cooperativismo.controller.dto;

import javax.validation.constraints.NotNull;

import br.com.compasso.cooperativismo.enums.ValorType;
import br.com.compasso.cooperativismo.util.EnumValidation;
import lombok.Data;

@Data
public class VotoDTO {
	
	@NotNull
	private AssociadoCpfDTO associado;
	
	@NotNull
	private SessaoIdDTO sessao;
	
	@NotNull
	@EnumValidation(enumClass = ValorType.class, message="Expected values: Sim, Não.")
	private String valor;

}
