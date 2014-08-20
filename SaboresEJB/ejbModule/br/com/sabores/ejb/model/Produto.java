package br.com.sabores.ejb.model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@SuppressWarnings("serial")
@Entity
@Table(name="produto")
public class Produto implements Serializable 
{
	@TableGenerator(name="produto_gen",
			table="id_generator",
			pkColumnName="generator_name",
			valueColumnName="generator_value",
			pkColumnValue="produto_generator",
			initialValue=0,
			allocationSize=5)
	@Id 
	@GeneratedValue(generator="produto_gen")
	@Column(name="id_produto")
	private Long id;
	
	@Column(length=3,unique=false,nullable=true,insertable=true,updatable=true,name="meses_de_validade")
	private Byte periocoDeValidade;
	
	@Column(length=10,unique=false,nullable=true,insertable=true,updatable=true,name="nome_produto")
	private String produto;
	
	@Column(length=10,unique=false,nullable=true,insertable=true,updatable=true,name="dsc_produto")
	private String descricao;
	
	@Column(length=10,unique=false,nullable=true,insertable=true,updatable=true,name="argumento_venda")
	private String argumentoDeVenda;
	
	@Column(length=10,unique=false,nullable=true,insertable=true,updatable=true,name="foto_produto")
	@Lob
	private byte[] fotoDoProduto;

	@Column(length=50,unique=false,nullable=true,insertable=true,updatable=true,name="nome_foto_produto")
	private String nomeFoto;
	
	@Column(length=10,unique=false,nullable=true,insertable=true,updatable=true,name="tam_foto_produto")
	private Double tamFoto;
	
	@Column(length=10,unique=false,nullable=true,insertable=true,updatable=true,name="tem_acucar")
	private Boolean acucar;
	
	@Column(length=10,unique=false,nullable=true,insertable=true,updatable=true,name="tem_lactose")
	private Boolean lactose;
	
	@Column(length=10,unique=false,nullable=true,insertable=true,updatable=true,name="tem_gluten")
	private Boolean gluten;
	
	@Temporal(TemporalType.DATE)
	@Column(length=10,unique=false,nullable=true,insertable=true,updatable=true,name="data_cadastro")
	private Date dataDeCadastro = new Date();
	
	@ManyToOne(optional=true)
	@JoinColumn(name="categoria_id")
	private Categoria categoria;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="fabricante_id")
	private Fabricante fabricante;
	
	@Column(length=10,unique=false,nullable=true,insertable=true,updatable=true,name="preco")
	private Double preco;
	
	@Column(length=10,unique=false,nullable=true,insertable=true,updatable=true,name="estoque")
	private Short estoque;
	
	@Transient
	private StreamedContent foto;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Byte getPeriocoDeValidade()
	{
		return periocoDeValidade;
	}

	public void setPeriocoDeValidade(Byte periocoDeValidade)
	{
		this.periocoDeValidade = periocoDeValidade;
	}

	public String getProduto()
	{
		return produto;
	}

	public void setProduto(String produto)
	{
		this.produto = produto;
	}

	public String getDescricao()
	{
		return descricao;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

	public String getArgumentoDeVenda()
	{
		return argumentoDeVenda;
	}

	public void setArgumentoDeVenda(String argumentoDeVenda)
	{
		this.argumentoDeVenda = argumentoDeVenda;
	}

	public byte[] getFotoDoProduto()
	{
		return fotoDoProduto;
	}

	public void setFotoDoProduto(byte[] fotoDoProduto)
	{
		this.fotoDoProduto = fotoDoProduto;
	}

	public Boolean getAcucar()
	{
		return acucar;
	}

	public void setAcucar(Boolean acucar)
	{
		this.acucar = acucar;
	}

	public Boolean getLactose()
	{
		return lactose;
	}

	public void setLactose(Boolean lactose)
	{
		this.lactose = lactose;
	}

	public Boolean getGluten()
	{
		return gluten;
	}

	public void setGluten(Boolean gluten)
	{
		this.gluten = gluten;
	}

	public Date getDataDeCadastro()
	{
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Date dataDeCadastro)
	{
		this.dataDeCadastro = dataDeCadastro;
	}

	public Categoria getCategoria()
	{
		return categoria;
	}

	public void setCategoria(Categoria categoria)
	{
		this.categoria = categoria;
	}

	public Fabricante getFabricante()
	{
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante)
	{
		this.fabricante = fabricante;
	}

	public StreamedContent getFoto()
	{
		if(foto == null && fotoDoProduto.length == 0)
		{
			foto = (StreamedContent) FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("no_image.gif");
		} 
		else if(foto == null && fotoDoProduto.length != 0)
		{
			InputStream stream = new ByteArrayInputStream(this.fotoDoProduto);
	        try
			{
				stream.read(this.fotoDoProduto);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
	       
	        setFoto(new DefaultStreamedContent(stream, "", ""));
		}
		return foto;
	}

	public void setFoto(StreamedContent foto)
	{
		this.foto = foto;
	}

	public Double getPreco()
	{
		return preco;
	}

	
	public void setPreco(Double preco)
	{
		this.preco = preco;
	}

	
	public Short getEstoque()
	{
		return estoque;
	}

	
	public void setEstoque(Short estoque)
	{
		this.estoque = estoque;
	}

	public String getNomeFoto()
	{
		return nomeFoto;
	}
	
	public void setNomeFoto(String nomeFoto)
	{
		this.nomeFoto = nomeFoto;
	}
	
	public Double getTamFoto()
	{
		return tamFoto;
	}
	
	public void setTamFoto(Double tamFoto)
	{
		this.tamFoto = tamFoto;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acucar == null) ? 0 : acucar.hashCode());
		result = prime * result + ((argumentoDeVenda == null) ? 0 : argumentoDeVenda.hashCode());
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((dataDeCadastro == null) ? 0 : dataDeCadastro.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((estoque == null) ? 0 : estoque.hashCode());
		result = prime * result + ((fabricante == null) ? 0 : fabricante.hashCode());
		result = prime * result + ((foto == null) ? 0 : foto.hashCode());
		result = prime * result + Arrays.hashCode(fotoDoProduto);
		result = prime * result + ((gluten == null) ? 0 : gluten.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lactose == null) ? 0 : lactose.hashCode());
		result = prime * result + ((nomeFoto == null) ? 0 : nomeFoto.hashCode());
		result = prime * result + ((periocoDeValidade == null) ? 0 : periocoDeValidade.hashCode());
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((tamFoto == null) ? 0 : tamFoto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Produto other = (Produto) obj;
		if (acucar == null)
		{
			if (other.acucar != null) return false;
		} else if (!acucar.equals(other.acucar)) return false;
		if (argumentoDeVenda == null)
		{
			if (other.argumentoDeVenda != null) return false;
		} else if (!argumentoDeVenda.equals(other.argumentoDeVenda)) return false;
		if (categoria == null)
		{
			if (other.categoria != null) return false;
		} else if (!categoria.equals(other.categoria)) return false;
		if (dataDeCadastro == null)
		{
			if (other.dataDeCadastro != null) return false;
		} else if (!dataDeCadastro.equals(other.dataDeCadastro)) return false;
		if (descricao == null)
		{
			if (other.descricao != null) return false;
		} else if (!descricao.equals(other.descricao)) return false;
		if (estoque == null)
		{
			if (other.estoque != null) return false;
		} else if (!estoque.equals(other.estoque)) return false;
		if (fabricante == null)
		{
			if (other.fabricante != null) return false;
		} else if (!fabricante.equals(other.fabricante)) return false;
		if (foto == null)
		{
			if (other.foto != null) return false;
		} else if (!foto.equals(other.foto)) return false;
		if (!Arrays.equals(fotoDoProduto, other.fotoDoProduto)) return false;
		if (gluten == null)
		{
			if (other.gluten != null) return false;
		} else if (!gluten.equals(other.gluten)) return false;
		if (id == null)
		{
			if (other.id != null) return false;
		} else if (!id.equals(other.id)) return false;
		if (lactose == null)
		{
			if (other.lactose != null) return false;
		} else if (!lactose.equals(other.lactose)) return false;
		if (nomeFoto == null)
		{
			if (other.nomeFoto != null) return false;
		} else if (!nomeFoto.equals(other.nomeFoto)) return false;
		if (periocoDeValidade == null)
		{
			if (other.periocoDeValidade != null) return false;
		} else if (!periocoDeValidade.equals(other.periocoDeValidade)) return false;
		if (preco == null)
		{
			if (other.preco != null) return false;
		} else if (!preco.equals(other.preco)) return false;
		if (produto == null)
		{
			if (other.produto != null) return false;
		} else if (!produto.equals(other.produto)) return false;
		if (tamFoto == null)
		{
			if (other.tamFoto != null) return false;
		} else if (!tamFoto.equals(other.tamFoto)) return false;
		return true;
	}
	
}