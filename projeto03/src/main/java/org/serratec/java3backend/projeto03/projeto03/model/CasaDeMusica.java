package org.serratec.java3backend.projeto03.projeto03.model;

public class CasaDeMusica {
	
	private Integer id;
	private String instrumento;
	private String tipo;
	
	public CasaDeMusica() {
		
	}

	public CasaDeMusica(Integer id, String instrumento, String tipo) {
		super();
		this.id = id;
		this.instrumento = instrumento;
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInstrumento() {
		return instrumento;
	}

	public void setInstrumento(String instrumento) {
		this.instrumento = instrumento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	
}
