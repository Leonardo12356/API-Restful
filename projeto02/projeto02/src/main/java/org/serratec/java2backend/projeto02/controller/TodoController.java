package org.serratec.java2backend.projeto02.controller;

import java.util.List;

import org.serratec.java2backend.projeto02.exception.TodoException;
import org.serratec.java2backend.projeto02.model.Todo;
import org.serratec.java2backend.projeto02.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class TodoController {

	@Autowired
	TodoService todoService;
	
	@GetMapping("/lista")
	public List<Todo> getTodo(){
		return todoService.listaTodo();
	}
	
	@PostMapping("/adicionar")
	public ResponseEntity<Void> adicionar(@RequestBody Todo todo) {
		todoService.adicionar(todo);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/buscar/{idTodo}")
	public ResponseEntity<Todo>buscarPorId(@PathVariable Integer idTodo) throws TodoException{
		return ResponseEntity.ok(todoService.buscarPorId(idTodo));
	}
	
	@PutMapping("/atualizar/{posicaoLista}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer posicaoLista, @RequestBody Todo todoDaApi) {
		todoService.atualiza(posicaoLista, todoDaApi);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{posicaoLista}")
	public ResponseEntity<Void> deletar (@PathVariable int posicaoLista) {
		todoService.deletar(posicaoLista);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
}
