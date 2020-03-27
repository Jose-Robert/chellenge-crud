package br.com.chellenge.crud.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.com.chellenge.crud.model.NovoUsuario;
import br.com.chellenge.crud.model.Usuario;


public interface UsuarioService extends UserDetailsService {

	Usuario findByEmail(String email);

    Usuario save(NovoUsuario novoUsuario);
    
    Usuario update(Usuario usuario);
	
	void delete(Long id);
	
	List<Usuario> list();
	
	Usuario listById(Long id);
}