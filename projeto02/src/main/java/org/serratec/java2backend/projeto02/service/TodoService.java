package org.serratec.java2backend.projeto02.service;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import org.serratec.java2backend.projeto02.model.Todo;
//import org.serratec.java2backend.projeto02.repository.TodoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

//	@Autowired
//	TodoRepository todoRepository;

	List<Todo> lista = new ArrayList<>();

	public void adicionar(Todo todo) {
		lista.add(todo);
	}

	public List<Todo> listaTodo() {
		return this.lista;
	}

	public void atualiza(Integer posicaoLista, Todo todoDaApi) {
		// idTodo é posição
		Todo todoDalistaSalva = new Todo();
		todoDalistaSalva = lista.get(posicaoLista);

		todoDalistaSalva.setId(todoDaApi.getId());
		todoDalistaSalva.setDescricao(todoDaApi.getDescricao());
		todoDalistaSalva.setTitulo(todoDaApi.getTitulo());
	}

	public void deletar(int posicaoLista) {
		lista.remove(posicaoLista);
	}

//	private List<Todo> todos = Arrays.asList(new Todo(1, "Mercado", "Ir ao mercado fazer compras"), 
//			new Todo(2, "Remédio", "ir na farmácia"),
//			new Todo(3, "Estudar", "abrir o classroom para entrar na sala"));
//	

}
