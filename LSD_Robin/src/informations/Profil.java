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

	String pseudo;
	String genre;
	Date dateNaissance;

	@ManyToMany(fetch = FetchType.EAGER)
	List<Profil> amis;

	@ManyToMany(fetch = FetchType.EAGER)
	List<Badge> badges;

	@ManyToMany(fetch = FetchType.EAGER)
	List<Sondage> sondages;

	public Profil() {}

	public Profil(String pseudo, String genre, Date dateNaissance) {
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

	public List<Sondage> getSondages() {
		return sondages;
	}

	public void setSondages(List<Sondage> sondages) {
		this.sondages = sondages;
	}

}
