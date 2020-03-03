package br.com.chellenge.crud.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.chellenge.crud.model.Usuario;
import br.com.chellenge.crud.service.UsuarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@ApiOperation(value = "Cadastrar um novo usuario", 
			  notes = "Este metodo edita um cliente por {id}.")
	@ApiResponses({ 
		@ApiResponse(code = 400, message = "Requisição inválida."),
		@ApiResponse(code = 401, message = "Não autorizado."), 
		@ApiResponse(code = 403, message = "Não permitido."),
		@ApiResponse(code = 404, message = "Recurso não encontrado."),
		@ApiResponse(code = 500, message = "Erro interno do sistema") })
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> salvar(@Valid @RequestBody Usuario usuario) {
		Usuario user = usuarioService.cadastrar(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	
	@ApiOperation(value = "Editar um usuario", 
			  notes = "Este metodo atualiza um usuario por {id}.")
	@ApiResponses({ 
		@ApiResponse(code = 400, message = "Requisição inválida."),
		@ApiResponse(code = 401, message = "Não autorizado."), 
		@ApiResponse(code = 403, message = "Não permitido."),
		@ApiResponse(code = 404, message = "Recurso não encontrado."),
		@ApiResponse(code = 500, message = "Erro interno do sistema") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> editar(@PathVariable(name = "id") Integer id, @Valid @RequestBody Usuario usuario){
		usuario.setId(id);
		Usuario editarUsuario = usuarioService.editar(usuario);
		return ResponseEntity.ok(editarUsuario);
	}

	@ApiOperation(value = "Listar usuarios", 
			  notes = "Este metodo busca todos os usuarios cadastrados na base.")
	@ApiResponses({
		@ApiResponse(code = 400, message = "Requisição inválida."),
		@ApiResponse(code = 401, message = "Não autorizado."), 
		@ApiResponse(code = 403, message = "Não permitido."),
		@ApiResponse(code = 404, message = "Recurso não encontrado."),
		@ApiResponse(code = 500, message = "Erro interno do sistema") })
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> listar() {
		List<Usuario> listaUsuario = this.usuarioService.listar();
		return ResponseEntity.ok(listaUsuario);
	}

	@ApiOperation(value = "Excluir usuario", 
			  notes = "Este metodo exclui um usuario por {id}.")
	@ApiResponses({ 
		@ApiResponse(code = 400, message = "Requisição inválida."),
		@ApiResponse(code = 401, message = "Não autorizado."), 
		@ApiResponse(code = 403, message = "Não permitido."),
		@ApiResponse(code = 404, message = "Recurso não encontrado."),
		@ApiResponse(code = 500, message = "Erro interno do sistema") })
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> remover(@PathVariable(name = "id") Integer id) {
		this.usuarioService.remover(id);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Listar usuarios por {id}", 
			  notes = "Este metodo busca usuario por {id}.")
	@ApiResponses({ 
		@ApiResponse(code = 400, message = "Requisição inválida."),
		@ApiResponse(code = 401, message = "Não autorizado."), 
		@ApiResponse(code = 403, message = "Não permitido."),
		@ApiResponse(code = 404, message = "Recurso não encontrado."),
		@ApiResponse(code = 500, message = "Erro interno do sistema") })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> listarById(@PathVariable("id") Integer id) {
		Usuario usuario= this.usuarioService.findUserById(id);
		return ResponseEntity.ok(usuario);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<Usuario> login(@RequestBody Usuario user) {
		Usuario loginUsuario = usuarioService.login(user.getEmail(), user.getSenha());
		return ResponseEntity.ok(loginUsuario);
	}

}
