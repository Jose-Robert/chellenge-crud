package br.com.chellenge.crud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.chellenge.crud.exception.ClienteException;
import br.com.chellenge.crud.exception.ClienteIdInexistenteExcpetion;
import br.com.chellenge.crud.model.Cliente;
import br.com.chellenge.crud.repository.ClienteRepository;
import br.com.chellenge.crud.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Override
	public Cliente salvar(Cliente cliente) {
		Cliente obj = this.repository.saveAndFlush(cliente);
		return obj;
	}

	@Override
	public Cliente editar(Cliente cliente) {
		Cliente editarCliente = repository.save(cliente);
		return editarCliente;
		
	}

	@Override
	public void remover(Integer id) {
		try {
			Optional<Cliente> cli = this.repository.findById(id);
			this.repository.delete(cli.get());

		} catch (Exception e) {
			throw new ClienteException("Não foi possivel realizar a operação!!!");
		}
	}

	@Override
	public List<Cliente> listar() {
		List<Cliente> clientes = this.repository.findAll();
		return clientes;

	}

	@Override
	public Cliente listarById(Integer id) {
		Optional<Cliente> cliente = this.repository.findById(id);
		if(!cliente.isPresent()) {
			throw new ClienteIdInexistenteExcpetion("Id nulo ou inexistente!");
		}else {
			return cliente.get();
		}
		
	}

}
