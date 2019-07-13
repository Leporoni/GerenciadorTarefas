package com.leporonitech.gerenciadortarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leporonitech.gerenciadortarefas.model.Usuario;

public interface UsuarioRepositoy extends JpaRepository<Usuario, Long>{
	
	Usuario findByEmail(String email);

}
