package org.serratecbackend.projeto07.exception;

public class ServPrestadoException  extends Exception{

	private static final long serialVersionUID = 1L;

	public ServPrestadoException() {
		super();
	}
	
	public ServPrestadoException(String message) {
		super(message);
	}
	

	public ServPrestadoException(String message, Exception cause) {
		super(message, cause);
	}
	
	public ServPrestadoException(Exception e) {
		super(e);
	}
}
