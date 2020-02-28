package br.com.chellenge.crud.service;

import java.util.List;

import br.com.chellenge.crud.model.Cliente;

public interface ClienteService {
	
	Cliente salvar(Cliente cli);
	
	Cliente atualizar(Cliente cli);
	
	void remover(Integer id);
	
	List<Cliente> listar();
}
