package br.com.chellenge.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.chellenge.crud.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
