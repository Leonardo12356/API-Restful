package org.serratecbackend.projeto07.repository;

import java.util.List;

import org.serratecbackend.projeto07.DTO.RelatorioDTO;
import org.serratecbackend.projeto07.model.ServPrestado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServPrestadoRepository extends JpaRepository<ServPrestado,Integer> {

	
	@Query(value="select\r\n"
			+ "c2.CLIENTE_TX_NOME as cliente,\r\n"
			+ "c.MODELO_TX_CARRO  as modelo,\r\n"
			+ "s.SERVICO_TX_SERVICO as Servico,\r\n"
			+ "s.SERVICO_VALOR  as valor\r\n"
			+ "from serv_prestado s join carro c on(s.servico_carro=c.carro_cd_id)\r\n"
			+ "join cliente c2 on(c2.cliente_cd_id=c.CLIENTE_PROPRIETARIO)\r\n"
			+ "order by s.SERVICO_CD_ID \r\n"
			+ "desc", nativeQuery=true)
	
	List<RelatorioDTO> relatorio();
}
