package br.com.compasso.cooperativismo.controller.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SessaoIdDTO {
	
	@NotNull
	@Min(1)
	private Long id;

}
