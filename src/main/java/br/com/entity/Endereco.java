package br.com.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Parameter;

/**
 * @author Maciel B
 *
 */
@Entity
@Table(name="endereco")
public class Endereco implements Serializable{

	
	private static final long serialVersionUID = -5317177038321874639L;
	
	@Id
	@GeneratedValue(generator="FK_endereco_cod_cliente")
	@org.hibernate.annotations.GenericGenerator(name="FK_endereco_cod_cliente",strategy="foreign",
	parameters=@Parameter(name="property",value="cliente"))
	@Column(name="cod_cliente")
	private Integer enderecoChave;
	@OneToOne(mappedBy="endereco")
	private Cliente cliente;
	@Column(name="rua")
	private String rua;
	private Integer numero;
	private String bairro;
	private String cidade;
	@OneToOne
	@JoinColumn(name="id_estado")
	private Estado estado;
	private String cep;
	private String complemento;
	
	
	//gets and sets
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Integer getEnderecoChave() {
		return enderecoChave;
	}
	public void setEndereco(Integer enderecoChave) {
		this.enderecoChave = enderecoChave;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public void setEnderecoChave(Integer enderecoChave) {
		this.enderecoChave = enderecoChave;
	}
	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result
				+ ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result
				+ ((enderecoChave == null) ? 0 : enderecoChave.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((rua == null) ? 0 : rua.hashCode());
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
		Endereco other = (Endereco) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (enderecoChave == null) {
			if (other.enderecoChave != null)
				return false;
		} else if (!enderecoChave.equals(other.enderecoChave))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (rua == null) {
			if (other.rua != null)
				return false;
		} else if (!rua.equals(other.rua))
			return false;
		return true;
	}
}
