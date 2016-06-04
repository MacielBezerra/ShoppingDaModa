package br.com.bean;

import java.util.List;

import br.com.dao.DAOCategoria;
import br.com.dao.DAOGenero;
import br.com.dao.DAOTamanho;
import br.com.entity.Categoria;
import br.com.entity.Genero;
import br.com.entity.Tamanho;

public class MercadoriaBean {
	
	private Categoria categoria;
	private Tamanho tamanho;
	private Genero genero;
	private List<Categoria> categorias;
	private List<Tamanho> tamanhos;
	private List<Genero> generos;
	private DAOCategoria daoCategoria;
	private DAOTamanho daoTamanho;
	private DAOGenero daoGenero;
	
	public MercadoriaBean(){
		categoria = new Categoria();
		tamanho = new Tamanho();
		genero = new Genero();
		daoCategoria = new DAOCategoria();
		daoTamanho = new DAOTamanho();
		daoGenero = new DAOGenero();
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
}
