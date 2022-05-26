package org.serratec.backend.projeto06.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "livro")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "livro_cd_id")
	private Integer idLivro;

	@Column(name = "livro_tx_titulo")
	@Size(min = 5, max = 30)
	@NotNull
	private String tituloLivro;

	@Column(name = "livro_tx_tipo")
	@Size(min = 3, max = 20)
	@NotNull
	private String tipoLivro;

	@Column(name = "livro_tx_autor")
	@Size(min = 10, max = 40)
	private String autor;
	
	@Past // aceita somente a data anterior a de hoje
	@Column(name = "livro_dt_publicacao")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Temporal(TemporalType.DATE)
	private Date pubLivro;

	public Livro() {

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
