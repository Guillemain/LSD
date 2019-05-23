package LDAPContact;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Scanner;
/**
 * Classe permettant la gestion des identifiant des comptes de l'inpt
 * 
 */
	public class INPTAccount {
		static String url = "ldap://ldap.enseeiht.fr:389";
		static String securite = "simple"; // Pas bon ça.
	/**	
	 * @param compte Le compte de l'INPT
	 * @param motDePasse Le mot de passe associé au compte
	 * @return true : l'utilisateur detient un compte. faux, les informations de connexion sont érronées.
	 */
	public static boolean detientUnCompte(String compte,String motDePasse) {
		try {
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, url);
		/* j'imagie ici qu'il me faudra passer en ssl ? */
		env.put(Context.SECURITY_AUTHENTICATION, securite);
		env.put(Context.SECURITY_PRINCIPAL, "uid="+compte+",ou=people,dc=n7,dc=fr");
		env.put(Context.SECURITY_CREDENTIALS,motDePasse);
		//System.out.println("Connexion en cours...");
		DirContext ctx = new InitialDirContext(env);
		//System.out.println("ConnexionReussie");
		return true;
		}
		catch (Exception e) {
			//Il y a une erreur dans la connexion. 
			return false;
		}
	}
	
}