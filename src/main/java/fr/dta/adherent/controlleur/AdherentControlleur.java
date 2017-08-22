package fr.dta.adherent.controlleur;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import fr.dta.adherent.model.Adherent;
import fr.dta.adherent.service.AdherentService;


@RestController
@RequestMapping("/api/adherent")
public class AdherentControlleur {

@Autowired
private MediaService mediaService;

    @RequestMapping(value="{Nom}", method = RequestMethod.GET)
    @ResponseBody
    public AdherentService findByNom(@PathVariable Strind nom){
        return mediaService.findByNom(nom);
    }

    @RequestMapping(value="{Prenom}", method = RequestMethod.GET)
    @ResponseBody
    public AdherentService findByPrenom(@PathVariable Strind prenom){
        return mediaService.findByPrenom(prenom);
    }

    @RequestMapping(value="{id}", method = RequestMethod.GET)
    @ResponseBody
    public AdherentService findById(@PathVariable Long id){
        return mediaService.findById(id);
    }


}
