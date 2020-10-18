package com.exemple.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemple.api.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
