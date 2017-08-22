package fr.dta.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
	RestAuthenticationSuccessHandler restAuthenticationSuccessHandler;
	@Autowired
	RestAuthenticationFailureHandler restAuthenticationFailureHandler;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
        .inMemoryAuthentication()
        .withUser("User").password("password").roles("USER").and()
        .withUser("Media").password("password").roles("USER", "MEDIA").and()
        .withUser("Husref").password("password").roles("USER", "MEDIA", "ADMIN").and()
        .withUser("Laurent").password("password").roles("USER", "MEDIA", "ADMIN").and()
        .withUser("Hedy").password("password").roles("USER", "MEDIA", "ADMIN");
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
        .antMatchers("/app/**").permitAll()
        .antMatchers("/private/**").permitAll()
        .antMatchers("/login").permitAll()
        .antMatchers("/api/adherent/**").hasRole("ADMIN")
        .antMatchers("/api/media/**").access("hasRole('ROLE_ADMIN') and hasRole('ROLE_MEDIA')")
        .antMatchers("/api/emprunt/**").access("hasRole('ROLE_ADMIN') and hasRole('ROLE_MEDIA') and hasRole('ROLE_USER')")
        //.antMatchers("/api/login").access("hasRole('ROLE_ADMIN') and hasRole('ROLE_MEDIA') and hasRole('ROLE_USER')")
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/app/index.html")
        .loginProcessingUrl("/login")
        .defaultSuccessUrl("/app/index.html")
        .and()
        .logout()
        .permitAll()
        .and()
        .csrf().disable();
    }
}