package fr.dta.media.controlleur;

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
import org.springframework.security.access.prepost.PreAuthorize;

import fr.dta.media.model.Media;
import fr.dta.media.model.Type;
import fr.dta.media.service.MediaService;



@RestController
@RequestMapping("/api/media")
public class MediaControlleur {

    @Autowired
    MediaService ms;

    @RequestMapping(value ="/find/{id}",  method = RequestMethod.GET)
    public Media findById(@PathVariable Long id){
        return ms.findID(id);
    }
    
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public List<Media> getAll(){
    	return ms.getAll();
    }

    

    @RequestMapping(value ="/type/dvd",  method = RequestMethod.GET)
    public List<Media> findByDVD(){
        return ms.listeMediaDVD();
    }

    @RequestMapping(value ="/type/livre",  method = RequestMethod.GET)
    public List<Media> findByLIVRE(){
        return ms.listeMediaLivre();
    }

    @RequestMapping(value ="/type/cd",  method = RequestMethod.GET)
    public List<Media> findByCD(){
        return ms.listeMediaCD();
    }

    

    @RequestMapping(value ="/find/{chaine}",  method = RequestMethod.GET)
    public List<Media> findByCD(@PathVariable String chaine){
        return ms.find(chaine);
    }

    @RequestMapping(value ="/find/{chaine}/{tab}",  method = RequestMethod.GET)
    public List<Media> findByCD(@PathVariable String chaine, @PathVariable Type tab){
        System.out.println(tab);
        Type t[] = {tab};
        return ms.findMediaType(chaine, t);
    }

    @RequestMapping(value ="/find/{chaine}/{tab}/{tab2}",  method = RequestMethod.GET)
    public List<Media> findByCD(@PathVariable String chaine, @PathVariable Type tab,  @PathVariable Type tab2){
        Type t[] = {tab,tab2};
        return ms.findMediaType(chaine, t);
    }

    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void Create(@RequestBody @Valid Media m, BindingResult br) {
        ms.creer(m);
    }

}