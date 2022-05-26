package org.serratec.backend.projeto06.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.projeto06.DTO.LivroDTO;
import org.serratec.backend.projeto06.exception.LivroException;
import org.serratec.backend.projeto06.model.Livro;
import org.serratec.backend.projeto06.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

	@Autowired
	LivroRepository livroRepository;
	
	public LivroDTO transformarModelEmDTO(Livro livro, LivroDTO livroDTO) {
		
		livroDTO.setIdLivro(livro.getIdLivro());
		livroDTO.setTituloLivro(livro.getTituloLivro());
		livroDTO.setTipoLivro(livro.getTipoLivro());
		livroDTO.setAutor(livro.getAutor());
		livroDTO.setPubLivro(livro.getPubLivro());
		
		return livroDTO;
	}
	
	public Livro transformarDTOEmModel(Livro livro, LivroDTO livroDTO) {
		
		// id é gerado automaticamente
		livro.setTituloLivro(livroDTO.getTituloLivro());
		livro.setTipoLivro(livroDTO.getTipoLivro());
		livro.setAutor(livroDTO.getAutor());
		livro.setPubLivro(livroDTO.getPubLivro());
		
		return livro;
	}
	
	public String salvar(LivroDTO livroDTO) {
		Livro livro = new Livro();
		transformarDTOEmModel(livro, livroDTO);
		livroRepository.save(livro);
		return "O livro foi salvo com uma Id; " + livro.getIdLivro();
	}
	
	public LivroDTO buscarPorId(Integer idLivro) throws LivroException{
		Optional<Livro> livro = livroRepository.findById(idLivro);
		Livro livroNoBanco = new Livro();
		LivroDTO livroDTO = new LivroDTO();
		if(livro.isPresent()) {
			livroNoBanco = livro.get();
			transformarModelEmDTO(livroNoBanco, livroDTO);
			return livroDTO;
		}
		throw new LivroException ("A id do livro informado não foi encontrado.");
	}
	
	public void deletar(Integer idLivro) {
		livroRepository.deleteById(idLivro);
	}
	
	public String atualizar(Integer idLivro, LivroDTO livroDTO) throws LivroException{
		Optional<Livro> livro = livroRepository.findById(idLivro);
		Livro livroNoBanco = new Livro();
		if(livro.isPresent()) {
			livroNoBanco = livro.get();
			if(livroDTO.getAutor() != null) {
				livroNoBanco.setAutor(livroDTO.getAutor());
			}
			if(livroDTO.getPubLivro() != null) {
				livroNoBanco.setPubLivro(livroDTO.getPubLivro());
			}
			if(livroDTO.getTipoLivro() != null) {
				livroNoBanco.setTipoLivro(livroDTO.getTipoLivro());
			}
			if(livroDTO.getTituloLivro() != null) {
				livroNoBanco.setTituloLivro(livroDTO.getTituloLivro());
			}
			livroRepository.save(livroNoBanco);
			return "O livro com a id " + livroNoBanco.getIdLivro()+ " foi atualizado"; 
		}
		throw new LivroException("O livro foi reposto"); 
	}
	
	public List<LivroDTO> buscarTodos(){
		List<Livro> listaLivroaoModel = livroRepository.findAll();
		List<LivroDTO> listaLivroDTO = new ArrayList<>();
		for (Livro livro : listaLivroaoModel) {
			LivroDTO livroDTO = new LivroDTO();
			transformarModelEmDTO(livro, livroDTO);
			listaLivroDTO.add(livroDTO);
		}
		return listaLivroDTO;
	}
	
	public void salvarListaLivro(List<LivroDTO> listaLivroDTO) {
		List<Livro> listaLivro = new ArrayList<>();
		
		for(LivroDTO livroDTO : listaLivroDTO) {
			Livro livro = new Livro();
			transformarDTOEmModel(livro, livroDTO);
			listaLivro.add(livro);
		}
		livroRepository.saveAll(listaLivro);
	}
}
