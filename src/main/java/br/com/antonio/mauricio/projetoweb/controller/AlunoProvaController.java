package br.com.antonio.mauricio.projetoweb.controller;

import br.com.antonio.mauricio.projetoweb.model.AlunoProva;
import br.com.antonio.mauricio.projetoweb.response.RetornoApi;
import br.com.antonio.mauricio.projetoweb.response.RetornoApiErro;
import br.com.antonio.mauricio.projetoweb.service.AlunoProvaService;
import br.com.antonio.mauricio.projetoweb.service.AlunoService;
import br.com.antonio.mauricio.projetoweb.service.ProvaService;
import br.com.antonio.mauricio.projetoweb.utils.AlunoProvaConstantes;
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

@Api(tags = "alunoprova")
@RestController
@Controller("/alunoprova")
public class AlunoProvaController extends GenericController {

    private AlunoProvaService service;
    private AlunoService alunoService;
    private ProvaService provaService;

    @Autowired
    public AlunoProvaController(AlunoProvaService service, AlunoService alunoService, ProvaService provaService) {
        this.service = service;
        this.alunoService = alunoService;
        this.provaService = provaService;
    }

    @RequestMapping(value = {"/alunoprova", "/alunoprova/"}, method = RequestMethod.GET)
    public ModelAndView findAll() throws RetornoApiErro {
        Long idUsuario = getUsuarioAutenticado().getId();
        ModelAndView mv = new ModelAndView();
        mv.setViewName(AlunoProvaConstantes.VIEW_LISTA_ALUNOS_PROVAS);
        mv.addObject("alunos", alunoService.findByIdUsuario(idUsuario));
        mv.addObject("provas", provaService.findByIdUsuario(idUsuario));
        mv.addObject("alunosProvas", service.findByIdUsuario(idUsuario));
        return mv;
    }

    @GetMapping("/alunoprova/add")
    public ModelAndView add(AlunoProva aluno) throws RetornoApiErro {
        Long idUsuario = getUsuarioAutenticado().getId();
        ModelAndView mv = new ModelAndView();
        mv.setViewName(AlunoProvaConstantes.VIEW_CADASTRO_ALUNO_PROVA);
        mv.addObject("alunos", alunoService.findByIdUsuario(idUsuario));
        mv.addObject("provas", provaService.findByIdUsuario(idUsuario));
        mv.addObject("alunoProva", aluno);
        return mv;
    }

    @GetMapping("/alunoprova/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) throws RetornoApiErro {
        return add(service.findOne(id));
    }

    @GetMapping("/alunoprova/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) throws RetornoApiErro {
        service.delete(id);
        return findAll();
    }

    @PostMapping("/alunoprova/save")
    public ModelAndView save(@Valid AlunoProva alunoProva, BindingResult result) throws RetornoApiErro {
        if (result.hasErrors()) {
            return add(alunoProva);
        }
        if (alunoProva.getId() == null && service.findAlunoProvaByIds(alunoProva.getAluno().getId(), alunoProva.getProva().getId()) != null) {
            result.rejectValue("aluno", "error.alunoProva", AlunoProvaConstantes.MSG_ERRO_JA_EXISTE_ASSOCIACAO_ALUNO_PROVA);
        }
        if (result.hasErrors()) {
            return add(alunoProva);
        } else {
            alunoProva.setUsuarioProfessor(getUsuarioAutenticado());
            service.save(alunoProva);
            return findAll();
        }
    }

    @ApiOperation(httpMethod = "GET", value = "Busca as provas de um aluno")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = ErroConstantes.CODIGO_200_DESCRICAO, response = RetornoApi.class),
            @ApiResponse(code = 401, message = ErroConstantes.CODIGO_401_DESCRICAO, response = RetornoApiErro.class),
            @ApiResponse(code = 500, message = ErroConstantes.CODIGO_500_DESCRICAO, response = RetornoApiErro.class)})
    @ResponseBody
    @GetMapping(value = "/alunoprova/find-provas", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RetornoApi findProvasAluno() throws RetornoApiErro {
        validateToken();
        return service.findProvasAluno(userSession);
    }

    @ApiOperation(httpMethod = "GET", value = "Busca as provas de um aluno")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = ErroConstantes.CODIGO_200_DESCRICAO, response = RetornoApi.class),
            @ApiResponse(code = 401, message = ErroConstantes.CODIGO_401_DESCRICAO, response = RetornoApiErro.class),
            @ApiResponse(code = 500, message = ErroConstantes.CODIGO_500_DESCRICAO, response = RetornoApiErro.class)})
    @ResponseBody
    @RequestMapping(value = "/alunoprova/find", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RetornoApi findAllProvasAluno() throws RetornoApiErro {
        validateToken();
        return service.findAllAlunoProvas(userSession);
    }

}
