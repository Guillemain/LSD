package informations;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Badge {

	@Id
	String nom;
	String description;
	int valeur;

	@ManyToMany(fetch = FetchType.EAGER)
	List<Profil> possesseurs;

	public Badge() {}

	public Badge(String nom, String description, int valeur) {
		this.nom = nom;
		this.description = description;
		this.valeur = valeur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public List<Profil> getPossesseurs() {
		return possesseurs;
	}

	public void setPossesseurs(List<Profil> possesseurs) {
		this.possesseurs = possesseurs;
	}

}
