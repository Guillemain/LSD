package informations;
import java.util.List;
import java.util.Vector;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sondage {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String Question;
	private Vector<String> ListePropositions;
	
	//@OneToMany(fetch = FetchType.EAGER)
	//private List<Reponse> ListeReponses = new List<Reponse>();
	//private List<Analyse> ListeAnalyses = new List<Analyse>();
	private TypeSondage Type;
	
	
	public Sondage() {
		ListePropositions = new Vector<String>();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setListePropositions(Vector<String> listePropositions) {
		ListePropositions = listePropositions;
	}

	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	
	public List<String> getListePropositions() {
		return ListePropositions;
	}
	public void addListePropositions(String proposition) {
		ListePropositions.add(proposition);
	}
	/*
	public List<Reponse> getListeReponses() {
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
