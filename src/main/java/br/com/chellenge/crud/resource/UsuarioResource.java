package br.com.chellenge.crud.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.chellenge.crud.model.NovoUsuario;
import br.com.chellenge.crud.model.Usuario;
import br.com.chellenge.crud.service.UsuarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@RestController
@RequestMapping(value = "usuario")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@ApiOperation(value = "Cadastrar um novo usuario", 
			  notes = "Este metodo cadastra um novo usuario no sistema.")
	@ApiResponses({ 
	@ApiResponse(code = 400, message = "Requisição inválida."),
	@ApiResponse(code = 401, message = "Não autorizado."), 
	@ApiResponse(code = 403, message = "Não permitido."),
	@ApiResponse(code = 404, message = "Recurso não encontrado."),
	@ApiResponse(code = 500, message = "Erro interno do sistema") })
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> save(@Valid @RequestBody NovoUsuario usuario){
		Usuario newUser = usuarioService.save(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
	}
	
	@ApiOperation(value = "Atualizar usuario", 
			  notes = "Este metodo atualiza usuario por {id}.")
	@ApiResponses({ 
	@ApiResponse(code = 400, message = "Requisição inválida."),
	@ApiResponse(code = 401, message = "Não autorizado."), 
	@ApiResponse(code = 403, message = "Não permitido."),
	@ApiResponse(code = 404, message = "Recurso não encontrado."),
	@ApiResponse(code = 500, message = "Erro interno do sistema") })
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> edit(@PathVariable(name = "id") Long id, @Valid @RequestBody Usuario usuario){
		usuario.setId(id);
		this.usuarioService.update(usuario);
		return ResponseEntity.ok(usuario);
	}
	
	@ApiOperation(value = "Listar todos usuarios", 
			  notes = "Este metodo lista todos os usuarios cadastrados na base.")
	@ApiResponses({
		@ApiResponse(code = 400, message = "Requisição inválida."),
		@ApiResponse(code = 401, message = "Não autorizado."), 
		@ApiResponse(code = 403, message = "Não permitido."),
		@ApiResponse(code = 404, message = "Recurso não encontrado."),
		@ApiResponse(code = 500, message = "Erro interno do sistema") })
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> list(){
		List<Usuario> listUser = this.usuarioService.list();
		return ResponseEntity.ok(listUser);
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
	public ResponseEntity<Usuario> delete(Long id){
		this.usuarioService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Listar usuarios por {id}", 
			  notes = "Este metodo lista usuarios por {id}.")
	@ApiResponses({ 
		@ApiResponse(code = 400, message = "Requisição inválida."),
		@ApiResponse(code = 401, message = "Não autorizado."), 
		@ApiResponse(code = 403, message = "Não permitido."),
		@ApiResponse(code = 404, message = "Recurso não encontrado."),
		@ApiResponse(code = 500, message = "Erro interno do sistema") })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> listById(@PathVariable("id") Long id){
		Usuario usuario = this.usuarioService.listById(id);
		return ResponseEntity.ok(usuario);
	}
	
}
