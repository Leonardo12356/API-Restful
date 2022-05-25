package org.serratec.backend.projeto06.DTO;

import java.io.Serializable;
import java.util.Date;

public class LivroDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idLivro;
	private String tituloLivro;
	private String tipoLivro;
	private String autor;
	private Date pubLivro;
	
	public LivroDTO() {
		
	}

	public Integer getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}

	public String getTituloLivro() {
		return tituloLivro;
	}

	public void setTituloLivro(String tituloLivro) {
		this.tituloLivro = tituloLivro;
	}

	public String getTipoLivro() {
		return tipoLivro;
	}

	public void setTipoLivro(String tipoLivro) {
		this.tipoLivro = tipoLivro;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Date getPubLivro() {
		return pubLivro;
	}

	public void setPubLivro(Date pubLivro) {
		this.pubLivro = pubLivro;
	}

}
