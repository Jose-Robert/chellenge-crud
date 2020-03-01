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

@CrossOrigin
@RestController
@RequestMapping(value = "clientes")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> cadastrar(@Valid @RequestBody Cliente cliente){
		Cliente salvaCliente = this.clienteService.salvar(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaCliente);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> editar(@PathVariable(name = "id") Integer id,@Valid @RequestBody Cliente cliente){
		cliente.setId(id);
		Cliente editarCliente = clienteService.editar(cliente);
		return ResponseEntity.ok(editarCliente);
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cliente>> listar(){
		List<Cliente> listaCliente = this.clienteService.listar();
		return ResponseEntity.ok(listaCliente);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> remover(@PathVariable(name = "id") Integer id){
		this.clienteService.remover(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> listarById(@PathVariable("id") Integer id){
		Cliente cliente = this.clienteService.listarById(id);
		return ResponseEntity.ok(cliente);
	}
	
}
