package informations;

public class Reponse {

	private String choix;
	private Profil utilisateur;
	private Sondage sondage;
	
	
	public String getChoix() {
		return choix;
	}
	public void setChoix(String choix) {
		this.choix = choix;
	}
	public Profil getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Profil utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Sondage getSondage() {
		return sondage;
	}
	public void setSondage(Sondage sondage) {
		this.sondage = sondage;
	}
	
	
}
