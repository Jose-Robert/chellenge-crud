package br.com.chellenge.crud.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.com.chellenge.crud.model.Usuario;
import br.com.chellenge.crud.model.NovoUsuario;


public interface UsuarioService extends UserDetailsService {

	Usuario findByEmail(String email);

    Usuario save(NovoUsuario novoUsuario);
}