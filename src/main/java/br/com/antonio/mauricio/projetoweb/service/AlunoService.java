package br.com.antonio.mauricio.projetoweb.service;

import br.com.antonio.mauricio.projetoweb.dao.TokenDAO;
import br.com.antonio.mauricio.projetoweb.model.Aluno;
import br.com.antonio.mauricio.projetoweb.model.Token;
import br.com.antonio.mauricio.projetoweb.model.UserSession;
import br.com.antonio.mauricio.projetoweb.repository.AlunoRepository;
import br.com.antonio.mauricio.projetoweb.response.RetornoApi;
import br.com.antonio.mauricio.projetoweb.response.RetornoApiErro;
import br.com.antonio.mauricio.projetoweb.utils.AlunoConstantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class AlunoService {

    private AlunoRepository repository;
    private TokenDAO tokenDao;

    @Autowired
    public AlunoService(AlunoRepository repository, TokenDAO tokenDao) {
        this.repository = repository;
        this.tokenDao = tokenDao;
    }

    public List<Aluno> findAll() {
        return repository.findAll();
    }

    public Aluno findOne(Long id) {
        return repository.findOne(id);
    }

    public List<Aluno> findByIdUsuario(Long idUsuario) {
        return repository.findByIdUsuario(idUsuario);
    }

    public Aluno save(Aluno post) {
        return repository.saveAndFlush(post);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public Aluno findAlunoByChave(String chaveAluno) {
        return repository.findAlunoByChave(chaveAluno);
    }

    public RetornoApi findAlunoByChave(String chaveAluno, UserSession userSession) throws RetornoApiErro {
        Aluno obj = repository.findAlunoByChave(chaveAluno);
        if (obj == null)
            throw new RetornoApiErro().setErrorHttp404(AlunoConstantes.MSG_ERRO_CHAVE_INVALIDA);
        Token tokenObj = tokenDao.findByUserId(obj.getId(), userSession);
        if (tokenObj != null)
            tokenDao.delete(tokenObj);
        Date data = new Date();
        Token token = new Token();
        token.setAluno(obj);
        token.setToken(UUID.randomUUID().toString());
        token.setDataHoraCadastro(data);
        token = tokenDao.save(token);
        return new RetornoApi(token);
    }

}
