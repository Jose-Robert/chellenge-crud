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

import br.com.chellenge.crud.model.Cliente;
import br.com.chellenge.crud.service.ClienteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@RestController
@RequestMapping(value = "clientes")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;

	@ApiOperation(value = "Cadastrar um novo cliente", 
				  notes = "Este metodo cadastra um novo usuario no sistema.")
	@ApiResponses({ 
		@ApiResponse(code = 400, message = "Requisição inválida."),
		@ApiResponse(code = 401, message = "Não autorizado."), 
		@ApiResponse(code = 403, message = "Não permitido."),
		@ApiResponse(code = 404, message = "Recurso não encontrado."),
		@ApiResponse(code = 500, message = "Erro interno do sistema") })
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> cadastrar(@Valid @RequestBody Cliente cliente) {
		Cliente salvaCliente = this.clienteService.salvar(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaCliente);
	}
	
	@ApiOperation(value = "Editar um cliente", 
			  notes = "Este metodo edita um cliente por {id}.")
	@ApiResponses({ 
		@ApiResponse(code = 400, message = "Requisição inválida."),
		@ApiResponse(code = 401, message = "Não autorizado."), 
		@ApiResponse(code = 403, message = "Não permitido."),
		@ApiResponse(code = 404, message = "Recurso não encontrado."),
		@ApiResponse(code = 500, message = "Erro interno do sistema") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> editar(@PathVariable(name = "id") Integer id, @Valid @RequestBody Cliente cliente) {
		cliente.setId(id);
		Cliente editarCliente = clienteService.editar(cliente);
		return ResponseEntity.ok(editarCliente);
	}

	@ApiOperation(value = "Listar clientes", 
			  notes = "Este metodo lista todos os clientes cadastrados na base.")
	@ApiResponses({
		@ApiResponse(code = 400, message = "Requisição inválida."),
		@ApiResponse(code = 401, message = "Não autorizado."), 
		@ApiResponse(code = 403, message = "Não permitido."),
		@ApiResponse(code = 404, message = "Recurso não encontrado."),
		@ApiResponse(code = 500, message = "Erro interno do sistema") })
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cliente>> listar() {
		List<Cliente> listaCliente = this.clienteService.listar();
		return ResponseEntity.ok(listaCliente);
	}

	@ApiOperation(value = "Excluir clientes", 
			  notes = "Este metodo exclui um cliente por {id}.")
	@ApiResponses({ 
		@ApiResponse(code = 400, message = "Requisição inválida."),
		@ApiResponse(code = 401, message = "Não autorizado."), 
		@ApiResponse(code = 403, message = "Não permitido."),
		@ApiResponse(code = 404, message = "Recurso não encontrado."),
		@ApiResponse(code = 500, message = "Erro interno do sistema") })
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> remover(@PathVariable(name = "id") Integer id) {
		this.clienteService.remover(id);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Listar clientes por {id}", 
			  notes = "Este metodo lista clientes por {id}.")
	@ApiResponses({ 
		@ApiResponse(code = 400, message = "Requisição inválida."),
		@ApiResponse(code = 401, message = "Não autorizado."), 
		@ApiResponse(code = 403, message = "Não permitido."),
		@ApiResponse(code = 404, message = "Recurso não encontrado."),
		@ApiResponse(code = 500, message = "Erro interno do sistema") })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> listarById(@PathVariable("id") Integer id) {
		Cliente cliente = this.clienteService.listarById(id);
		return ResponseEntity.ok(cliente);
	}

}
