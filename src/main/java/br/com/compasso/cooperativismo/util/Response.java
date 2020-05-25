package br.com.compasso.cooperativismo.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
	private String tipo;
	private String mensagem;

}
