package br.com.antonio.mauricio.projetoweb.repository;

import br.com.antonio.mauricio.projetoweb.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

	/* ============== findById =========================================== */
	@Query("select obj from #{#entityName} obj where obj.id = ?1")
	Token findById(int id);

	/*
	 * ============== findByToken ===========================================
	 */
	@Query("select obj from #{#entityName} obj where obj.token = ?1 ")
	Token findByToken(String token);

	@Query("select obj from #{#entityName} obj where obj.aluno.id = ?1 ")
	Token findByUserId(Long idUsuario);

}
