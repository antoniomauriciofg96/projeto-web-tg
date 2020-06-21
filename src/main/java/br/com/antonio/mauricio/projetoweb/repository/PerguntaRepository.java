package br.com.antonio.mauricio.projetoweb.repository;

import br.com.antonio.mauricio.projetoweb.model.Pergunta;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerguntaRepository extends JpaRepository<Pergunta, Long> {

	@Query("select obj from #{#entityName} obj where obj.id = ?1")
	Pergunta findById(Long id);
	
	@Query("select obj from #{#entityName} obj where obj.prova.id = ?1")
	List<Pergunta> findByIdProva(Long idProva);
	
	@Query("select obj from #{#entityName} obj ")
	List<Pergunta> findAllList(Pageable pageable);
	
}
