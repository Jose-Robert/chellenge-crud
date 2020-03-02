package br.com.chellenge.crud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.chellenge.crud.exception.UsuarioException;
import br.com.chellenge.crud.model.Usuario;
import br.com.chellenge.crud.repository.UsuarioRepository;
import br.com.chellenge.crud.service.UsuarioService;
import br.com.chellenge.crud.util.HashUtil;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@SuppressWarnings("static-access")
	@Override
	public Usuario cadastrar(Usuario usuario) {
		usuario.setSenha(new HashUtil().getSecureHash(""));
		Usuario savlarUser = usuarioRepository.saveAndFlush(usuario);
		return savlarUser;
	}

	@Override
	public Usuario editar(Usuario usuario) {
		Usuario editarUsuario = usuarioRepository.save(usuario);
		return editarUsuario;
	}

	@Override
	public void remover(Integer id) {
		try {
			Optional<Usuario> user = usuarioRepository.findById(id);
			this.usuarioRepository.delete(user.get());
		} catch (Exception e) {
			throw new UsuarioException("Não foi possivel excluir usuario!");
		}
	}

	@Override
	public List<Usuario> listar() {
		List<Usuario> listarUsuarios = this.usuarioRepository.findAll();
		return listarUsuarios;
	}

	@Override
	public Usuario findUserById(Integer id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		try {
			return usuario.get();
		} catch (Exception e) {

		}
		return usuario.orElseThrow(() -> new UsuarioException("Identificado " + id + " não encontrado para este Usuario!!"));
	}
	
	public Usuario login(String email, String password) {
		Optional<Usuario> usuario = usuarioRepository.login(email, password);
		if (!usuario.isPresent()) {
			throw new UsuarioException("O usuario não existe, por favor faça seu cadastro.");
		}
		return usuario.get();
	}

}
