package com.leporonitech.gerenciadortarefas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.leporonitech.gerenciadortarefas.model.Usuario;
import com.leporonitech.gerenciadortarefas.repository.UsuarioRepositoy;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepositoy usuarioRepositoy;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public Usuario encontrarPorEmail(String email) {
		 return usuarioRepositoy.findByEmail(email);
	}
	
	public void salvar(Usuario usuario) {
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		usuarioRepositoy.save(usuario);
	}
}
