package br.com.antonio.mauricio.projetoweb.service;

import br.com.antonio.mauricio.projetoweb.model.Prova;
import br.com.antonio.mauricio.projetoweb.repository.ProvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvaService {

    private ProvaRepository repository;

    @Autowired
    public ProvaService(ProvaRepository repository) {
        this.repository = repository;
    }

    public List<Prova> findAll() {
        return repository.findAll();
    }

    public Prova findOne(Long id) {
        return repository.findOne(id);
    }

    public List<Prova> findByIdUsuario(Long idUsuario) {
        return repository.findByIdUsuario(idUsuario);
    }

    public Prova save(Prova post) {
        return repository.saveAndFlush(post);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

}
