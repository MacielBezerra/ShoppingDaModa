package br.com.dao;
import java.util.List;
import br.com.excecao.GenericException;
import br.com.excecao.GenericThrowable;
/**
 * @author Maciel B
 *
 * @param <T>
 */
public interface IDAOGerneric<T> {
	
	public void salvar(T objeto)throws GenericException, GenericThrowable;
	public List<T> listar()throws GenericException,GenericThrowable;
	public T buscar(Integer codigo)throws GenericException,GenericThrowable;
	public void deletar(T objeto)throws GenericException, GenericThrowable;
	public void atualizar(T Objeto)throws GenericException, GenericThrowable;
	
}
