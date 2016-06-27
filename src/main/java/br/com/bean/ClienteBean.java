package br.com.bean;

import java.util.List;
import br.com.dao.DAOCliente;
import br.com.dao.DAOEstado;
import br.com.entity.Cliente;
import br.com.entity.Endereco;
import br.com.entity.Estado;
import br.com.excecao.GenericException;
import br.com.excecao.GenericThrowable;
import br.com.messages.Mensagem;

public class ClienteBean {

	private Cliente cliente;
	private Mensagem mensagem;
	private DAOCliente<Cliente> clienteDao;
	private List<Estado> estados;
	private DAOEstado estadoDAO;
	private Endereco endereco;
	private Estado estado;

	public ClienteBean() throws GenericException, GenericThrowable{
		mensagem = new Mensagem();
		clienteDao = new DAOCliente<Cliente>();
		estadoDAO = new DAOEstado();
		cliente = new Cliente();
		endereco = new Endereco();
		estado = new Estado();
		cliente.setEndereco(endereco);
		endereco.setCliente(cliente);
		endereco.setEstado(estado);
		estadoList();
	}

	public String salvar(Cliente cliente) throws GenericException, GenericThrowable{
		Cliente cliente_auxiliar = mensagem.mensagem(cliente);
		if(cliente_auxiliar.getNome().equals("obrigatorio")){
			return "cadastro/cadastro.xhtml?faces-redirect=true";
		}else{
			if(cliente_auxiliar.getEndereco().getNumero()==0){
				cliente_auxiliar.getEndereco().setNumero(null);
			}
			clienteDao.salvar(cliente_auxiliar);
			return "listaClientes.xhtml?faces-redirect=true";
			} 	
	}
	public void deletar(Cliente cliente) throws GenericException, GenericThrowable{
		clienteDao.deletar(cliente);
		mensagem.mensagemExclusao();
	}

	public String editar(Cliente cliente) throws GenericException, GenericThrowable{
		Cliente cliente_auxiliar = mensagem.mensagemEdicao(cliente);
		if(cliente_auxiliar.getNome().equals("")||cliente_auxiliar.getTelefone().equals("")||
			cliente_auxiliar.getCelular().equals("")||cliente_auxiliar.getEmail().equals("")||
			cliente_auxiliar.getEndereco().getEstado().getChaveEstado()==0){
			return "cadastro/editar.xhtml?faces-redirect=true";
		}else{
			if(cliente_auxiliar.getEndereco().getNumero()==0){
				cliente_auxiliar.getEndereco().setNumero(null);
			}
			clienteDao.atualizar(cliente_auxiliar);
			return "listaClientes.xhtml?faces-redirect=true";
		}
	}

	public void limparCampos(){
		cliente.setClienteChave(null);
		cliente.setNome("");
		cliente.setTelefone("");
		cliente.setCelular("");
		cliente.setEmail("");
		cliente.getEndereco().setEndereco(null);
		cliente.getEndereco().setRua("");
		cliente.getEndereco().setNumero(null);
		cliente.getEndereco().setBairro("");
		cliente.getEndereco().setCidade("");
		cliente.getEndereco().getEstado().setChaveEstado(0);
		cliente.getEndereco().setCep("");
		cliente.getEndereco().setComplemento("");
	}

	public List<Cliente> listarClientes() throws GenericException, GenericThrowable{
		return clienteDao.listar();
	}

	public List<Estado> estadoList() throws GenericException, GenericThrowable{
		return this.estados = estadoDAO.listarEstados();
	}

	public String paginaEditar(){
		return "editar.xhtml?faces-redirect=true";
	}
	public String paginaCadastrar(){
		return "cadastro.xhtml?faces-redirect=true";
	}
	public String paginaListaClientes(){
		return "listaClientes.xhtml?faces-redirect=true";
	}
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public DAOCliente<Cliente> getClienteDao() {
		return clienteDao;
	}

	public void setClienteDao(DAOCliente<Cliente> clienteDao) {
		this.clienteDao = clienteDao;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
