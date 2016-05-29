package br.com.messages;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.entity.Cliente;

public class Mensagem {
	
	public Cliente mensagem(Cliente cliente){
		if(cliente.getNome().isEmpty()||cliente.getNome().equals("")||
				cliente.getTelefone().isEmpty()||cliente.getTelefone().equals("")||
				cliente.getCelular().isEmpty()||cliente.getCelular().equals("")||
				cliente.getEmail().isEmpty()||cliente.getEmail().equals("")||
				cliente.getEndereco().getEstado().getChaveEstado()==0){
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, Config.getString("save.fail"),null));
			return null;
		}else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Config.getString("save.sucesso"),null));
			return cliente;
		}
	}
	public void mensagemExclusao(){
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,Config.getString("exclusao.sucesso"),null));
	}
	public Cliente mensagemEdicao(Cliente cliente){
		if(cliente.getNome().isEmpty()||cliente.getNome().equals("")||
				cliente.getTelefone().isEmpty()||cliente.getTelefone().equals("")||
				cliente.getCelular().isEmpty()||cliente.getCelular().equals("")||
				cliente.getEmail().isEmpty()||cliente.getEmail().equals("")||
				cliente.getEndereco().getEstado().getChaveEstado()==0||
				cliente.getEndereco().getEstado().equals("")){
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, Config.getString("save.fail"),null));
			return null;
		}else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Config.getString("edicao.sucesso"),null));
			return cliente;
		}
	}
}
