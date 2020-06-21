package br.com.antonio.mauricio.projetoweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableAutoConfiguration
@SpringBootApplication
@EnableConfigurationProperties
public class ProjetoWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoWebApplication.class, args);
	}

//	@Bean
//	public ViewResolver viewResolver() {
//		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
//		templateResolver.setTemplateMode("XHTML");
//		templateResolver.setPrefix("templates/");
//		templateResolver.setSuffix(".html");
//
//		SpringTemplateEngine engine = new SpringTemplateEngine();
//		engine.setTemplateResolver(templateResolver);
//
//		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//		viewResolver.setTemplateEngine(engine);
//		return viewResolver;
//	}
}
