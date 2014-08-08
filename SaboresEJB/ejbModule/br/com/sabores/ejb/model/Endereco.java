package br.com.sabores.ejb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import br.com.sabores.ejb.enums.TipoEnderecoEnum;
import br.com.sabores.ejb.enums.TipoLogradouroEnum;

@Entity
@Table(name="endereco_cliente")
public class Endereco 
{
	@Transient
	private static final String BRASIL = "Brasil";
	
	@TableGenerator(name="endereco_gen",
			table="id_generator",
			pkColumnName="generator_name",
			valueColumnName="generator_value",
			pkColumnValue="endereco_generator",
			initialValue=0,
			allocationSize=5)
	@Id 
	@GeneratedValue(generator="endereco_gen")
	@Column(name="id_endereco")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(length=30,nullable=false,insertable=true,updatable=true)
	private TipoEnderecoEnum tipoEndereco;
	
	@Enumerated(EnumType.STRING)
	@Column(length=30,nullable=false,insertable=true,updatable=true)
	private TipoLogradouroEnum tipoLogradouro;
	
	@Column(length=50,nullable=false,insertable=true,updatable=true)
	private String logradouro;
	
	@Column(length=5,nullable=true,insertable=true,updatable=true)
	private String numero;
	
	@Column(length=50,nullable=false,insertable=true,updatable=true)
	private String bairro;
	
	@Column(length=10,nullable=false,insertable=true,updatable=true)
	private String cep;
	
	@Column(length=30,nullable=false,insertable=true,updatable=true)
	private String cidade;
	
	@Column(length=30,nullable=false,insertable=true,updatable=true)
	private String uf;
	
	@Column(length=30,nullable=false,insertable=true,updatable=true)
	private String pais = BRASIL;
	
//	@ManyToOne
//	private Cliente cliente;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public TipoEnderecoEnum getTipoEndereco()
	{
		return tipoEndereco;
	}

	public void setTipoEndereco(TipoEnderecoEnum tipoEndereco)
	{
		this.tipoEndereco = tipoEndereco;
	}

	public TipoLogradouroEnum getTipoLogradouro()
	{
		return tipoLogradouro;
	}

	public void setTipoLogradouro(TipoLogradouroEnum tipoLogradouro)
	{
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getLogradouro()
	{
		return logradouro;
	}

	public void setLogradouro(String logradouro)
	{
		this.logradouro = logradouro;
	}

	public String getNumero()
	{
		return numero;
	}

	public void setNumero(String numero)
	{
		this.numero = numero;
	}

	public String getBairro()
	{
		return bairro;
	}

	public void setBairro(String bairro)
	{
		this.bairro = bairro;
	}

	public String getCep()
	{
		return cep;
	}

	public void setCep(String cep)
	{
		this.cep = cep;
	}

	public String getCidade()
	{
		return cidade;
	}

	public void setCidade(String cidade)
	{
		this.cidade = cidade;
	}

	public String getUf()
	{
		return uf;
	}

	public void setUf(String uf)
	{
		this.uf = uf;
	}

	public String getPais()
	{
		return pais;
	}

	public void setPais(String pais)
	{
		this.pais = pais;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((logradouro == null) ? 0 : logradouro.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
		result = prime * result
				+ ((tipoEndereco == null) ? 0 : tipoEndereco.hashCode());
		result = prime * result
				+ ((tipoLogradouro == null) ? 0 : tipoLogradouro.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (bairro == null)
		{
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (cep == null)
		{
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cidade == null)
		{
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (logradouro == null)
		{
			if (other.logradouro != null)
				return false;
		} else if (!logradouro.equals(other.logradouro))
			return false;
		if (numero == null)
		{
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (pais == null)
		{
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		if (tipoEndereco != other.tipoEndereco)
			return false;
		if (tipoLogradouro != other.tipoLogradouro)
			return false;
		if (uf == null)
		{
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		return true;
	}

//	public Cliente getCliente()
//	{
//		return cliente;
//	}
//
//	public void setCliente(Cliente cliente)
//	{
//		this.cliente = cliente;
//	}

	
	
}
