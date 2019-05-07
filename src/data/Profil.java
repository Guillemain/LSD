package data;

import java.util.Calendar;
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
	Calendar dateNaissance;

	@ManyToMany(fetch = FetchType.EAGER)
	List<Titre> titres;

	@ManyToMany(fetch = FetchType.EAGER)
	List<Profil> amis;

	public Profil() {}

	public Profil(String nom, String prenom, String genre, Calendar dateNaissance) {
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

	public Calendar getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Calendar dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public List<Titre> getTitres() {
		return titres;
	}

	public void setTitres(List<Titre> titres) {
		this.titres = titres;
	}

	public List<Profil> getAmis() {
		return amis;
	}

	public void setAmis(List<Profil> amis) {
		this.amis = amis;
	}

}
