package br.com.compasso.cooperativismo.exception;

public class SessaoNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public SessaoNotFoundException (String exception) {
		super(exception);
	}

}
