package br.com.antonio.mauricio.projetoweb.controller;

import br.com.antonio.mauricio.projetoweb.model.Aluno;
import br.com.antonio.mauricio.projetoweb.model.User;
import br.com.antonio.mauricio.projetoweb.response.RetornoApi;
import br.com.antonio.mauricio.projetoweb.response.RetornoApiErro;
import br.com.antonio.mauricio.projetoweb.service.AlunoService;
import br.com.antonio.mauricio.projetoweb.utils.AlunoConstantes;
import br.com.antonio.mauricio.projetoweb.utils.ErroConstantes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Api(tags = "aluno")
@RestController
@Controller("/aluno")
public class AlunoController extends GenericController {

    private AlunoService service;

    @Autowired
    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @GetMapping(value = {"/aluno", "/aluno/"})
    public ModelAndView findAll() throws RetornoApiErro {
        User usuario = getUsuarioAutenticado();
        ModelAndView mv = new ModelAndView();
        mv.setViewName(AlunoConstantes.VIEW_LISTA_ALUNOS);
        mv.addObject("alunos", service.findByIdUsuario(usuario.getId()));
        return mv;
    }

    @GetMapping("/aluno/add")
    public ModelAndView add(Aluno aluno) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(AlunoConstantes.VIEW_CADASTRO_ALUNO);
        mv.addObject("aluno", aluno);
        return mv;
    }

    @GetMapping("/aluno/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        return add(service.findOne(id));
    }

    @GetMapping("/aluno/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) throws RetornoApiErro {
        service.delete(id);
        return findAll();
    }

    @PostMapping("/aluno/save")
    public ModelAndView save(@Valid Aluno aluno, BindingResult result) throws RetornoApiErro {
        if (result.hasErrors()) {
            return add(aluno);
        }
        if (aluno.getId() == null && service.findAlunoByChave(aluno.getChaveAluno()) != null) {
            result.rejectValue("chaveAluno", "error.aluno", AlunoConstantes.MSG_ERRO_JA_EXISTE_CHAVE_ALUNO);
        }
        if (result.hasErrors()) {
            return add(aluno);
        } else {
            aluno.setUsuarioProfessor(getUsuarioAutenticado());
            service.save(aluno);
            return findAll();
        }
    }

    @ApiOperation(httpMethod = "GET", value = "Faz o login de um aluno, retornando o seu token")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = ErroConstantes.CODIGO_200_DESCRICAO, response = RetornoApi.class),
            @ApiResponse(code = 401, message = ErroConstantes.CODIGO_401_DESCRICAO, response = RetornoApiErro.class),
            @ApiResponse(code = 500, message = ErroConstantes.CODIGO_500_DESCRICAO, response = RetornoApiErro.class)})
    @ResponseBody
    @GetMapping(value = "/aluno/findByChave/{chave}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RetornoApi findByChave(@PathVariable(value = "chave", required = true) String chave) throws RetornoApiErro {
        return service.findAlunoByChave(chave, userSession);
    }
}
