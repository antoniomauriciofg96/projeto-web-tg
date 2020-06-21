package br.com.antonio.mauricio.projetoweb.swagger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SwaggerController {

	@RequestMapping("/documentation")
	public String swagger() {
		return "redirect:/swagger-ui.html";
	}

}
