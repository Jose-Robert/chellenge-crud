package br.com.chellenge.crud.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.chellenge.crud.dto.UsuarioLoginDTO;
import br.com.chellenge.crud.model.Usuario;
import br.com.chellenge.crud.service.UsuarioService;

@RestController
@RequestMapping(value = "usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> login(@RequestBody UsuarioLoginDTO usuarioDTO) {
		Usuario logar = usuarioService.login(usuarioDTO.getEmail(), usuarioDTO.getSenha());
		return ResponseEntity.ok(logar);
	}

}
