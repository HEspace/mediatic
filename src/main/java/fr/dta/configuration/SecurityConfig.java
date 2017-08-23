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
        .antMatchers("/api/adherent/find/**").permitAll()
        .antMatchers("/api/media/find/**").permitAll()
        .antMatchers("/api/media/type/**").permitAll()
        .antMatchers("/api/emprunt/find/**").permitAll()
        .antMatchers("/api/media/create/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MEDIA')")
        .antMatchers("/api/adherent/create/**").access("hasRole('ROLE_ADMIN')")

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