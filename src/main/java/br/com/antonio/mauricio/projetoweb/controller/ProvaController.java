package br.com.antonio.mauricio.projetoweb.controller;

import br.com.antonio.mauricio.projetoweb.model.Prova;
import br.com.antonio.mauricio.projetoweb.response.RetornoApiErro;
import br.com.antonio.mauricio.projetoweb.service.ProvaService;
import br.com.antonio.mauricio.projetoweb.utils.ProvaConstantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller("/prova")
public class ProvaController extends GenericController {

    private ProvaService service;

    @Autowired
    public ProvaController(ProvaService service) {
        this.service = service;
    }

    @GetMapping(value = {"/prova", "/prova/"})
    public ModelAndView findAll() throws RetornoApiErro {
        Long idUsuario = getUsuarioAutenticado().getId();
        ModelAndView mv = new ModelAndView();
        mv.setViewName(ProvaConstantes.VIEW_LISTA_PROVA);
        mv.addObject("provas", service.findByIdUsuario(idUsuario));
        return mv;
    }

    @GetMapping("/prova/add")
    public ModelAndView add(Prova prova) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(ProvaConstantes.VIEW_CADASTRO_PROVA);
        mv.addObject("prova", prova);
        return mv;
    }

    @GetMapping("/prova/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        return add(service.findOne(id));
    }

    @GetMapping("/prova/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) throws RetornoApiErro {
        service.delete(id);
        return findAll();
    }

    @PostMapping("/prova/save")
    public ModelAndView save(@Valid Prova prova, BindingResult result) throws RetornoApiErro {
        if (result.hasErrors()) {
            return add(prova);
        }
        prova.setUsuario(getUsuarioAutenticado());
        service.save(prova);
        return findAll();
    }

}
