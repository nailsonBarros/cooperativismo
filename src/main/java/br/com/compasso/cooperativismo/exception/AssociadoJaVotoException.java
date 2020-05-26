package br.com.compasso.cooperativismo.exception;

public class AssociadoJaVotoException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public AssociadoJaVotoException (String exception) {
		super(exception);
	}

}
