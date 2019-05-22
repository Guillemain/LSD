package informations;

import java.time.YearMonth;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
/**
 * Session Bean implementation class Facade
 */
@Stateless
@LocalBean
public class Facade {

	//private Collection<Formulaire> listeFormulaires = new Vector<Formulaire>();
	//private HashMap<String,Hastag> listeHastags = new HashMap<String,Hastag>();
	
	@PersistenceContext
	private EntityManager em;

	public Hastag ajoutHastag(String label){
		
		Hastag h =  new Hastag(label);
		em.persist(h);
		System.out.println("ajout de l'hastag a la bdd");
		return h;	
	}

	public void ajoutReponse(Reponse r){
		em.persist(r);
	}
	
	public void ajoutFormulaire(Formulaire f){
		em.persist(f);
		//System.out.println(f);
	}
	
	public void ajoutSondage(Sondage s){
		em.persist(s);
	}
	
	public Collection<Formulaire> getlisteFormulaires() {
		TypedQuery<Formulaire> lf = em.createQuery("select f from Formulaire as f",Formulaire.class);
		return lf.getResultList();
	
	}

	public Formulaire trouverFormulaire(String id) {
		return em.find(Formulaire.class, Integer.parseInt(id));
	}
	
	public Hastag getHastag(String label){
		try{
			return em.find(Hastag.class, label);
		}catch (Exception e){
			System.out.println("ce hashtag n'exite pas (get)");
			return null;
		}
	}
	
	//// GREGOIRE ////
	/** Gregoire nouvelle version */
	public void ajoutUtilisateur(String id, String mdp) throws Exception {
		if (id.equals("") || mdp.equals("")) {
			throw new EmptyFieldException();
		}
		em.persist(new Utilisateur(id,mdp));
	}

	/** Connexion d'un utilisateur */
	public boolean connecterUtilisateur(String id, String mdp) {
		Utilisateur user = em.find(Utilisateur.class,id);
		if (user!=null && user.mdp.equals(mdp)) {
			return true;
		}
		return false;
	}

	public void ajoutProfil(String nom, String prenom, String genre, int jour, int mois, int annee) throws Exception {
		if (nom.equals("") || prenom.equals("")) {
			throw new EmptyFieldException();
		}
		if (jour > YearMonth.of(annee,mois).lengthOfMonth()) {
			throw new Exception();
		}
		Calendar dateNaissance = Calendar.getInstance();
	    dateNaissance.set(annee, mois, jour);
		em.persist(new Profil(nom,prenom,genre,dateNaissance.getTime()));
	}

	public Profil getProfil(int idProfil) {
		return em.find((Profil.class),idProfil);
	}

	/**  */
	@SuppressWarnings("deprecation")
	public int computeAge(Date birthDate) {
		Date currentDate = new Date();
		int age = birthDate.getYear() - currentDate.getYear();
		if (birthDate.getMonth()>currentDate.getMonth()) {
			age--;
		} else if (birthDate.getMonth()==currentDate.getMonth() && birthDate.getDay()>currentDate.getDay()) {
			age--;
		}
		if (age<0) {
			age = 0;
		}
		return age;
	}

	/** */
	public int computeScore(Collection<Badge> listeBadges) {
		int score = 0;
		for (Badge badge : listeBadges) {
			score += badge.getValeur();
		}
		return score;
	}

	public void rendreAmis(int idProfil1,int idProfil2) {
		Profil p1 = em.find(Profil.class, idProfil1);
		Profil p2 = em.find(Profil.class, idProfil2);
		if (p1 != null && p2 != null) {
			p1.getAmis().add(p2);
		}
	}

	public void update(Object o) {
		
		em.merge(o);
	}

	public void ajoutAnalyse(Analyse a) {
		em.persist(a);
		
	}

	public Collection<Formulaire> getFormulairesSortByDates() {
		TypedQuery<Formulaire> lf = em.createQuery("select f from Formulaire as f order by f.date desc",Formulaire.class);
		return lf.getResultList();
	}

}
