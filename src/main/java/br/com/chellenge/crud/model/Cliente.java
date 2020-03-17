package br.com.chellenge.crud.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "CLIENTE")
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 200, nullable = false)
	private String nome;
	
	@Column(length = 14, nullable = false, unique = true)
	private String cpf;
	
	@Column(length = 20, nullable = false)
	private String telefone;
	
	@Column(length = 10, nullable = false)
	private String cep;
	
	@Column(length = 200, nullable = false)
	private String endereco;
	
	@Column(length = 100, nullable = false)
	private String bairro;
	
	@Column(length = 10, nullable = false)
	private String numero;
	
	@Column(length = 100, nullable = false)
	private String cidade;
	
	@Column(length = 100, nullable = false)
	private String estado;
	
	@Column(length = 100, nullable = false)
	private String pais;
	

}
