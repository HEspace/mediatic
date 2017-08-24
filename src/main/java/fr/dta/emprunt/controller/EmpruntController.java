package fr.dta.emprunt.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import fr.dta.emprunt.model.Emprunt;
import fr.dta.emprunt.service.EmpruntService;

@RestController
@RequestMapping("/api/emprunt")
public class EmpruntController {

	@Autowired
	private EmpruntService es;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Emprunt> getAll(){
		return es.getAllEmprunt();
	}
	
	@RequestMapping(value = "media/{idMedia}",method = RequestMethod.GET)
	public List<Emprunt> getEmpruntByMedia(@PathVariable Long idMedia){
		return es.listEmprunteurByMedia(idMedia);
	}
	
	@RequestMapping(value = "adherent/{idAdh}",method = RequestMethod.GET)
	public List<Emprunt> getEmpruntByAdherent(@PathVariable Long idAdh){
		System.out.println(es.listEmpruntByAdherent(idAdh));
		return es.listEmpruntByAdherent(idAdh);
	}

	

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void Create(@RequestBody @Valid Emprunt emprunt, BindingResult br) {
        es.creer(emprunt);
    }
}
