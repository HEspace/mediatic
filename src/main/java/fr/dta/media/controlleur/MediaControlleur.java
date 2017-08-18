package fr.dta.media.controlleur;

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

import fr.dta.media.model.Media;
import fr.dta.media.service.MediaService;



@RestController
@RequestMapping("/api/users")
public class MediaControlleur {

    @Autowired
    MediaService ms;

    @RequestMapping(value ="{id}",  method = RequestMethod.GET)
    public Media findById(@PathVariable Long id){
        return ms.findID(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void Create(@RequestBody Media m, BindingResult br) {
        ms.creer(m);
    }

}