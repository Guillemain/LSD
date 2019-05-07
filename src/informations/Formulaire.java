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

import java.util.Calendar;

@Entity
public class Formulaire {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String Nom;
	
	private Calendar date; 
	
	@OneToMany(fetch = FetchType.EAGER)
	private Collection<Sondage> ListeSondages = new Vector<Sondage>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<Hastag> ListeHastags = new Vector<Hastag>();
	
	private boolean privee;
	//private Collection<Progil> Visiteurs;
	//private Comptes Createur;
	
	
	public Formulaire(String nom, boolean type) {
		Nom = nom;
		privee = type;
		date = Calendar.getInstance();
	}
	
	public Formulaire(){
		
	}
	
	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}
	
	public Collection<Sondage> getListeSondages() {
		return ListeSondages;
	}
	public void addListeSondages(Sondage sondage) {
		ListeSondages.add(sondage);
	}
	
	public Collection<Hastag> getListeHastags() {
		return ListeHastags;
	}
	public void addListeHastags(Hastag hastag) {
		ListeHastags.add(hastag);
	}
	
	public boolean isPrivee() {
		return privee;
	}
	public void setPrivee(boolean privee) {
		this.privee = privee;
	}
	
	public Calendar getDate(){
		return date;
	}
	
	public int getId(){
		return id;
	}
	/*
	public Collection<Comptes> getVisiteurs() {
		return Visiteurs;
	}
	public void addVisiteurs(Comptes visiteur) {
		Visiteurs.add(visiteur);
	}
	public Comptes getCreateur() {
		return Createur;
	}
	public void setCreateur(Comptes createur) {
		Createur = createur;
	}
	*/
	
	
	
}
