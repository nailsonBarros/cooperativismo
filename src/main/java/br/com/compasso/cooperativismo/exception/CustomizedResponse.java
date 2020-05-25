package br.com.compasso.cooperativismo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomizedResponse {
    private String mensagemErro;
    private String codigoStatus;

}
