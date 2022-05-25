package org.serratec.backend.projeto05.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.projeto05.DTO.CartaoDTO;
import org.serratec.backend.projeto05.exception.CartaoException;
import org.serratec.backend.projeto05.model.Cartao;
import org.serratec.backend.projeto05.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartaoService {

	@Autowired
	CartaoRepository cartaoRepository;

	public CartaoDTO transformarModelEmDTO(Cartao cartao, CartaoDTO cartaoDTO) {

		cartaoDTO.setDataValidade(cartao.getDataValidade());
		cartaoDTO.setIdCartao(cartao.getIdCartao());
		cartaoDTO.setLimiteCartao(cartao.getLimiteCartao());
		cartaoDTO.setNomeTitular(cartao.getNomeTitular());
		cartaoDTO.setNumeroCartao(cartao.getNumeroCartao());

		return cartaoDTO;
	}

	public Cartao transformarDTOEmModel(Cartao cartao, CartaoDTO cartaoDTO) {

		// o id é cadastrado automaticamente
		cartao.setDataValidade(cartaoDTO.getDataValidade());
		cartao.setLimiteCartao(cartaoDTO.getLimiteCartao());
		cartao.setNomeTitular(cartaoDTO.getNomeTitular());
		cartao.setNumeroCartao(cartaoDTO.getNumeroCartao());

		return cartao;

	}

	public String salvar(CartaoDTO cartaoDTO) {
		Cartao cartao = new Cartao();
		transformarDTOEmModel(cartao, cartaoDTO);
		cartaoRepository.save(cartao);
		return "O cartao criado foi com id: " + cartao.getIdCartao();
	}

	public CartaoDTO buscarPorId(Integer idCartao) throws CartaoException {
		Optional<Cartao> cartao = cartaoRepository.findById(idCartao);
		Cartao cartaoNoBanco = new Cartao();
		CartaoDTO cartaoDTO = new CartaoDTO();
		if (cartao.isPresent()) {
			cartaoNoBanco = cartao.get();
			transformarModelEmDTO(cartaoNoBanco, cartaoDTO);
			return cartaoDTO;
		}
		throw new CartaoException("Cartao com o id informado não encontrado");
	}

	public void deletar(Integer idCartao) {
		cartaoRepository.deleteById(idCartao);
	}

	public String atualizar(Integer idCartao, CartaoDTO cartaoDTO) throws CartaoException {
		Optional<Cartao> cartao = cartaoRepository.findById(idCartao);
		Cartao cartaoBanco = new Cartao();
		if (cartao.isPresent()) {
			cartaoBanco = cartao.get();
			if (cartaoDTO.getDataValidade() != null) {
				cartaoBanco.setDataValidade(cartaoDTO.getDataValidade());
			}

			if (cartaoDTO.getLimiteCartao() != null) {
				cartaoBanco.setLimiteCartao(cartaoDTO.getLimiteCartao());
			}

			if (cartaoDTO.getNomeTitular() != null) {
				cartaoBanco.setNomeTitular(cartaoDTO.getNomeTitular());
			}
			if (cartaoDTO.getNumeroCartao() != null) {
				cartaoBanco.setNumeroCartao(cartaoDTO.getNumeroCartao());
			}
			cartaoRepository.save(cartaoBanco);
			return "O cartao com o id " + cartaoBanco.getIdCartao()+" foi atualizado";
		}
		throw new CartaoException("O cartão não foi atualizado");
	}
	
	public List<CartaoDTO> buscarTodos(){
		List<Cartao> listaCartaoModel = cartaoRepository.findAll();
		List<CartaoDTO> listaCartaoDTO = new ArrayList<>();
		for (Cartao cartao : listaCartaoModel) {
			CartaoDTO cartaoDTO = new CartaoDTO();
			transformarModelEmDTO(cartao,cartaoDTO);
			listaCartaoDTO.add(cartaoDTO);
		}
		
		return listaCartaoDTO;
	}
	
	public void salvarListaCartao(List<CartaoDTO> listaCartaoDTO) {
		List<Cartao> listaCartao = new ArrayList<>();
		
		for (CartaoDTO cartaoDTO : listaCartaoDTO) {
			Cartao cartao = new Cartao();
			transformarDTOEmModel(cartao, cartaoDTO);
			listaCartao.add(cartao);
		}
		cartaoRepository.saveAll(listaCartao);
	}
}
