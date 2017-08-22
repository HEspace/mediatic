package fr.dta.emprunt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.dta.emprunt.model.Emprunt;
import fr.dta.emprunt.service.EmpruntService;

@Controller
@RequestMapping("/api/emprunt")
public class EmpruntController {

	@Autowired
	private EmpruntService es;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Emprunt> getAll(){
		return es.getAllEmprunt();
	}
	
	@RequestMapping(value = "{idMedia}",method = RequestMethod.GET)
	public List<Emprunt> getEmpruntByMedia(@PathVariable int idMedia){
		return es.listEmprunteurByMedia(idMedia);
	}
	
	@RequestMapping(value = "{idAdh}",method = RequestMethod.GET)
	public List<Emprunt> getEmpruntByAdherent(@PathVariable int idAdh){
		return es.listEmpruntByAdherent(idAdh);
	}
}
