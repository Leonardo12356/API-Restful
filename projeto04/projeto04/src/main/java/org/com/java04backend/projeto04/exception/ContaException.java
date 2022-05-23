package org.com.java04backend.projeto04.exception;

public class ContaException extends Exception {
	// Atributos
	private static final long serialVersionUID = 1L;
	private Integer id;

	// Construtor
	public ContaException(Integer id) {
		this.id = id;
	}

	// Getters e Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}