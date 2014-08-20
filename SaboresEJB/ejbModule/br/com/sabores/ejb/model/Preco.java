//package br.com.sabores.ejb.model;
//
//import java.io.Serializable;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name="preco")
//public class Preco implements Serializable 
//{
//	private static final long serialVersionUID = 1L;
//	
//	@TableGenerator(name="preco_gen",
//			table="id_generator",
//			pkColumnName="generator_name",
//			valueColumnName="generator_value",
//			pkColumnValue="preco_generator",
//			initialValue=0,
//			allocationSize=5)
//	@Id 
//	@GeneratedValue(generator="preco_gen")
//	@Column(name="id_preco")
//	private Long id;
//	
//	@Column(length=10,unique=false,nullable=true,insertable=true,updatable=true,name="preco")
//	private Double preco;
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
//	public Double getPreco()
//	{
//		return preco;
//	}
//
//	public void setPreco(Double preco)
//	{
//		this.preco = preco;
//	}
//
//	@Override
//	public int hashCode()
//	{
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
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
//		Preco other = (Preco) obj;
//		if (id == null)
//		{
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		if (preco == null)
//		{
//			if (other.preco != null)
//				return false;
//		} else if (!preco.equals(other.preco))
//			return false;
//		return true;
//	}
//	
//	
//}
