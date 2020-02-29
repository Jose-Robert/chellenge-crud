package br.com.chellenge.crud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.chellenge.crud.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	@Query("SELECT u FROM user u WHERE email = ?1 AND senha = ?2")
	public Optional<Usuario> login(String email, String senha);
}
