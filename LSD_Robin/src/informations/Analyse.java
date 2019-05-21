package informations;
import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class Analyse {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	protected HashMap<String,Integer> Donnees;
	
	public Analyse(){
		Donnees = new HashMap<String,Integer>(); 
	}
	
	
	public void addReponse(Reponse reponse) {
	}
	
	
	public HashMap<String,Integer> getAnalyse(){
		return Donnees;
	}
}
