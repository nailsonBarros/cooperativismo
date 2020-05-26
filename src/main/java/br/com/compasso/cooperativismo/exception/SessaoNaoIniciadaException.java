package br.com.compasso.cooperativismo.exception;

public class SessaoNaoIniciadaException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public SessaoNaoIniciadaException (String exception) {
		super(exception);
	}

}
