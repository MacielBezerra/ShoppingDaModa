package br.com.dao;
import java.util.List;
import javax.persistence.EntityManager;
import br.com.conexao.FactoryConnection;
import br.com.excecao.GenericException;
import br.com.excecao.GenericThrowable;
import br.com.messages.Config;
/**
 * @author Maciel B
 *
 * @param <T>
 */
public abstract class DAOAbstract<T> extends FactoryConnection implements IDAOGerneric<T> {

	public abstract T buscar(Integer codigo)throws GenericException, GenericThrowable;
	public abstract void deletar(T objeto)throws GenericException, GenericThrowable;
	public abstract List<T> listar()throws GenericException, GenericThrowable;
	
	public void salvar(T objeto)throws GenericException, GenericThrowable{
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(objeto);
			em.getTransaction().commit();
		} catch (Exception e) {
			throw new GenericException(Config.getString("erro.salvar")+ objeto.getClass()+ e.getMessage());
		}finally{
			try {
				if(em.isOpen()){
					em.close();
				}
			} catch (Throwable e2) {
				throw new GenericThrowable(Config.getString("erro.fechar.transacao")+e2.getMessage());
			}
		}
	}
	public void atualizar(T objeto)throws GenericException, GenericThrowable{
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(objeto);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
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
