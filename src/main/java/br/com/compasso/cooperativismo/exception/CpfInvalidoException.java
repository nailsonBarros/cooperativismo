package br.com.compasso.cooperativismo.exception;

public class CpfInvalidoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public CpfInvalidoException (String exception) {
		super(exception);
	}

}
