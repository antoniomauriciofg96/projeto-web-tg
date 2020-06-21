package br.com.antonio.mauricio.projetoweb.repository;

import br.com.antonio.mauricio.projetoweb.model.Aluno;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	@Query("select obj from #{#entityName} obj where obj.id = ?1")
	Aluno findById(Long idFaleConosco);
	
	@Query("select obj from #{#entityName} obj where obj.usuarioProfessor.id = ?1")
	List<Aluno> findByIdUsuario(Long idUsuario);
	
	@Query("select obj from #{#entityName} obj ")
	List<Aluno> findAllList(Pageable pageable);

	@Query("select obj from #{#entityName} obj where obj.chaveAluno = ?1")
	Aluno findAlunoByChave(String chaveAluno);
	
}
