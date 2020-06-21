package br.com.antonio.mauricio.projetoweb.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.HttpEncodingProperties;
import org.springframework.boot.web.filter.OrderedCharacterEncodingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

@Configuration
public class ThymeleafConfig {

    private final String CHAR_ENCODING = "ISO-8859-1";

    private HttpEncodingProperties httpEncodingProperties;

    @Autowired
    public ThymeleafConfig(HttpEncodingProperties httpEncodingProperties) {
        this.httpEncodingProperties = httpEncodingProperties;
    }

    @Bean
    public TemplateResolver templateResolver() {
        TemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setCacheable(false);
        templateResolver.setPrefix("templates/");
        templateResolver.setSuffix(".jsp");
        templateResolver.setCharacterEncoding(CHAR_ENCODING);
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        springTemplateEngine.addTemplateResolver(templateResolver());
        return springTemplateEngine;
    }

    @Bean
    public OrderedCharacterEncodingFilter characterEncodingFilter() {
        OrderedCharacterEncodingFilter filter = new OrderedCharacterEncodingFilter();
        filter.setEncoding(CHAR_ENCODING);
        filter.setForceEncoding(this.httpEncodingProperties.isForce());
        filter.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return filter;
    }

    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setOrder(1);
        viewResolver.setCharacterEncoding(CHAR_ENCODING);
        return viewResolver;
    }

}
