package br.com.bean;

import java.util.List;
import br.com.dao.DAOCategoria;
import br.com.dao.DAOGenero;
import br.com.dao.DAOMercadoria;
import br.com.dao.DAOTamanho;
import br.com.entity.Categoria;
import br.com.entity.Genero;
import br.com.entity.Mercadoria;
import br.com.entity.Tamanho;
import br.com.excecao.GenericException;
import br.com.excecao.GenericThrowable;
import br.com.messages.Mensagem;

public class MercadoriaBean {
	
	private Categoria categoria;
	private Tamanho tamanho;
	private Genero genero;
	private List<Categoria> categorias;
	private List<Tamanho> tamanhos;
	private List<Genero> generos;
	private DAOCategoria daoCategoria;
	private DAOTamanho daoTamanho;
	private Mercadoria mercadoria;
	private DAOGenero daoGenero;
	private DAOMercadoria<Mercadoria> mercadoriaDao;
	private Mensagem mensagem;
	
	public MercadoriaBean(){
		mercadoriaDao = new DAOMercadoria<Mercadoria>();
		mercadoria = new Mercadoria();
		categoria = new Categoria();
		tamanho = new Tamanho();
		genero = new Genero();
		daoCategoria = new DAOCategoria();
		daoTamanho = new DAOTamanho();
		daoGenero = new DAOGenero();
		mensagem = new Mensagem();
		mercadoria.setCategoria(categoria);
		mercadoria.setTamanho(tamanho);
		mercadoria.setGenero(genero);
		popularListaCategoria();
		popularListaTamanho();
		popularListaGenero();
	}
	
	public List<Categoria> popularListaCategoria(){
		return this.categorias = daoCategoria.listarCategorias();
	}
	
	public List<Tamanho> popularListaTamanho(){
		return this.tamanhos = daoTamanho.listarTamanhos(); 
	}
	
	public List<Genero> popularListaGenero(){
		return this.generos = daoGenero.listarGeneros(); 
	}
	
	public String salvar(Mercadoria mercadoria) throws GenericException, GenericThrowable {
		Mercadoria mercadoria_auxiliar = mensagem.mensagemMercadoriaSucesso(mercadoria);
		if(mercadoria_auxiliar.getMarca().equals("obrigatorio")){
			limparCampos();
			return "manter_estoque/cadastrar_mercadoria.xhtml?faces-redirect=true";
		}else{
			if(mercadoria_auxiliar.getEstoque()==0){
				mercadoria_auxiliar.setEstoque(null);
			}
			mercadoriaDao.salvar(mercadoria_auxiliar);
			return "listar_mercadoria.xhtml?faces-redirect=true";
		}
	}
	
	public String editarMercadoria(Mercadoria mercadoria) throws GenericException, GenericThrowable{
			Mercadoria mercadoria_auxiliar = mensagem.mensagemMercadoriaEdicao(mercadoria);
			if(mercadoria_auxiliar.getCategoria().getIdCategoria()==0||
			   mercadoria_auxiliar.getTamanho().getIdTamanho()==0||
			   mercadoria_auxiliar.getGenero().getIdGenero()==0){
				return "manter_estoque/editar_mercadoria.xhtml?faces-redirect=true";
			}else{
				if(mercadoria_auxiliar.getEstoque()==0){
					mercadoria_auxiliar.setEstoque(null);
				}
				mercadoriaDao.atualizar(mercadoria_auxiliar);
				return "listar_mercadoria.xhtml?faces-redirect=true";
			}
	}
	
	public void deletar(Mercadoria mercadoria) throws GenericException, GenericThrowable{
		mercadoriaDao.deletar(mercadoria);
		mensagem.mensagemExclusaoMercadoria();
	}
	
	public List<Mercadoria> listarMercadorias() throws GenericException, GenericThrowable{
		return mercadoriaDao.listar();
	}
	
	public void limparCampos(){
		this.mercadoria.getCategoria().setIdCategoria(0);
		this.mercadoria.getTamanho().setIdTamanho(0);
		this.mercadoria.getGenero().setIdGenero(0);
		this.mercadoria.setValorCompra(null);
		this.mercadoria.setValorVenda(null);
		this.mercadoria.setEstoque(null);
		this.mercadoria.setDataCadastro(null);
		this.mercadoria.setMarca("");
	}
	
	public String paginaEditarMercadoria(){
		return "editar_mercadoria.xhtml?faces-redirect=true";
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public DAOCategoria getDaoCategoria() {
		return daoCategoria;
	}

	public void setDaoCategoria(DAOCategoria daoCategoria) {
		this.daoCategoria = daoCategoria;
	}

	public Tamanho getTamanho() {
		return tamanho;
	}

	public void setTamanho(Tamanho tamanho) {
		this.tamanho = tamanho;
	}

	public List<Tamanho> getTamanhos() {
		return tamanhos;
	}

	public void setTamanhos(List<Tamanho> tamanhos) {
		this.tamanhos = tamanhos;
	}

	public DAOTamanho getDaoTamanho() {
		return daoTamanho;
	}
	
	public void setDaoTamanho(DAOTamanho daoTamanho) {
		this.daoTamanho = daoTamanho;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public List<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}

	public DAOGenero getDaoGenero() {
		return daoGenero;
	}

	public void setDaoGenero(DAOGenero daoGenero) {
		this.daoGenero = daoGenero;
	}

	public DAOMercadoria<Mercadoria> getMercadoriaDao() {
		return mercadoriaDao;
	}

	public void setMercadoriaDao(DAOMercadoria<Mercadoria> mercadoriaDao) {
		this.mercadoriaDao = mercadoriaDao;
	}

	public Mercadoria getMercadoria() {
		return mercadoria;
	}

	public void setMercadoria(Mercadoria mercadoria) {
		this.mercadoria = mercadoria;
	}

	public Mensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}
}
