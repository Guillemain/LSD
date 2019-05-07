package informations;


import java.util.Calendar;
import java.util.Collection;
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
	
	/*
	public void ajoutCompte(){
		Comptes c = new Comptes();
		em.persist(c);
	}
	*/
	
	public Hastag ajoutHastag(String label){
		
		Hastag h = new Hastag(label);
		try{
			em.persist(h);
			return h;
		}
		catch (Exception e){
			System.out.println("ce hashtag exite deja");
			return em.find(Hastag.class, label);
			
		}
		
	}
	
	
	public void ajoutFormulaire(Formulaire f){
		em.persist(f);
	}
	
	public void ajoutSondage(Sondage s){
		em.persist(s);
	}
	/*
	public void associer(int personneId, int adresseId){
		Personne p = em.find(Personne.class, personneId);
		Collection<Adresse> ads = p.getAdresses();
		ads.add(em.find(Adresse.class, adresseId));
		p.setAdresses(ads);
	}
	
	public Collection<Personne> listePersonne() {
		TypedQuery<Personne> lp = em.createQuery("select p from Personne as p",Personne.class);
		return lp.getResultList();
	}
	*/
	public Collection<Formulaire> getlisteFormulaires() {
		TypedQuery<Formulaire> lf = em.createQuery("select f from Formulaire as f",Formulaire.class);
		return lf.getResultList();
	
	}

	public Formulaire trouverFormulaire(String id) {
		return em.find(Formulaire.class, Integer.parseInt(id));
	}
	
	public Hastag getHastag(String label){
		return em.find(Hastag.class, label);
	}
	
	public void ajoutUtilisateur(String id, String mdp) {
		try {
			em.persist(new Utilisateur(id,mdp));
		} catch (Exception e) {
			System.out.println("Ce nom est déjà pris ! :/");
		}
	}

	public void ajoutProfil(String nom, String prenom, String genre, Calendar dateNaissance) {
		em.persist(new Profil(nom,prenom,genre,dateNaissance));
	}

	public Collection<Profil> listeProfils() {
		TypedQuery<Profil> req = em.createQuery("select p from Profil as p",Profil.class);
		return req.getResultList();
	}

	public Collection<Profil> listeAmis(String idProfil) {
		TypedQuery<Profil> req = em.createQuery("select amis from Profil as p",Profil.class);
		return req.getResultList();
	}

	
}
