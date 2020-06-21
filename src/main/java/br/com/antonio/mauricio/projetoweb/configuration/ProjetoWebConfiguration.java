package br.com.antonio.mauricio.projetoweb.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "br.com.antonio.mauricio.projetoweb")
public class ProjetoWebConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("Dashboard");
	    registry.addViewController("/login").setViewName("Login");
	    registry.addViewController("/registration").setViewName("Registration");
	    registry.addViewController("/aluno").setViewName("Aluno");
	    registry.addViewController("/aluno/add").setViewName("AlunoAdd");
	    registry.addViewController("/alunoprova").setViewName("AlunoProva");
	    registry.addViewController("/alunoprova/add").setViewName("AlunoProvaAdd");
	    registry.addViewController("/pergunta").setViewName("Pergunta");
	    registry.addViewController("/pergunta/add").setViewName("PerguntaAdd");
	    registry.addViewController("/prova").setViewName("Prova");
	    registry.addViewController("/prova/add").setViewName("ProvaAdd");
	    registry.addViewController("/respostausuario").setViewName("RespostaUsuario");
	}


}
