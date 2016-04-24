package br.com.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.com.entity.Cliente;
import br.com.excecao.GenericException;
import br.com.excecao.GenericThrowable;
import br.com.messages.Config;
/**
 * @author Maciel B
 *
 * @param <T>
 */
public class DAOCliente<T> extends DAOAbstract<Cliente>{
	
	
	@Override
	public Cliente buscar(Integer codigo) throws GenericException, GenericThrowable{
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			Query filtro = em.createQuery("Select c from Cliente c where cod_cliente like :codigo");
			filtro.setParameter("codigo",codigo);
			return (Cliente)filtro.getSingleResult();
		} catch (Exception e) {
			throw new GenericException(Config.getString("erro.pesquisar.cliente") + e.getMessage());
		}finally{
			try {
				if(em.isOpen()){
					em.close();
				}
			} catch (Throwable e2) {
				throw new GenericThrowable(Config.getString("erro.fechar.transacao") + e2.getMessage());
			}
		}
	}
	@Override
	public void deletar(Cliente cliente) throws GenericException, GenericThrowable{
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			Cliente cliente_auxiliar = em.merge(cliente);
			em.remove(cliente_auxiliar);
			em.getTransaction().commit();
		} catch (Exception e) {
			throw new GenericException(Config.getString("erro.deletar.cliente") + e.getMessage());
		}finally{
			try {
				if(em.isOpen()){
					em.close();
				}
			} catch (Throwable e2) {
				throw new GenericThrowable(Config.getString("erro.fechar.transacao") + e2.getMessage());
			}
		}
	}
	public Cliente findClientes(Long id){
		EntityManager entityManager = getEntityManager();
		try {
			return entityManager.find(Cliente.class, id);
		} catch (Exception e) {
			entityManager.close();
		}
		return null;
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<Cliente> listar()throws GenericException, GenericThrowable {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			Query query = em.createNativeQuery("Select * from Cliente",Cliente.class);
			List<Cliente> clientes = query.getResultList();
			em.getTransaction().commit();
			return clientes;
		} catch (Exception e) {
			throw new GenericException(Config.getString("erro.listar.cliente") + e.getMessage());
		}finally{
			try {
				if(em.isOpen()){
					em.close();
				}
			} catch (Throwable e2) {
				throw new GenericThrowable(Config.getString("erro.fechar.transacao") + e2.getMessage());
			}
		}
	}
}
