package br.com.antonio.mauricio.projetoweb.controller;

import br.com.antonio.mauricio.projetoweb.model.Aluno;
import br.com.antonio.mauricio.projetoweb.model.Prova;
import br.com.antonio.mauricio.projetoweb.model.Role;
import br.com.antonio.mauricio.projetoweb.model.User;
import br.com.antonio.mauricio.projetoweb.repository.RoleRepository;
import br.com.antonio.mauricio.projetoweb.response.RetornoApiErro;
import br.com.antonio.mauricio.projetoweb.service.AlunoService;
import br.com.antonio.mauricio.projetoweb.service.ProvaService;
import br.com.antonio.mauricio.projetoweb.service.UserService;
import br.com.antonio.mauricio.projetoweb.utils.LoginConstantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Controller
public class LoginController extends GenericController {

    private RoleRepository roleRepository;
    private UserService userService;
    private ProvaService provaService;
    private AlunoService alunoService;

    @Autowired
    public LoginController(RoleRepository roleRepository, UserService userService, ProvaService provaService, AlunoService alunoService) {
        this.roleRepository = roleRepository;
        this.userService = userService;
        this.provaService = provaService;
        this.alunoService = alunoService;
    }

    @GetMapping(value = {"dashboard"})
    public ModelAndView dashboard() throws RetornoApiErro {
        ModelAndView modelAndView = new ModelAndView();
        Long idUsuario = getUsuarioAutenticado().getId();
        List<Prova> provas = provaService.findByIdUsuario(idUsuario);
        List<Aluno> alunos = alunoService.findByIdUsuario(idUsuario);
        modelAndView.addObject("totalProvas", provas != null ? provas.size() : 0);
        modelAndView.addObject("totalAlunos", alunos != null ? alunos.size() : 0);
        modelAndView.setViewName(LoginConstantes.VIEW_DASHBOARD);
        return modelAndView;
    }

    @GetMapping(value = {"", "login"})
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(LoginConstantes.VIEW_LOGIN);
        return modelAndView;
    }

    @GetMapping(value = "registration")
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        Role userRole = roleRepository.findByRole("NORMAL");
        User user = new User(new HashSet<Role>(Collections.singletonList(userRole)));
        modelAndView.addObject("user", user);
        modelAndView.setViewName(LoginConstantes.VIEW_REGISTRO);
        return modelAndView;
    }

    @PostMapping(value = "registration")
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (userService.findUserByEmail(user.getEmail()) != null) {
            bindingResult.rejectValue("email", "error.user", LoginConstantes.MSG_ERRO_JA_EXISTE_EMAIL_USUARIO);
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName(LoginConstantes.VIEW_REGISTRO);
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", LoginConstantes.MSG_SUCESSO_CADASTRO_USUARIO);
            modelAndView.addObject("user", new User());
            modelAndView.setViewName(LoginConstantes.VIEW_LOGIN);
        }
        return modelAndView;
    }

}
