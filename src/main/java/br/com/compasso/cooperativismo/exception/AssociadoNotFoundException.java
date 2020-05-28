package br.com.compasso.cooperativismo.exception;

public class AssociadoNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public AssociadoNotFoundException (String exception) {
		super(exception);
	}

}
