package br.com.antonio.mauricio.projetoweb.service;

import br.com.antonio.mauricio.projetoweb.model.Pergunta;
import br.com.antonio.mauricio.projetoweb.model.UserSession;
import br.com.antonio.mauricio.projetoweb.repository.PerguntaRepository;
import br.com.antonio.mauricio.projetoweb.response.RetornoApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerguntaService {

    private PerguntaRepository repository;

    @Autowired
    public PerguntaService(PerguntaRepository repository) {
        this.repository = repository;
    }

    public List<Pergunta> findAll() {
        return repository.findAll();
    }

    public Pergunta findOne(Long id) {
        return repository.findOne(id);
    }

    public RetornoApi findByIdProva(Long idProva, UserSession userSession) {
        return new RetornoApi(repository.findByIdProva(idProva));
    }

    public List<Pergunta> findByIdProva(Long idProva) {
        return repository.findByIdProva(idProva);
    }

    public Pergunta save(Pergunta post) {
        return repository.saveAndFlush(post);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

}
