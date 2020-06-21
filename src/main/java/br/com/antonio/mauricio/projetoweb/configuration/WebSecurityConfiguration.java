package br.com.antonio.mauricio.projetoweb.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private DataSource dataSource;

    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;

    private static final String DEFAULT_ACCESS = "hasRole('ADMIN') and hasRole('NORMAL')";

    @Autowired
    public WebSecurityConfiguration(BCryptPasswordEncoder bCryptPasswordEncoder, DataSource dataSource) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().usersByUsernameQuery(usersQuery).authoritiesByUsernameQuery(rolesQuery)
                .dataSource(dataSource).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/registration").permitAll().anyRequest().permitAll()
                .antMatchers("/aluno/**").access(DEFAULT_ACCESS).anyRequest().authenticated()
                .antMatchers("/prova/**").access(DEFAULT_ACCESS).anyRequest().authenticated()
                .antMatchers("/pergunta/**").access(DEFAULT_ACCESS).anyRequest().authenticated()
                .antMatchers("/alunoprova/**").access(DEFAULT_ACCESS).anyRequest().authenticated()
                .antMatchers("/respostausuario/**").access(DEFAULT_ACCESS).anyRequest().authenticated()
                .antMatchers("/favicon.ico").permitAll()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/templates/**").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/img/**").permitAll().anyRequest().permitAll().and().formLogin()
                .loginPage("/login").failureUrl("/login?error=true").defaultSuccessUrl("/dashboard/")
                .usernameParameter("email").passwordParameter("password").and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/").and()
                .exceptionHandling().accessDeniedPage("/login?error=true");
//        http.cors();
        http.csrf().disable();
    }

    // @Override
    // public void configure(WebSecurity web) throws Exception {
    // web
    // .ignoring()
    // .antMatchers("/templates/**", "/static/**", "/css/**", "/js/**", "/img/**");
    // }

//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
//        return source;
//    }

}
