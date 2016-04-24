package br.com.conexao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Maciel B
 *
 */
public class FactoryConnection {

	private static final EntityManagerFactory factory = 
			Persistence.createEntityManagerFactory("locadora");

	public static EntityManager getEntityManager(){
		return factory.createEntityManager();
	} 

}
