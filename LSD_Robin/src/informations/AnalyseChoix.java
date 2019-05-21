package informations;

import javax.persistence.Entity;

@Entity
public class AnalyseChoix extends Analyse {

	
	public AnalyseChoix(){
		super();
	}
	
	@Override
	public void addReponse(Reponse reponse) {
		
		String choix = reponse.getChoix();
		System.out.println(choix);
		
		if (Donnees.containsKey(choix)) {
			Donnees.put(choix,Donnees.get(choix)+1);
		}
		else {
			Donnees.put(choix,1);
		}

	}

}
