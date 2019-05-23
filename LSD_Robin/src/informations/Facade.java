package informations;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import LDAPContact.*; // notre package de Connexion au LDAP
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
		if(INPTAccount.detientUnCompte(id, mdp)){
			em.persist(new Utilisateur(id,mdp));
		}else{
			throw new NonMembreINPT();
		}
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
		if (!validDate(jour,mois,annee)) {
			throw new Exception();
		}
		em.persist(new Profil(nom,prenom,genre,jour,mois,annee));
	}

	public boolean validDate(int jour, int mois, int annee) {
		if ((mois == 2) && ((jour>29) || (!estBisextile(annee) && jour>28))){
			return false;
		}
		if (jour==31 && ((mois<=7 && mois%2==0) || (mois>=8 && mois%2==1))) {
			return false;
		}
		return true;
	}

	public boolean estBisextile(int annee) {
		if (annee%400==0 || (annee%4==0 && annee%100!=0)) {
			return true;
		} else {
			return false;
		}
	}

	public Profil getProfil(int idProfil) {
		return em.find((Profil.class),idProfil);
	}

	/**  */
	public int computeAge(int jourNaissance, int moisNaissance, int anneeNaissance) {
		LocalDateTime currentDate = LocalDateTime.now();
		int age = currentDate.getYear() - anneeNaissance;
		if ((currentDate.getMonth().getValue()-moisNaissance<0) || ((currentDate.getMonth().getValue()==moisNaissance) && (currentDate.getDayOfMonth()-jourNaissance<0))){
			age--;
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

	public void rendreAmis(int idProfil1,int idProfil2) throws Exception {
		Profil p1 = em.find(Profil.class, idProfil1);
		Profil p2 = em.find(Profil.class, idProfil2);
		if (p1 != null && p2 != null) {
			p1.getAmis().add(p2);
		} else {
			throw new Exception();
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
