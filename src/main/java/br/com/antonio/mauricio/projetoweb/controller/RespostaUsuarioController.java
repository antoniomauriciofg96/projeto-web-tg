package br.com.antonio.mauricio.projetoweb.controller;

import br.com.antonio.mauricio.projetoweb.model.RespostaUsuarioList;
import br.com.antonio.mauricio.projetoweb.response.RetornoApi;
import br.com.antonio.mauricio.projetoweb.response.RetornoApiErro;
import br.com.antonio.mauricio.projetoweb.service.RespostaUsuarioService;
import br.com.antonio.mauricio.projetoweb.utils.ErroConstantes;
import br.com.antonio.mauricio.projetoweb.utils.RespostaUsuarioConstantes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Api(tags = "respostausuario")
@RestController
@Controller("/respostausuario")
public class RespostaUsuarioController extends GenericController {

    private RespostaUsuarioService service;

    @Autowired
    public RespostaUsuarioController(RespostaUsuarioService service) {
        this.service = service;
    }

    @GetMapping(value = {"/respostausuario", "/respostausuario/"})
    public ModelAndView findAll() throws RetornoApiErro {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(RespostaUsuarioConstantes.VIEW_LISTA_RESPOSTAS_USUARIOS);
        mv.addObject("respostausuarios", service.findByIdUsuario(getUsuarioAutenticado().getId()));
        return mv;
    }

    @ApiOperation(httpMethod = "POST", value = "Envia as respostas de um aluno")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = ErroConstantes.CODIGO_200_DESCRICAO, response = RetornoApi.class),
            @ApiResponse(code = 401, message = ErroConstantes.CODIGO_401_DESCRICAO, response = RetornoApiErro.class),
            @ApiResponse(code = 500, message = ErroConstantes.CODIGO_500_DESCRICAO, response = RetornoApiErro.class)})
    @ResponseBody
    @PostMapping(value = "/respostausuario/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RetornoApi saveRespostasAluno(@RequestBody RespostaUsuarioList requestBody) throws RetornoApiErro {
        validateToken();
        return service.saveRespostasAluno(requestBody, userSession);
    }

}
