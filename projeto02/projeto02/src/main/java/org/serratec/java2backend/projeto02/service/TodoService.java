package org.serratec.java2backend.projeto02.service;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.serratec.java2backend.projeto02.exception.TodoException;
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

	public List<Todo> findById(Integer idTodo) {
		List<Todo> todoBanco = new ArrayList<>();
		todoBanco = lista.stream().filter(todo -> todo.getId() == idTodo).collect(Collectors.toList());
		return todoBanco;
	}

	public void atualiza(Integer posicaoLista, Todo todoDaApi) {
		// idTodo é posição
		Todo todoDalistaSalva = new Todo();
		todoDalistaSalva = lista.get(posicaoLista);

		todoDalistaSalva.setId(todoDaApi.getId());
		todoDalistaSalva.setDescricao(todoDaApi.getDescricao());
		todoDalistaSalva.setTitulo(todoDaApi.getTitulo());
	}

	public Todo buscarPorId(Integer idTodo) throws TodoException {
		Todo todoNoBanco = new Todo();
		for (Todo todo : lista) {
			if (todo.getId().equals(idTodo)) {
				todoNoBanco = todo;
			}
		}
		if (todoNoBanco.getId() == null) {
			throw new TodoException(idTodo);
		}

		return todoNoBanco;
	}

	public void deletar(int posicaoLista) {
		lista.remove(posicaoLista);
	}

//	private List<Todo> todos = Arrays.asList(new Todo(1, "Mercado", "Ir ao mercado fazer compras"), 
//			new Todo(2, "Remédio", "ir na farmácia"),
//			new Todo(3, "Estudar", "abrir o classroom para entrar na sala"));
//	

}
