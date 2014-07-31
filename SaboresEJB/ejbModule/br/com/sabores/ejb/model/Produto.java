//package br.com.sabores.ejb.model;
//
//import java.util.Arrays;
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.Lob;
//import javax.persistence.ManyToOne;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import javax.persistence.Transient;
//
//import org.primefaces.model.StreamedContent;
//
//@Entity
//public class Produto 
//{
//	@Id
//	@GeneratedValue
//	@Column(name="id_produto")
//	private Long id;
//	
//	//substituir por período de validade: 1, 2, 3 meses de validade (usar meses como unidade)
//	@Column(nullable=false)
//	private Byte periocoDeValidade;
//	
//	@Column(nullable=false)
//	private String produto;
//	
//	@Column(nullable=false)
//	private String descricao;
//	
//	@Column(nullable=false)
//	private String argumentoDeVenda;
//	
//	@Column(nullable=true)
//	@Lob
//	private byte[] fotoDoProduto;
//
//	@Column(nullable=false)
//	private Boolean acucar;
//	
//	@Column(nullable=false)
//	private Boolean lactose;
//	
//	@Column(nullable=false)
//	private Boolean gluten;
//	
//	@Temporal(TemporalType.DATE)
//	private Date dataDeCadastro;
//	
//	@ManyToOne(optional=true)
//	@JoinColumn(name="categoria_id")
//	private Categoria categoria;
//	
//	@ManyToOne(optional=true)
//	@JoinColumn(name="fabricante_id")
//	private Fabricante fabricante;
//	
//	@Transient
//	private StreamedContent foto;
//
//	public Long getId()
//	{
//		return id;
//	}
//
//	public void setId(Long id)
//	{
//		this.id = id;
//	}
//
//	public Byte getPeriocoDeValidade()
//	{
//		return periocoDeValidade;
//	}
//
//	public void setPeriocoDeValidade(Byte periocoDeValidade)
//	{
//		this.periocoDeValidade = periocoDeValidade;
//	}
//
//	public String getProduto()
//	{
//		return produto;
//	}
//
//	public void setProduto(String produto)
//	{
//		this.produto = produto;
//	}
//
//	public String getDescricao()
//	{
//		return descricao;
//	}
//
//	public void setDescricao(String descricao)
//	{
//		this.descricao = descricao;
//	}
//
//	public String getArgumentoDeVenda()
//	{
//		return argumentoDeVenda;
//	}
//
//	public void setArgumentoDeVenda(String argumentoDeVenda)
//	{
//		this.argumentoDeVenda = argumentoDeVenda;
//	}
//
//	public byte[] getFotoDoProduto()
//	{
//		return fotoDoProduto;
//	}
//
//	public void setFotoDoProduto(byte[] fotoDoProduto)
//	{
//		this.fotoDoProduto = fotoDoProduto;
//	}
//
//	public Boolean getAcucar()
//	{
//		return acucar;
//	}
//
//	public void setAcucar(Boolean acucar)
//	{
//		this.acucar = acucar;
//	}
//
//	public Boolean getLactose()
//	{
//		return lactose;
//	}
//
//	public void setLactose(Boolean lactose)
//	{
//		this.lactose = lactose;
//	}
//
//	public Boolean getGluten()
//	{
//		return gluten;
//	}
//
//	public void setGluten(Boolean gluten)
//	{
//		this.gluten = gluten;
//	}
//
//	public Date getDataDeCadastro()
//	{
//		return dataDeCadastro;
//	}
//
//	public void setDataDeCadastro(Date dataDeCadastro)
//	{
//		this.dataDeCadastro = dataDeCadastro;
//	}
//
//	public Categoria getCategoria()
//	{
//		return categoria;
//	}
//
//	public void setCategoria(Categoria categoria)
//	{
//		this.categoria = categoria;
//	}
//
//	public Fabricante getFabricante()
//	{
//		return fabricante;
//	}
//
//	public void setFabricante(Fabricante fabricante)
//	{
//		this.fabricante = fabricante;
//	}
//
//	public StreamedContent getFoto()
//	{
//		return foto;
//	}
//
//	public void setFoto(StreamedContent foto)
//	{
//		this.foto = foto;
//	}
//
//	@Override
//	public int hashCode()
//	{
//		final int prime = 31;
//		int result = 1;
//		result = prime * result
//				+ ((acucar == null) ? 0 : acucar.hashCode());
//		result = prime
//				* result
//				+ ((argumentoDeVenda == null) ? 0 : argumentoDeVenda
//						.hashCode());
//		result = prime * result
//				+ ((categoria == null) ? 0 : categoria.hashCode());
//		result = prime
//				* result
//				+ ((dataDeCadastro == null) ? 0 : dataDeCadastro.hashCode());
//		result = prime * result
//				+ ((descricao == null) ? 0 : descricao.hashCode());
//		result = prime * result
//				+ ((fabricante == null) ? 0 : fabricante.hashCode());
//		result = prime * result + ((foto == null) ? 0 : foto.hashCode());
//		result = prime * result + Arrays.hashCode(fotoDoProduto);
//		result = prime * result
//				+ ((gluten == null) ? 0 : gluten.hashCode());
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		result = prime * result
//				+ ((lactose == null) ? 0 : lactose.hashCode());
//		result = prime
//				* result
//				+ ((periocoDeValidade == null) ? 0 : periocoDeValidade
//						.hashCode());
//		result = prime * result
//				+ ((produto == null) ? 0 : produto.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj)
//	{
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Produto other = (Produto) obj;
//		if (acucar == null) {
//			if (other.acucar != null)
//				return false;
//		} else if (!acucar.equals(other.acucar))
//			return false;
//		if (argumentoDeVenda == null) {
//			if (other.argumentoDeVenda != null)
//				return false;
//		} else if (!argumentoDeVenda.equals(other.argumentoDeVenda))
//			return false;
//		if (categoria == null) {
//			if (other.categoria != null)
//				return false;
//		} else if (!categoria.equals(other.categoria))
//			return false;
//		if (dataDeCadastro == null) {
//			if (other.dataDeCadastro != null)
//				return false;
//		} else if (!dataDeCadastro.equals(other.dataDeCadastro))
//			return false;
//		if (descricao == null) {
//			if (other.descricao != null)
//				return false;
//		} else if (!descricao.equals(other.descricao))
//			return false;
//		if (fabricante == null) {
//			if (other.fabricante != null)
//				return false;
//		} else if (!fabricante.equals(other.fabricante))
//			return false;
//		if (foto == null) {
//			if (other.foto != null)
//				return false;
//		} else if (!foto.equals(other.foto))
//			return false;
//		if (!Arrays.equals(fotoDoProduto, other.fotoDoProduto))
//			return false;
//		if (gluten == null) {
//			if (other.gluten != null)
//				return false;
//		} else if (!gluten.equals(other.gluten))
//			return false;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		if (lactose == null) {
//			if (other.lactose != null)
//				return false;
//		} else if (!lactose.equals(other.lactose))
//			return false;
//		if (periocoDeValidade == null) {
//			if (other.periocoDeValidade != null)
//				return false;
//		} else if (!periocoDeValidade.equals(other.periocoDeValidade))
//			return false;
//		if (produto == null) {
//			if (other.produto != null)
//				return false;
//		} else if (!produto.equals(other.produto))
//			return false;
//		return true;
//	}
//}
