package informations;

import java.util.Date;
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
	Date dateNaissance;

	@ManyToMany(fetch = FetchType.EAGER)
	List<Profil> amis;

	@ManyToMany(fetch = FetchType.EAGER)
	List<Badge> badges;

	@ManyToMany(fetch = FetchType.EAGER)
	List<Formulaire> formulaires;

	public Profil() {}

	public Profil(String nom, String prenom, String genre, Date dateNaissance) {
		this.nom = nom;
		this.prenom = prenom;
		this.genre = genre;
		this.dateNaissance = dateNaissance;
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

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
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
