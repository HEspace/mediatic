package fr.dta.media.service;

import java.util.ArrayList;
import java.util.List;

import fr.dta.adherent.dao.AdherentDAO;
import fr.dta.adherent.model.Adherent;
import fr.dta.media.dao.MediaDAO;
import fr.dta.media.model.Media;
import fr.dta.media.model.Type;

public class MediaService {

	public void creer(Media m){
		MediaDAO mdao = MediaDAO.instance();
		mdao.creer(m);
	}
	
	public List<Adherent> listEmprunteur(Media m){
		MediaDAO mdao = MediaDAO.instance();
		return mdao.listEmprunteur(m);
	}
	

	
	public List<Media> find(String chaine){
		MediaDAO mdao = MediaDAO.instance();
		List<Media> listA = new ArrayList<Media>();
		List<Media> listTmp = new ArrayList<Media>();
		boolean test = false;
		String[] chaineSplit = chaine.split(" ");
		for(String s : chaineSplit){
			listTmp = new ArrayList<Media>();
			listTmp.addAll(mdao.find(s));
			for(Media a1 : listTmp){
				test = false;
				for(Media a2 : listA){
					if(egalites(a1, a2)){
						test=true;
						break;
					}
				}
				if(!test) listA.add(a1);
			}
		}
		return listA;
	}

	
	public Media findID(String chaine){
		MediaDAO mdao = MediaDAO.instance();
		Long id ;
		try{
			id = Long.parseLong(chaine);
			return mdao.findId(id);
		}
		catch(Exception e){
			return mdao.findId(Long.parseLong("0"));
		}
	}
	
	public boolean egalites(Media m1, Media m2){
		return m1.getAuteur().equals(m2.getAuteur()) && m1.getTitre().equals(m2.getTitre()) && m1.getType().equals(m2.getType());
	}
	
	public List<Media> findMediaType(String chaine, Type[] tab){
		if(tab.length == 0 || tab.length == 3)
			return find(chaine);
		MediaDAO mdao = MediaDAO.instance();
		List<Media> listA = new ArrayList<Media>();
		List<Media> listTmp = new ArrayList<Media>();
		boolean test = false;
		String[] chaineSplit = chaine.split(" ");
		for(String s : chaineSplit){
			listTmp = new ArrayList<Media>();
			listTmp.addAll(mdao.findMediaType(s,tab));
			for(Media a1 : listTmp){
				test = false;
				for(Media a2 : listA){
					if(egalites(a1, a2)){
						test=true;
						break;
					}
				}
				if(!test) listA.add(a1);
			}
		}
		return listA;
			
			
	}
	
	public List<Media> listeMediaDVD(){
		MediaDAO mdao = MediaDAO.instance();
		return mdao.listeMediaDVD();
	}
	
	public List<Media> listeMediaCD(){
		MediaDAO mdao = MediaDAO.instance();
		return mdao.listeMediaCD();
	}
	
	public List<Media> listeMediaLivre(){
		MediaDAO mdao = MediaDAO.instance();
		return mdao.listeMediaLivre();
	}
}
