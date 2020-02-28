package br.com.chellenge.crud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.chellenge.crud.exception.ClienteNuloOuInexistenteException;
import br.com.chellenge.crud.model.Cliente;
import br.com.chellenge.crud.repository.ClienteRepository;
import br.com.chellenge.crud.service.ClienteService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository repository;
	
	@Override
	public Cliente salvar(Cliente cliente) {
		Cliente obj = this.repository.saveAndFlush(cliente); 
		return obj;
	}

	@Override
	public Cliente atualizar(Cliente cliente) {
		Cliente obj = this.repository.save(cliente); 
		return obj;
	}

	@Override
	public void remover(Integer id) {
		try {
			Optional<Cliente> cli = this.repository.findById(id);
			this.repository.delete(cli.get());
 			
		} catch (Exception e) {
			log.info("Não foi possivel remover cliente com identificador =" +id);
			throw new ClienteNuloOuInexistenteException("Não foi possivel realizar a operação!!!");
		}
	}

	@Override
	public List<Cliente> listar() {
		List<Cliente> clientes = this.repository.findAll();
		return clientes;
	}

}
