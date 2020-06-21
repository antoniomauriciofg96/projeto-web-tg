package br.com.antonio.mauricio.projetoweb.controller;

import br.com.antonio.mauricio.projetoweb.dao.TokenDAO;
import br.com.antonio.mauricio.projetoweb.model.Token;
import br.com.antonio.mauricio.projetoweb.model.User;
import br.com.antonio.mauricio.projetoweb.model.UserSession;
import br.com.antonio.mauricio.projetoweb.response.RetornoApiErro;
import br.com.antonio.mauricio.projetoweb.service.UserService;
import br.com.antonio.mauricio.projetoweb.utils.ErroConstantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;

public class GenericController {

    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected TokenDAO tokenDao;
    @Autowired
    protected UserSession userSession;
    @Autowired
    protected UserService userService;

    public void validateToken() throws RetornoApiErro {
        String headerToken = request.getHeader("token");
        if (headerToken == null) {
            throw new RetornoApiErro()
                    .setErrorHttp401(ErroConstantes.MSG_ERRO_TOKEN_INVALIDO);
        } else {
            userSession.setToken(headerToken);
            Token token = tokenDao.findByToken(headerToken, userSession);
            if (token == null) {
                throw new RetornoApiErro()
                        .setErrorHttp401(ErroConstantes.MSG_ERRO_TOKEN_INVALIDO);
            }
            userSession.setAluno(token.getAluno());
        }
    }

    protected User getUsuarioAutenticado() throws RetornoApiErro {
        String email = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() != null) {
            try {
                org.springframework.security.core.userdetails.User userDetail = (org.springframework.security.core.userdetails.User) authentication
                        .getPrincipal();
                email = userDetail.getUsername();
            } catch (Exception e) {
                email = authentication.getPrincipal().toString();
            }
        }
        if (email == null) {
            throw new RetornoApiErro().setErrorHttp401(ErroConstantes.MSG_ERRO_BUSCAR_DADOS_USUARIO);
        }
        User usuario = userService.findUserByEmail(email);
        if (usuario == null) {
            throw new RetornoApiErro().setErrorHttp401(ErroConstantes.MSG_ERRO_BUSCAR_DADOS_USUARIO);
        }
        return usuario;
    }

}
