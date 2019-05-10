package informations;


import java.util.Calendar;
import java.util.Collection;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
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


	// Utilisateur

	public void ajoutUtilisateur(String id, String mdp) throws EntityExistsException {
		em.persist(new Utilisateur(id,mdp));
	}

	public boolean connecterUtilisateur(String id, String mdp) {
		System.out.println("Analyse mdp");
		Utilisateur user = em.find(Utilisateur.class,id);
		if (user!=null && user.mdp.equals(mdp)) {
			System.out.println("Authorized");
			return true;
		}
		System.out.println("Denied");
		return false;
	}


	// Profil

	public void ajoutProfil(String pseudo, String genre, Calendar dateNaissance) {
		em.persist(new Profil(pseudo,genre,dateNaissance));
	}

	public Collection<Profil> listeProfils() {
		TypedQuery<Profil> req = em.createQuery("select p from Profil as p",Profil.class);
		return req.getResultList();
	}

	public Collection<Profil> listeAmis(String idProfil) {
		TypedQuery<Profil> req = em.createQuery("select amis from Profil as p",Profil.class);
		return req.getResultList();
	}


	// Formulaire
	
	public Hastag ajoutHastag(String label){
		Hastag h = new Hastag(label);
		try{
			em.persist(h);
			return h;
		} catch (Exception e){
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
	
}
