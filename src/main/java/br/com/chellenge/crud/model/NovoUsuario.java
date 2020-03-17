package br.com.chellenge.crud.model;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import br.com.chellenge.crud.anotation.FieldMatch;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@FieldMatch.List({
    @FieldMatch(first = "password", second = "confirmPassword", message = "Os campos da senha devem ser iguais"),
    @FieldMatch(first = "email", second = "confirmEmail", message = "Os campos de email devem ser iguais")
})

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class NovoUsuario {

    @NotEmpty
    private String nome;

    @NotEmpty
    private String sobrenome;

    @NotEmpty
    private String password;

    @NotEmpty
    private String confirmPassword;

    @Email
    @NotEmpty
    private String email;

    @Email
    @NotEmpty
    private String confirmEmail;

    @AssertTrue
    private Boolean termos;
    
    
}