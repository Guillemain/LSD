package informations;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Hastag {
	
	@Id
	private String Nom;

	@ManyToMany(mappedBy = "ListeHastags", fetch = FetchType.EAGER)
	private Collection<Formulaire> ListeFormulaires;
	
	
	public void setListeFormulaires(Collection<Formulaire> CollectioneFormulaires) {
		ListeFormulaires = CollectioneFormulaires;
	}

	public Hastag(String label) {
		Nom = label;
		//CollectioneFormulaires = new Vector<Formulaire>();
	}
	
	public Hastag(){
		//CollectioneFormulaires = new Vector<Formulaire>();
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
		System.out.println(f);
		ListeFormulaires.add(f);
	}
	
	

}
