package br.com.chellenge.crud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.chellenge.crud.model.Usuario;
import br.com.chellenge.crud.model.NovoUsuario;
import br.com.chellenge.crud.service.UsuarioService;

@Controller
@RequestMapping("/registration")
public class NovoUsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @ModelAttribute("user")
    public NovoUsuario userRegistration() {
        return new NovoUsuario();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid NovoUsuario usuario,
        BindingResult result) {

        Usuario existing = usuarioService.findByEmail(usuario.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "Conta com o email já existente.");
        }

        if (result.hasErrors()) {
            return "registration";
        }

        usuarioService.save(usuario);
        return "redirect:/registration?success";
    }
}