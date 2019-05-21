package informations;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Reponse {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String choix;
	//private Profil utilisateur;
	@OneToOne
	private Sondage sondage;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getChoix() {
		return choix;
	}
	public void setChoix(String choix) {
		this.choix = choix;
	}
	/*
	public Profil getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Profil utilisateur) {
		this.utilisateur = utilisateur;
	}
	*/
	public Sondage getSondage() {
		return sondage;
	}
	public void setSondage(Sondage sondage) {
		this.sondage = sondage;
	}
	
	
}
