package br.com.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tamanho")
public class Tamanho implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4144948556454166573L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_tamanho")
	private Integer idTamanho;
	@Column(name="descricao")
	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getIdTamanho() {
		return idTamanho;
	}
	public void setIdTamanho(Integer idTamanho) {
		this.idTamanho = idTamanho;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result
				+ ((idTamanho == null) ? 0 : idTamanho.hashCode());
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
		Tamanho other = (Tamanho) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idTamanho == null) {
			if (other.idTamanho != null)
				return false;
		} else if (!idTamanho.equals(other.idTamanho))
			return false;
		return true;
	}
}
