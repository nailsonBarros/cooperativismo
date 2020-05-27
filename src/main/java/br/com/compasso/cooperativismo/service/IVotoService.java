package br.com.compasso.cooperativismo.service;

import br.com.compasso.cooperativismo.model.Voto;

public interface IVotoService {

	/**
	 * 
	 * @param voto
	 * @return Voto
	 */
	public Voto saveVoto(Voto voto);

	/**
	 * 
	 * @param cpf
	 */
	public void validaCpfAptoParaVotar(String cpf);

}
