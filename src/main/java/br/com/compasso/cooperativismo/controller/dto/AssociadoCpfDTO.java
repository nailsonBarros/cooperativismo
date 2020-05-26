package br.com.compasso.cooperativismo.controller.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class AssociadoCpfDTO {

	@NotNull
	@Length(min = 11,max = 11)
	private String cpf;
}
