package br.com.antonio.mauricio.projetoweb.service;

import br.com.antonio.mauricio.projetoweb.model.RespostaUsuario;
import br.com.antonio.mauricio.projetoweb.model.RespostaUsuarioList;
import br.com.antonio.mauricio.projetoweb.model.UserSession;
import br.com.antonio.mauricio.projetoweb.repository.RespostaUsuarioRepository;
import br.com.antonio.mauricio.projetoweb.response.RetornoApi;
import br.com.antonio.mauricio.projetoweb.response.RetornoApiErro;
import br.com.antonio.mauricio.projetoweb.utils.RespostaUsuarioConstantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespostaUsuarioService {

    private RespostaUsuarioRepository repository;

    @Autowired
    public RespostaUsuarioService(RespostaUsuarioRepository repository) {
        this.repository = repository;
    }

    public RetornoApi saveRespostasAluno(RespostaUsuarioList requestBody, UserSession userSession) throws RetornoApiErro {
        if (requestBody != null && requestBody.getRespostas() != null && !requestBody.getRespostas().isEmpty()) {
            repository.save(requestBody.getRespostas());
            return new RetornoApi(true);
        } else {
            throw new RetornoApiErro(RespostaUsuarioConstantes.MSG_ERRO_LISTA_INVALIDA, 400);
        }
    }

    public List<RespostaUsuario> findByIdUsuario(Long idUsuario) {
        return repository.findByIdUsuarioProfessor(idUsuario);
    }

}
