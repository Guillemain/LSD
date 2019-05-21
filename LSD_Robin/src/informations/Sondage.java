package informations;
import java.util.Collection;
import java.util.List;
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
	
	@OneToMany(fetch = FetchType.EAGER)
	private Collection<Reponse> ListeReponses;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Analyse> ListeAnalyses;
	
	private TypeSondage Type;
	
	
	public Sondage() {
		ListePropositions = new Vector<String>();
	}
	
	public int getId() {
		return id;
	}

	public List<Analyse> getListeAnalyses() {
		return ListeAnalyses;
	}

	public void setListeAnalyses(List<Analyse> listeAnalyses) {
		ListeAnalyses = listeAnalyses;
	}
	
	public void addListeAnalyses(Analyse analyse){
		ListeAnalyses.add(analyse);
	}
	
	public void majAnalyses(Reponse reponse){
		for (Analyse a : ListeAnalyses){
			a.addReponse(reponse);
		}
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
	
	public Collection<Reponse> getListeReponses() {
		return ListeReponses;
	}
	public void addListeReponses(Reponse reponse) {
		ListeReponses.add(reponse);
		majAnalyses(reponse);
	}
	
	public void setListeReponses(Collection<Reponse> listeReponses) {
		ListeReponses = listeReponses;
	}

	public TypeSondage getType() {
		return Type;
	}
	public void setType(TypeSondage type) {
		Type = type;
	}
	
	
	
}
