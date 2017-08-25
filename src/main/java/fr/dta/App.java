package fr.dta;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;

import fr.dta.adherent.model.Adherent;
import fr.dta.adherent.service.AdherentService;
import fr.dta.emprunt.service.EmpruntService;
import fr.dta.media.model.Media;
import fr.dta.media.model.Type;
import fr.dta.media.service.MediaService;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class App extends SpringBootServletInitializer {

	private static Class appClass = App.class;

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(appClass);
    }


	public static void main(String args[]){
		SpringApplication.run(App.class, args);
		
	}
}
