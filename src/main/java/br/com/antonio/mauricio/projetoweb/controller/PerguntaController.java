package br.com.antonio.mauricio.projetoweb.controller;

import br.com.antonio.mauricio.projetoweb.model.Pergunta;
import br.com.antonio.mauricio.projetoweb.response.RetornoApi;
import br.com.antonio.mauricio.projetoweb.response.RetornoApiErro;
import br.com.antonio.mauricio.projetoweb.service.PerguntaService;
import br.com.antonio.mauricio.projetoweb.service.ProvaService;
import br.com.antonio.mauricio.projetoweb.utils.ErroConstantes;
import br.com.antonio.mauricio.projetoweb.utils.PerguntaConstantes;
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

@Api(tags = "pergunta")
@RestController
@Controller("/pergunta")
public class PerguntaController extends GenericController {

    private PerguntaService service;
    private ProvaService provaService;

    @Autowired
    public PerguntaController(PerguntaService service, ProvaService provaService) {
        this.service = service;
        this.provaService = provaService;
    }

    @GetMapping(value = {"/pergunta", "/pergunta/"})
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(PerguntaConstantes.VIEW_LISTA_PERGUNTAS);
        mv.addObject("perguntas", service.findAll());
        return mv;
    }

    @GetMapping(value = {"/perguntas/{idProva}"})
    public ModelAndView findByIdProva(@PathVariable("idProva") Long idProva) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(PerguntaConstantes.VIEW_LISTA_PERGUNTAS);
        mv.addObject("idProva", idProva);
        mv.addObject("perguntas", service.findByIdProva(idProva));
        return mv;
    }

    @GetMapping("/pergunta/add/{idProva}")
    public ModelAndView add(Pergunta pergunta, @PathVariable("idProva") Long idProva) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(PerguntaConstantes.VIEW_CADASTRO_PERGUNTA);
        pergunta.setProva(provaService.findOne(idProva));
        mv.addObject("pergunta", pergunta);
        return mv;
    }

    @GetMapping("/pergunta/add")
    public ModelAndView add(Pergunta pergunta) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(PerguntaConstantes.VIEW_CADASTRO_PERGUNTA);
        mv.addObject("pergunta", pergunta);
        return mv;
    }

    @GetMapping("/pergunta/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        return add(service.findOne(id));
    }

    @GetMapping("/pergunta/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        Pergunta pergunta = service.findOne(id);
        service.delete(id);
        return findByIdProva(pergunta.getProva().getId());
    }

    @PostMapping(value = "/pergunta/save")
    public ModelAndView save(@Valid Pergunta pergunta, BindingResult result) {
        if (result.hasErrors()) {
            return add(pergunta);
        }
        service.save(pergunta);
        return findByIdProva(pergunta.getProva().getId());
    }

    @ApiOperation(httpMethod = "GET", value = "Busca as perguntas de uma prova")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = ErroConstantes.CODIGO_200_DESCRICAO, response = RetornoApi.class),
            @ApiResponse(code = 401, message = ErroConstantes.CODIGO_401_DESCRICAO, response = RetornoApiErro.class),
            @ApiResponse(code = 500, message = ErroConstantes.CODIGO_500_DESCRICAO, response = RetornoApiErro.class)})
    @ResponseBody
    @GetMapping(value = "/pergunta/{idProva}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RetornoApi findPerguntasProva(@PathVariable(value = "idProva", required = true) Long idProva) throws RetornoApiErro {
        validateToken();
        return service.findByIdProva(idProva, userSession);
    }

}
