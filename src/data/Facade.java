package data;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.Calendar;
import java.util.Collection;

@Singleton
public class Facade {

	@PersistenceContext
	private EntityManager em;


	public Facade() {}

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
