package br.com.antonio.mauricio.projetoweb.repository;

import br.com.antonio.mauricio.projetoweb.model.RespostaUsuario;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespostaUsuarioRepository extends JpaRepository<RespostaUsuario, Long> {

	@Query("select obj from #{#entityName} obj where obj.id = ?1")
	RespostaUsuario findById(Long idFaleConosco);
	
	@Query("select obj from #{#entityName} obj where obj.aluno.id = ?1")
	List<RespostaUsuario> findByIdAluno(Long idAluno);
	
	@Query("select obj from #{#entityName} obj ")
	List<RespostaUsuario> findAllList(Pageable pageable);

	@Query("select obj from #{#entityName} obj where obj.aluno.usuarioProfessor.id = ?1")
	List<RespostaUsuario> findByIdUsuarioProfessor(Long idUsuario);

}
