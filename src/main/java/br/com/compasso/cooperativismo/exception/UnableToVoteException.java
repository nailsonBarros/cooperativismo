package br.com.compasso.cooperativismo.exception;

public class UnableToVoteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UnableToVoteException(String exception) {
		super(exception);
	}

}
