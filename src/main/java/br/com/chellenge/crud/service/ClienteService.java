package br.com.chellenge.crud.service;

import java.util.List;

import br.com.chellenge.crud.model.Cliente;

public interface ClienteService {
	
	Cliente salvar(Cliente cliente);
	
	Cliente editar(Cliente cliente);
	
	void remover(Integer id);
	
	List<Cliente> listar();
	
	Cliente listarById(Integer id);
}
