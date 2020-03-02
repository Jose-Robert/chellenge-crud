package br.com.chellenge.crud.service;

import java.util.List;

import br.com.chellenge.crud.model.Usuario;

public interface UsuarioService {

	Usuario cadastrar(Usuario user);
	
	Usuario editar(Usuario user);
	
	void remover(Integer id);
	
	List<Usuario> listar();
	
	Usuario findUserById(Integer id);

	Usuario login(String email, String senha);
	
}
