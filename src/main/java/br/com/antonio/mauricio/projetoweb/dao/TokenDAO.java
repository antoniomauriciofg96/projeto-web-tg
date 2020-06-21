package br.com.antonio.mauricio.projetoweb.dao;

import br.com.antonio.mauricio.projetoweb.model.Token;
import br.com.antonio.mauricio.projetoweb.model.UserSession;
import br.com.antonio.mauricio.projetoweb.repository.TokenRepository;
import br.com.antonio.mauricio.projetoweb.utils.StringAux;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenDAO {

	private TokenRepository repository;

	@Autowired
	public TokenDAO(TokenRepository repository) {
		this.repository = repository;
	}

	public Token findById(Integer id) {
		return repository.findById(id);
	}

	public Token save(Token token) {
		return repository.saveAndFlush(token);
	}

	public Token findByToken(String token, UserSession userSession) {

		if (userSession == null)
			return null;
		return repository.findByToken(StringAux.replaceNull(token));
	}
	
	public Token findByUserId(Long idUsuario, UserSession userSession) {
		if (userSession == null)
			return null;
		return repository.findByUserId(StringAux.replaceNullLong(idUsuario));
	}

	public void delete(Token obj) {
		repository.delete(obj);
	}

}
