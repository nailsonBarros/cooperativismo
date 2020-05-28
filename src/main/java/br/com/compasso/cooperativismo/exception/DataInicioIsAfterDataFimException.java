package br.com.compasso.cooperativismo.exception;

public class DataInicioIsAfterDataFimException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DataInicioIsAfterDataFimException(String execption) {
		super(execption);
	}

}
