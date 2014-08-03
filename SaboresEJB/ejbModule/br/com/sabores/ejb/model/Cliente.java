package br.com.sabores.ejb.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.com.sabores.ejb.enums.Perfil;

@Entity
@Table(name="cliente")
public class Cliente 
{
	@Transient
	private static Date DATA_DO_CADASTRO = new Date();	
	
	@TableGenerator(name="cliente_gen",
			table="id_generator",
			pkColumnName="generator_name",
			valueColumnName="generator_value",
			pkColumnValue="cliente_generator",
			initialValue=0,
			allocationSize=5)
	@Id 
	@GeneratedValue(generator="cliente_gen")
	@Column(name="id_cliente")
	private Long id;
	
	@Column(unique=true,length=20,nullable=false,insertable=true,updatable=true,name="cnpj")
	private String cnpj;
	
	@Column(length=70,nullable=false,insertable=true,updatable=true,name="nome_do_contato")
	private String nomeDoContato;
	
	@Column(unique=true,nullable=false,length=70,insertable=true,updatable=true,name="razao_social")
	private String razaoSocial;
	
	@Column(unique=true,nullable=false,length=20,insertable=true,updatable=true,name="ie")
	private String ie;
	
	@OneToOne
	@JoinColumn(name="seguimento_com")
	private TipoDeEstabelecimento seguimento;
	
	@Column(length=50,nullable=true,insertable=true,updatable=true,name="site_cliente")
	private String siteDoCliente;
	
	@Column(nullable=false)
	private String perfil = String.valueOf(Perfil.USUARIO_CADASTRADO);
	
	@Temporal(TemporalType.DATE)
	@Column(length=10,nullable=false,insertable=true,updatable=false,name="data_cadastro")
	private Date dataDeCadastro = DATA_DO_CADASTRO;
	
	@Temporal(TemporalType.DATE)
	@Column(length=10,nullable=true,insertable=true,updatable=true,name="data_alt_cadastro")
	private Date dataDeAlteracao;
	
	//telefones
	@Embedded
	private Telefone telefone;
	
	//emails
	@Embedded
	private Email email;
	
	@OneToMany(mappedBy="cliente")
	private List<Endereco> endereco;

	public static Date getDATA_DO_CADASTRO()
	{
		return DATA_DO_CADASTRO;
	}

	public static void setDATA_DO_CADASTRO(Date dATA_DO_CADASTRO)
	{
		DATA_DO_CADASTRO = dATA_DO_CADASTRO;
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getCnpj()
	{
		return cnpj;
	}

	public void setCnpj(String cnpj)
	{
		this.cnpj = cnpj;
	}

	public String getNomeDoContato()
	{
		return nomeDoContato;
	}

	public void setNomeDoContato(String nomeDoContato)
	{
		this.nomeDoContato = nomeDoContato;
	}

	public String getRazaoSocial()
	{
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial)
	{
		this.razaoSocial = razaoSocial;
	}

	public String getIe()
	{
		return ie;
	}

	public void setIe(String ie)
	{
		this.ie = ie;
	}

	public TipoDeEstabelecimento getSeguimento()
	{
		return seguimento;
	}

	public void setSeguimento(TipoDeEstabelecimento seguimento)
	{
		this.seguimento = seguimento;
	}

	public String getSiteDoCliente()
	{
		return siteDoCliente;
	}

	public void setSiteDoCliente(String siteDoCliente)
	{
		this.siteDoCliente = siteDoCliente;
	}

	public String getPerfil()
	{
		return perfil;
	}

	public void setPerfil(String perfil)
	{
		this.perfil = perfil;
	}

	public Date getDataDeCadastro()
	{
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Date dataDeCadastro)
	{
		this.dataDeCadastro = dataDeCadastro;
	}

	public Date getDataDeAlteracao()
	{
		return dataDeAlteracao;
	}

	public void setDataDeAlteracao(Date dataDeAlteracao)
	{
		this.dataDeAlteracao = dataDeAlteracao;
	}

	public Telefone getTelefone()
	{
		if(this.telefone == null)
		{
			this.telefone = new Telefone();
		}
		return telefone;
	}

	public void setTelefone(Telefone telefone)
	{
		this.telefone = telefone;
	}

	public Email getEmail()
	{
		if(email == null){
			this.email = new Email();
		}
		return email;
	}

	public void setEmail(Email email)
	{
		this.email = email;
	}

	public List<Endereco> getEndereco()
	{
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco)
	{
		this.endereco = endereco;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result
				+ ((dataDeAlteracao == null) ? 0 : dataDeAlteracao.hashCode());
		result = prime * result
				+ ((dataDeCadastro == null) ? 0 : dataDeCadastro.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((ie == null) ? 0 : ie.hashCode());
		result = prime * result
				+ ((nomeDoContato == null) ? 0 : nomeDoContato.hashCode());
		result = prime * result + ((perfil == null) ? 0 : perfil.hashCode());
		result = prime * result
				+ ((razaoSocial == null) ? 0 : razaoSocial.hashCode());
		result = prime * result
				+ ((seguimento == null) ? 0 : seguimento.hashCode());
		result = prime * result
				+ ((siteDoCliente == null) ? 0 : siteDoCliente.hashCode());
		result = prime * result
				+ ((telefone == null) ? 0 : telefone.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (dataDeAlteracao == null) {
			if (other.dataDeAlteracao != null)
				return false;
		} else if (!dataDeAlteracao.equals(other.dataDeAlteracao))
			return false;
		if (dataDeCadastro == null) {
			if (other.dataDeCadastro != null)
				return false;
		} else if (!dataDeCadastro.equals(other.dataDeCadastro))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (id != other.id)
			return false;
		if (ie == null) {
			if (other.ie != null)
				return false;
		} else if (!ie.equals(other.ie))
			return false;
		if (nomeDoContato == null) {
			if (other.nomeDoContato != null)
				return false;
		} else if (!nomeDoContato.equals(other.nomeDoContato))
			return false;
		if (perfil == null) {
			if (other.perfil != null)
				return false;
		} else if (!perfil.equals(other.perfil))
			return false;
		if (razaoSocial == null) {
			if (other.razaoSocial != null)
				return false;
		} else if (!razaoSocial.equals(other.razaoSocial))
			return false;
		if (seguimento == null) {
			if (other.seguimento != null)
				return false;
		} else if (!seguimento.equals(other.seguimento))
			return false;
		if (siteDoCliente == null) {
			if (other.siteDoCliente != null)
				return false;
		} else if (!siteDoCliente.equals(other.siteDoCliente))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}
	
}
