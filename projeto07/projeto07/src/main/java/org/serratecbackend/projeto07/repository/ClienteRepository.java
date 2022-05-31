package org.serratecbackend.projeto07.repository;

import org.serratecbackend.projeto07.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
