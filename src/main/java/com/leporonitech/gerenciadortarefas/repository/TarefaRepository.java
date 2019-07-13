package com.leporonitech.gerenciadortarefas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.leporonitech.gerenciadortarefas.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

	@Query("SELECT t FROM Tarefa t WHERE t.usuario.email = :emailUsuario")
	List<Tarefa> carregarTarefaPorUsuario(@Param("emailUsuario") String email);
}
