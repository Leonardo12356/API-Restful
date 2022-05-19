package org.serratec.backend.projeto01;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Calculadora {
	 
	 
	public Double total;
	
	@RequestMapping("/calcular1")
	public int calc(@RequestParam int num1, @RequestParam int num2, @RequestParam int valor) {
		valor = num1 + num2;
		return valor;
	}
	
	@RequestMapping("/calcular2")
	public int calcu(@RequestParam int num1, @RequestParam int num2, @RequestParam int valor) {
		valor = num1 - num2;
		return valor;
	}
	
	@RequestMapping("/calcular3")
	public int calcula(@RequestParam int num1, @RequestParam int num2, @RequestParam int valor) {
		valor = num1 * num2;
		return valor;
	}
	
	@RequestMapping("/calcular4")
	public Double calculadora(@RequestParam Double num1, @RequestParam Double num2, @RequestParam Double valor) {
		valor = (num1 / num2);
		return valor;
	}
	//http://localhost:8080/calcular4?num1=5&num2=5&valor=0
}
