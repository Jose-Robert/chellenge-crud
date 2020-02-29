package br.com.chellenge.crud.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.chellenge.crud.model.Usuario;
import br.com.chellenge.crud.repository.UsuarioRepository;
import br.com.chellenge.crud.service.UsuarioService;
import br.com.chellenge.crud.util.HashUtil;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario login(String email, String senha) {
		senha = HashUtil.getSecureHash(senha);

		Optional<Usuario> result = usuarioRepository.login(email, senha);
		return result.get();
	}

}
