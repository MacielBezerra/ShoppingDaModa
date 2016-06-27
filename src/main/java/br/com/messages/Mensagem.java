package br.com.messages;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.entity.Cliente;
import br.com.entity.Mercadoria;

public class Mensagem {
	
	public Cliente mensagem(Cliente cliente){
		if(cliente.getNome().isEmpty()||cliente.getNome().equals("")||
				cliente.getTelefone().isEmpty()||cliente.getTelefone().equals("")||
				cliente.getCelular().isEmpty()||cliente.getCelular().equals("")||
				cliente.getEmail().isEmpty()||cliente.getEmail().equals("")||
				cliente.getEndereco().getEstado().getChaveEstado()==0){
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, Config.getString("save.fail"),null));
			cliente.setNome("obrigatorio");
			return cliente;
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
	public void mensagemExclusaoMercadoria(){
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,Config.getString("mercadoria.exclusao.sucesso"),null));
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
			return cliente;
		}else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Config.getString("edicao.sucesso"),null));
			return cliente;
		}
	}
	
	public Mercadoria mensagemMercadoriaSucesso(Mercadoria mercadoria){
		if(mercadoria.getCategoria().getIdCategoria()==0||
			mercadoria.getTamanho().getIdTamanho()==0||
			mercadoria.getGenero().getIdGenero()==0){
			mercadoria.setMarca("obrigatorio");
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, Config.getString("save.fail"),null));
			return mercadoria;
		}else {
			if(mercadoria.getValorCompra()==0.0 && mercadoria.getValorVenda()==0.0 || mercadoria.getValorCompra()==0.0 || mercadoria.getValorVenda()==0.0){
				mercadoria.setValorCompra(null);
				mercadoria.setValorVenda(null);
			}
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Config.getString("save.sucesso.mercadoria"),null));
			return mercadoria;
		}
	}
	
	public Mercadoria mensagemMercadoriaEdicao(Mercadoria mercadoria){
		if(mercadoria.getCategoria().getIdCategoria()==0||
			mercadoria.getTamanho().getIdTamanho()==0||
			mercadoria.getGenero().getIdGenero()==0){
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, Config.getString("save.fail"),null));
			return mercadoria;
		}else {
			if(mercadoria.getValorCompra()==0.0 && mercadoria.getValorVenda()==0.0 || mercadoria.getValorCompra()==0.0 || mercadoria.getValorVenda()==0.0){
				mercadoria.setValorCompra(null);
				mercadoria.setValorVenda(null);
			}
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Config.getString("mercadoria.edicao.sucesso"),null));
			return mercadoria;
		}
	}
}
