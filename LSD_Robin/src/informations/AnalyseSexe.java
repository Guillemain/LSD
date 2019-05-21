package informations;

import javax.persistence.Entity;

@Entity
public class AnalyseSexe extends Analyse {

	
	public AnalyseSexe(){
		super();
		Donnees.put("m",0);
		Donnees.put("f",0);
		Donnees.put("a",0);
		
	}
	
	@Override
	public void addReponse(Reponse reponse) {
		//String sexe = reponse.getProfil.getSexe();
		String sexe = "";
		switch (sexe){
			
		case "m" :
			Donnees.put("m", Donnees.get("m")+1);
			break;
			
		case "f" :
			Donnees.put("m", Donnees.get("f")+1);
			break;
			
		case "a" :
			Donnees.put("m", Donnees.get("a")+1);
			break;
			
		default :
			break;
		}
	}
}
