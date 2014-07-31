package br.com.sabores.ejb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="categoria")
public class Categoria implements Serializable
{
	@Id
	@GeneratedValue
	@Column(name="id_categoria")
	private Long id;
	
	@Column(length=30,unique=true,nullable=false,insertable=true,updatable=true,name="categoria")
	private String categoria;

	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public String getCategoria() 
	{
		return categoria;
	}

	public void setCategoria(String categoria) 
	{
		this.categoria = categoria;
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Categoria other = (Categoria) obj;
		if (categoria == null) 
		{
			if (other.categoria != null)
				return false;
		}
		else if (!categoria.equals(other.categoria))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} 
		else if (!id.equals(other.id))
			return false;
		return true;
	}
}
