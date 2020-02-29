package br.com.chellenge.crud.service;

import br.com.chellenge.crud.model.Usuario;

public interface UsuarioService {

	Usuario login(String email, String senha);
	
}
