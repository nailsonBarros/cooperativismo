package br.com.compasso.cooperativismo.exception;

public class SessaoFechadaException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public SessaoFechadaException (String exception) {
		super(exception);
	}

}
