package org.serratec.java2backend.projeto02.model;

public class PetShop {

	private String raca;
	private String tipo;
	private double peso;

	public PetShop() {

	}

	public PetShop(String raca, String tipo, double peso) {
		super();
		this.raca = raca;
		this.tipo = tipo;
		this.peso = peso;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

}
