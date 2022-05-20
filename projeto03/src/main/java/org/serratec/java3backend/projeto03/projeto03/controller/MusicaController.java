package org.serratec.java3backend.projeto03.projeto03.controller;

import java.util.List;
import org.serratec.java3backend.projeto03.projeto03.model.CasaDeMusica;
import org.serratec.java3backend.projeto03.projeto03.service.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/musica")
public class MusicaController {

	@Autowired
	MusicaService musicaService;
	
	@GetMapping("/lista")
	public List<CasaDeMusica> getMusica(){
		return musicaService.musicaTodo();
	}
	
	@GetMapping("/buscar/{idTodo}")
	public CasaDeMusica buscarId(@PathVariable Integer idTodo) {
		return musicaService.buscarPorId(idTodo);
	}
	
	
	@PostMapping("/adicionar")
	public void adicionar(@RequestBody CasaDeMusica musica) {
		musicaService.adicionar(musica);
	}
	
	@PutMapping("/atualizar/{posicaoLista}")
	public void atualizar(@PathVariable Integer posicaoLista, @RequestBody CasaDeMusica Api) {
		musicaService.atualizar(posicaoLista, Api);
	}
	
	@DeleteMapping("/delete/{posicaoLista}")
	public void deletar (@PathVariable int posicaoLista) {
		musicaService.deletar(posicaoLista);
	}
}
