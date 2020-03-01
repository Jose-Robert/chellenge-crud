package br.com.chellenge.crud.exception;

public class ClienteIdInexistenteExcpetion extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ClienteIdInexistenteExcpetion(String msg) {
		super(msg);
	}
}
