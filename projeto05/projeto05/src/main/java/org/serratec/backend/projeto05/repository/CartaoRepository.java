package org.serratec.backend.projeto05.repository;

import java.util.List;

import org.serratec.backend.projeto05.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository  extends JpaRepository<Cartao, Integer>{
//
//	@Query(value="select * from cartao order by cartao_id desc", nativeQuery=true)
//	List<Cartao> buscarTodosDesc();
//	
//	@Query(value="select count (*) from cartao ", nativeQuery=true)
//	Integer numeroTabela();
//	
//	@Query(value="SELECT C FROM Cartao C Order By idCartao DESC") // HQL não usa nativeQuery
//	List<Cartao> buscarTodosDEscHql();
//	
//	List<Cartao>findLimiteCartao(Double limiteCartao); // JPKL
}
