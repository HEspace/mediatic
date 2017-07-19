package media.service;

import media.dao.MediaDAO;
import media.model.Media;

public class MediaService {

	public void creer(Media m){
		MediaDAO mdao = MediaDAO.instance();
		mdao.creer(m);
	}
}
