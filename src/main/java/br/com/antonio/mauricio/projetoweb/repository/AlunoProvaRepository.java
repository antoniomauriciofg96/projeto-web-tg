package br.com.antonio.mauricio.projetoweb.repository;

import br.com.antonio.mauricio.projetoweb.model.AlunoProva;
import br.com.antonio.mauricio.projetoweb.model.Prova;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoProvaRepository extends JpaRepository<AlunoProva, Long> {

	@Query("select obj from #{#entityName} obj where obj.id = ?1")
	AlunoProva findById(Long idFaleConosco);
	
	@Query("select obj from #{#entityName} obj where obj.aluno.id = ?1")
	List<AlunoProva> findByIdAluno(Long idAluno);
	
	@Query("select obj from #{#entityName} obj where obj.usuarioProfessor.id = ?1")
	List<AlunoProva> findByIdUsuario(Long idUsuario);
	
	@Query("select obj from #{#entityName} obj ")
	List<AlunoProva> findAllList(Pageable pageable);

	@Query("select obj from #{#entityName} obj where obj.aluno.chaveAluno = ?1")
	AlunoProva findAlunoProvaByChave(String chaveAlunoProva);

	@Query("select obj from #{#entityName} obj where obj.aluno.id = ?1 and obj.prova.id = ?2 ")
	AlunoProva findAlunoProvaByIds(Long idAluno, Long idProva);

	@Query("select p from alunoprova obj left join obj.prova p where obj.prova.id = p.id and obj.aluno.id = ?1")
	List<Prova> findProvasByIdAluno(Long id);

}
