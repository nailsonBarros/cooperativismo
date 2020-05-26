package br.com.compasso.cooperativismo.exception;

public class PautaNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PautaNotFoundException(String exception) {
		super(exception);
	}

}
