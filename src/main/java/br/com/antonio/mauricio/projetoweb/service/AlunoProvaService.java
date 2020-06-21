package br.com.antonio.mauricio.projetoweb.service;

import br.com.antonio.mauricio.projetoweb.model.AlunoProva;
import br.com.antonio.mauricio.projetoweb.model.UserSession;
import br.com.antonio.mauricio.projetoweb.repository.AlunoProvaRepository;
import br.com.antonio.mauricio.projetoweb.response.RetornoApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoProvaService {

    private AlunoProvaRepository repository;

    @Autowired
    public AlunoProvaService(AlunoProvaRepository repository) {
        this.repository = repository;
    }

    public List<AlunoProva> findAll() {
        return repository.findAll();
    }

    public AlunoProva findOne(Long id) {
        return repository.findOne(id);
    }

    public List<AlunoProva> findByIdAluno(Long idAluno) {
        return repository.findByIdAluno(idAluno);
    }

    public List<AlunoProva> findByIdUsuario(Long idUsuario) {
        return repository.findByIdUsuario(idUsuario);
    }

    public AlunoProva save(AlunoProva post) {
        return repository.saveAndFlush(post);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public AlunoProva findAlunoProvaByIds(Long idAluno, Long idProva) {
        return repository.findAlunoProvaByIds(idAluno, idProva);
    }

    public RetornoApi findProvasAluno(UserSession userSession) {
        return new RetornoApi(repository.findProvasByIdAluno(userSession.getAluno().getId()));
    }

    public RetornoApi findAllAlunoProvas(UserSession userSession) {
        return new RetornoApi(repository.findByIdAluno(userSession.getAluno().getId()));
    }

}
