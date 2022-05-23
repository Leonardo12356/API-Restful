package org.com.java04backend.projeto04.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(ContaException.class)
	public ResponseEntity<String> trataTodoNotFound(ContaException exception) {
		String msg = String.format("O saldo da conta de ID %d não é suficiente.", exception.getId());
		return ResponseEntity.badRequest().header("x-erro-msg", msg).header("x-erro-code", "Saldo Insuficiente")
				.header("x-erro-value", exception.getId().toString()).build();
	}
}