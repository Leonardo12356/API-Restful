package org.serratec.java3backend.projeto03.projeto03.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.java3backend.projeto03.projeto03.model.CasaDeMusica;
import org.springframework.stereotype.Service;

@Service
public class MusicaService {

	List<CasaDeMusica> lista = new ArrayList<>();

	public void adicionar(CasaDeMusica musica) {
		lista.add(musica);
	}

	public List<CasaDeMusica> musicaTodo() {
		return this.lista;
	}
	
	public void atualizar(Integer posicaoLista, CasaDeMusica Api) {
		CasaDeMusica musica = new CasaDeMusica();
		musica = lista.get(posicaoLista);
		
		musica.setId(Api.getId());
		musica.setInstrumento(Api.getInstrumento());
		musica.setTipo(Api.getTipo());
		
	}
	
	public void deletar(int posicaoLista) {
		lista.remove(posicaoLista);
	}

}
