package informations;

import javax.persistence.Entity;

@Entity
public class AnalyseAge extends Analyse {

	public AnalyseAge() {
		super();
		for (int k = 0 ; k<10; k++) {
			Donnees.put(String.format("%d - %d ans",k*10,(k+1)*10),0);
		}
	}
	
	@Override
	public void addReponse(Reponse reponse) {
		
		int Age =  (int)(Math.random() * (100 + 1)); 
		int ordre = (int) (Math.floor(Age/10)*10);
		
		String cle = String.format("%d - %d ans",ordre,ordre+10);
		Donnees.put(cle,Donnees.get(cle)+1);
	}

}
