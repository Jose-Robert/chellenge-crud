package br.com.chellenge.crud.exception;

public class ClienteNuloOuInexistenteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ClienteNuloOuInexistenteException(String msg) {
		super(msg);
	}
	
}
