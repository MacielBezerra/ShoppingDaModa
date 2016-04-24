package br.com.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Maciel B
 * 
 */
@Entity
@Table(name = "estado")
public class Estado implements Serializable {

	private static final long serialVersionUID = -366346653879048583L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name = "id_estado")
	private Integer chaveEstado;
	@Column(name = "sigla")
	private String sigla;

	public Integer getChaveEstado() {
		return chaveEstado;
	}

	public void setChaveEstado(Integer chaveEstado) {
		this.chaveEstado = chaveEstado;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((chaveEstado == null) ? 0 : chaveEstado.hashCode());
		result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
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
		Estado other = (Estado) obj;
		if (chaveEstado == null) {
			if (other.chaveEstado != null)
				return false;
		} else if (!chaveEstado.equals(other.chaveEstado))
			return false;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		return true;
	}
}
