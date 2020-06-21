package br.com.antonio.mauricio.projetoweb.repository;

import br.com.antonio.mauricio.projetoweb.model.Prova;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvaRepository extends JpaRepository<Prova, Long> {

	@Query("select obj from #{#entityName} obj where obj.id = ?1")
	Prova findById(Long idFaleConosco);
	
	@Query("select obj from #{#entityName} obj where obj.usuario.id = ?1")
	List<Prova> findByIdUsuario(Long idUsuario);
	
	@Query("select obj from #{#entityName} obj ")
	List<Prova> findAllList(Pageable pageable);
	
}
