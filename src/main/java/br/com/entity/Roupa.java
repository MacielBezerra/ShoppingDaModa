package br.com.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="roupa")
public class Roupa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7355831391978519134L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_roupa")
	private Integer idRoupa;
	@OneToOne
	@JoinColumn(name="")
	private Categoria categoria;
	@OneToOne
	@JoinColumn(name="")
	private Genero genero;
	@OneToOne
	@JoinColumn(name="")
	private Tamanho tamanho;
	
	public Integer getIdRoupa() {
		return idRoupa;
	}
	public void setIdRoupa(Integer idRoupa) {
		this.idRoupa = idRoupa;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public Tamanho getTamanho() {
		return tamanho;
	}
	public void setTamanho(Tamanho tamanho) {
		this.tamanho = tamanho;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((idRoupa == null) ? 0 : idRoupa.hashCode());
		result = prime * result + ((tamanho == null) ? 0 : tamanho.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Roupa other = (Roupa) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (idRoupa == null) {
			if (other.idRoupa != null)
				return false;
		} else if (!idRoupa.equals(other.idRoupa))
			return false;
		if (tamanho == null) {
			if (other.tamanho != null)
				return false;
		} else if (!tamanho.equals(other.tamanho))
			return false;
		return true;
	}
}
