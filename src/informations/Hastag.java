package informations;
import java.util.Collection;
import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Hastag {
	
	@Id
	private String Nom;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<Formulaire> ListeFormulaires = new Vector<Formulaire>();
	
	
	public Hastag(String label) {
		Nom = label;
	}
	
	public Hastag(){
		
	}
	
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		this.Nom = nom;
	}
	public Collection<Formulaire> getListeFormulaires() {
		return ListeFormulaires;
	}
	public void addListeFormulaires(Formulaire f) {
		ListeFormulaires.add(f);
	}
	
	

}
