package br.com.chellenge.crud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.chellenge.crud.model.Cliente;
import br.com.chellenge.crud.service.ClienteService;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteService service;
		
	@GetMapping("/")
	public ModelAndView findAll() {	
		ModelAndView mv = new ModelAndView("cliente");
		mv.addObject("clientes", service.listar());
		
		return mv;
	}
	
	@GetMapping("/add")
	public ModelAndView add(Cliente cliente) {
		
		ModelAndView mv = new ModelAndView("add");
		mv.addObject("cliente", cliente);
		
		return mv;
	}
	
	@GetMapping("edit/{id}")
	public ModelAndView edit(@PathVariable("id") Integer id) {
		return add(service.listarById(id));
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id) {
		service.remover(id);
		return findAll();
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid Cliente cliente, BindingResult result) {
		if(result.hasErrors()) {
			return add(cliente);
		}
		service.salvar(cliente);
		return findAll();
	}
	
}
