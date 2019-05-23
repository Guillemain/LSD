package informations;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Profil {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String nom;
	String prenom;
	String genre;
	int jourNaissance;
	int moisNaissance;
	int anneeNaissance;

	@ManyToMany(fetch = FetchType.EAGER)
	List<Profil> amis;

	@ManyToMany(fetch = FetchType.EAGER)
	List<Badge> badges;

	@ManyToMany(fetch = FetchType.EAGER)
	List<Formulaire> formulaires;

	public Profil() {}

	public Profil(String nom, String prenom, String genre, int jourNaissance, int moisNaissance, int anneeNaissance) {
		this.nom = nom;
		this.prenom = prenom;
		this.genre = genre;
		this.jourNaissance = jourNaissance;
		this.moisNaissance = moisNaissance;
		this.anneeNaissance = anneeNaissance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getJourNaissance() {
		return jourNaissance;
	}

	public void setJourNaissance(int jourNaissance) {
		this.jourNaissance = jourNaissance;
	}

	public int getMoisNaissance() {
		return moisNaissance;
	}

	public void setMoisNaissance(int moisNaissance) {
		this.moisNaissance = moisNaissance;
	}

	public int getAnneeNaissance() {
		return anneeNaissance;
	}

	public void setAnneeNaissance(int anneeNaissance) {
		this.anneeNaissance = anneeNaissance;
	}

	public List<Profil> getAmis() {
		return amis;
	}

	public void setAmis(List<Profil> amis) {
		this.amis = amis;
	}

	public List<Badge> getBadges() {
		return badges;
	}

	public void setBadges(List<Badge> badges) {
		this.badges = badges;
	}

	public List<Formulaire> getFormulaires() {
		return formulaires;
	}

	public void setFormulaires(List<Formulaire> formulaires) {
		this.formulaires = formulaires;
	}

}
