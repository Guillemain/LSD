package informations;

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

	String pseudo;
	String genre;
	Calendar dateNaissance;

	//@ManyToMany(fetch = FetchType.EAGER)
	//List<Titre> titres;

	@ManyToMany(fetch = FetchType.EAGER)
	List<Profil> amis;

	public Profil() {}

	public Profil(String pseudo, String genre, Calendar dateNaissance) {
		this.pseudo = pseudo;
		this.genre = genre;
		this.dateNaissance = dateNaissance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
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

	public List<Profil> getAmis() {
		return amis;
	}

	public void setAmis(List<Profil> amis) {
		this.amis = amis;
	}

}
