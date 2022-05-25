package org.serratec.backend.projeto06.repository;

import org.serratec.backend.projeto06.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro,Integer> {

}
