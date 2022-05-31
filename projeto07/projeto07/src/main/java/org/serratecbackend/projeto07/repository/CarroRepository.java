package org.serratecbackend.projeto07.repository;

import org.serratecbackend.projeto07.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<Carro,Integer> {

}
