package br.com.chellenge.crud.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.chellenge.crud.model.Role;
import br.com.chellenge.crud.model.Usuario;
import br.com.chellenge.crud.model.NovoUsuario;
import br.com.chellenge.crud.repository.UsuarioRepository;
import br.com.chellenge.crud.service.UsuarioService;


@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Usuario findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Usuario save(NovoUsuario novoUsuario) {
        Usuario user = new Usuario();
        user.setNome(novoUsuario.getNome());
        user.setSobrenome(novoUsuario.getSobrenome());
        user.setEmail(novoUsuario.getEmail());
        user.setPassword(passwordEncoder.encode(novoUsuario.getPassword()));
        user.setRoles(Arrays.asList(new Role(null, "ROLE_USER")));
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Email ou senha invalido.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
            user.getPassword(),
            mapRolesToAuthorities(user.getRoles()));
    }

    private Collection <? extends GrantedAuthority > mapRolesToAuthorities(Collection <Role> roles) {
        return roles.stream()
            .map(role -> new SimpleGrantedAuthority(role.getName()))
            .collect(Collectors.toList());
    }
}