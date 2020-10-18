package com.exemple.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.exemple.api.model.Aluno;
import com.exemple.api.repository.AlunoRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/curso")
public class AlunoController {

	@Autowired
	AlunoRepository alunoRepository;
	
	@GetMapping(produces = "application/json", value = "/alunos")
	public ResponseEntity<List<Aluno>> getAllStudents() {

		List<Aluno> alunos = alunoRepository.findAll();
		if(!alunos.isEmpty()) {
			return new ResponseEntity<List<Aluno>>(alunos, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(produces = "application/json", value = "/alunos/{id}")
	public ResponseEntity<Aluno> getOneStudent(@PathVariable(name = "id") long id) {
		
		Optional<Aluno> aluno = alunoRepository.findById(id);
		if(aluno.isPresent()) {
			return new ResponseEntity<Aluno>(aluno.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(value = "/alunos/{id}")
	public ResponseEntity<Aluno> delStudent(@PathVariable(name = "id") long id) {
		
		alunoRepository.deleteById(id);
		return new ResponseEntity<Aluno>(HttpStatus.OK);
	}
	
	@PostMapping(value = "/alunos")
	public ResponseEntity<Aluno> saveStudent(@RequestBody @Validated Aluno aluno) {
		
		alunoRepository.save(aluno);
		return new ResponseEntity<Aluno>(HttpStatus.CREATED);
	}
}
