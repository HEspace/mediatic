package fr.dta.adherent.controlleur;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import fr.dta.adherent.model.Adherent;
import fr.dta.adherent.repository.AdherentRepository;
import fr.dta.adherent.service.AdherentService;
import fr.dta.media.model.Media;
import fr.dta.media.model.Type;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;


@RestController
@RequestMapping("/api/adherent")
public class AdherentControlleur {

@Autowired
AdherentService adherentService;


@RequestMapping(value = "/find", method = RequestMethod.GET)
public List<Adherent> getAll(){
	return adherentService.getAllAdherent();
   
}


// par Id
    @RequestMapping(value="/find/id/{id}", method = RequestMethod.GET)
    public List<Adherent> findById(@PathVariable Long id){
		return adherentService.findID(id);
       
    }

    @RequestMapping(value="/findOne/id/{id}", method = RequestMethod.GET)
    public Adherent findByOneId(@PathVariable Long id){
		return adherentService.findOne(id);
       
    }

// par Nom et Prenom
    @RequestMapping(value ="/find/chaine/{chaine}",  method = RequestMethod.GET)
    public List<Adherent> findAdherentNomPrenom(@PathVariable String chaine){
        return adherentService.find(chaine);
    }
    
//    @RequestMapping(value ="/find/chaine/{chaine}/{tab}",  method = RequestMethod.GET)
//    public List<Media> findByCD(@PathVariable String chaine, @PathVariable Type tab){
//        Type t[] = {tab};
//        return adherentService.findAdhType(chaine, t);
//    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void Create(@RequestBody @Valid Adherent adherent, BindingResult br) { 
        adherentService.creer(adherent);
    }


}

