package br.com.compasso.cooperativismo.controller.dto;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PautaDTO {
	
	@NotNull
	@NotEmpty
	private String nome;

}
