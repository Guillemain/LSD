package informations;
import java.util.Collection;
import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Sondage {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String Question;
	private Vector<String> ListePropositions;
	
	//@OneToMany(fetch = FetchType.EAGER)
	//private Collection<Reponse> ListeReponses = new Vector<Reponse>();
	//private Collection<Analyse> ListeAnalyses = new Vector<Analyse>();
	private TypeSondage Type;
	
	
	public Sondage() {
		ListePropositions = new Vector<String>();
	}
	
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	
	public Collection<String> getListePropositions() {
		return ListePropositions;
	}
	public void addListePropositions(String proposition) {
		ListePropositions.add(proposition);
	}
	/*
	public Collection<Reponse> getListeReponses() {
		return ListeReponses;
	}
	public void addListeReponses(Reponse listeReponse) {
		ListeReponses.add(listeReponse);
	}
	*/
	
	public TypeSondage getType() {
		return Type;
	}
	public void setType(TypeSondage type) {
		Type = type;
	}
	
	
	
}
