//package br.com.sabores.ejb.model;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.persistence.TableGenerator;
//
//
//@SuppressWarnings("serial")
//@Entity
//@Table(name="estoque")
//public class Estoque implements Serializable
//{
//	@TableGenerator(name="estoque_gen",
//			table="id_generator",
//			pkColumnName="generator_name",
//			valueColumnName="generator_value",
//			pkColumnValue="estoque_generator",
//			initialValue=0,
//			allocationSize=5)
//	@Id 
//	@GeneratedValue(generator="estoque_gen")
//	@Column(name="id_estoque")
//	private Long id;
//	
//	@Column(length=10,unique=false,nullable=true,insertable=true,updatable=true,name="estoque")
//	private Short estoque;
//
//	
//	public Long getId()
//	{
//		return id;
//	}
//
//	
//	public void setId(Long id)
//	{
//		this.id = id;
//	}
//
//	
//	public Short getEstoque()
//	{
//		return estoque;
//	}
//
//	
//	public void setEstoque(Short estoque)
//	{
//		this.estoque = estoque;
//	}
//
//
//	@Override
//	public int hashCode()
//	{
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((estoque == null) ? 0 : estoque.hashCode());
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		return result;
//	}
//
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
//		Estoque other = (Estoque) obj;
//		if (estoque == null)
//		{
//			if (other.estoque != null)
//				return false;
//		} else if (!estoque.equals(other.estoque))
//			return false;
//		if (id == null)
//		{
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		return true;
//	}
//	
//	
//}
