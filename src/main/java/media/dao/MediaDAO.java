package media.dao;

import dao.GenericDAO;
import media.model.Media;

public class MediaDAO extends GenericDAO<Media>{

	private static MediaDAO dao;
	
	private MediaDAO() {
		super(Media.class);
		
	}
	
	public static MediaDAO instance(){
		if(dao == null)
			dao = new MediaDAO();
		return dao;
	}	
	

}
