package br.com.chellenge.crud.model;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "USUARIO", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String sobrenome;
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "USUARIOS_ROLES",
        joinColumns = @JoinColumn(
            name = "USUARIO_ID", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(
            name = "ROLE_ID", referencedColumnName = "id"))
    private Collection <Role> roles;
    
    
}
