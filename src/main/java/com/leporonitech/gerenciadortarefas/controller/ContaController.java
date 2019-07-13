package com.leporonitech.gerenciadortarefas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.leporonitech.gerenciadortarefas.model.Usuario;
import com.leporonitech.gerenciadortarefas.service.UsuarioService;

@Controller
public class ContaController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/login")
	public String login() {
		return "conta/login";
	}

	@GetMapping("/registration")
	public ModelAndView registrar() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("conta/registrar");
		mv.addObject("usuario", new Usuario());
		return mv;
	}

	@PostMapping("/registration")
	public ModelAndView registrar(@Valid Usuario usuario, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		Usuario usr = usuarioService.encontrarPorEmail(usuario.getEmail());
		if (usr != null) {
			result.rejectValue("email", "", "Usuário já cadastrado");
		}
		if (result.hasErrors()) {
			mv.setViewName("conta/registrar");
			mv.addObject("usuario", usuario);
		} else {
			usuarioService.salvar(usuario);
			mv.setViewName("redirect:/login");
		}
		return mv;
	}
}
