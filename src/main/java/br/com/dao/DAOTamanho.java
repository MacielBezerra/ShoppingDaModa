package br.com.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.com.conexao.FactoryConnection;
import br.com.entity.Tamanho;

public class DAOTamanho extends FactoryConnection{
	
	@SuppressWarnings("unchecked")
	public List<Tamanho> listarTamanhos(){
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			Query query = em.createNativeQuery("select * from tamanho ", Tamanho.class);
			return query.getResultList();
		} catch (Exception e) {
			 e.getMessage();
		}finally{
			try {
				if(em.isOpen()){
					em.close();
				}
			} catch (Throwable e2) {
				e2.getMessage();
			}
		}
		return null;
	}

}
