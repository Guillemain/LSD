package data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Utilisateur {

	@Id
	String id;

	String mdp;

	@OneToOne(fetch = FetchType.EAGER)
	Profil profil;

	public Utilisateur() {}

	public Utilisateur(String id, String mdp) {
		this.id = id;
		this.mdp = mdp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}	

}
