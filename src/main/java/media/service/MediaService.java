package media.service;

import media.model.Media;
import media.model.Type;

public class MediaService {

	public Media creer(String titre, String auteur, Type type){
		Media m = new Media();
		m.setAuteur(auteur);
		m.setTitre(titre);
		m.setType(type);
		return m;
	}
}
