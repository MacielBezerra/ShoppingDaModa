package br.com.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="genero")
public class Genero implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4364910960482783744L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_genero")
	private Integer idGenero;
	@Column(name="descricao")
	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getIdGenero() {
		return idGenero;
	}
	public void setIdGenero(Integer idGenero) {
		this.idGenero = idGenero;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result
				+ ((idGenero == null) ? 0 : idGenero.hashCode());
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
		Genero other = (Genero) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idGenero == null) {
			if (other.idGenero != null)
				return false;
		} else if (!idGenero.equals(other.idGenero))
			return false;
		return true;
	}
}
