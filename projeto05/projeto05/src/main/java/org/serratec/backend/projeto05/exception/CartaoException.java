package org.serratec.backend.projeto05.exception;

public class CartaoException  extends Exception{

	private static final long serialVersionUID = 1L;

	public CartaoException() {
		super();
	}
	
	public CartaoException(String message) {
		super(message);
	}
	

	public CartaoException(String message, Exception cause) {
		super(message, cause);
	}
	
	public CartaoException(Exception e) {
		super(e);
	}
}
