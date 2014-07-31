package br.com.sabores.ejb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_de_estabelecimento")
public class TipoDeEstabelecimento
{
	@Id
	@GeneratedValue
	@Column(name="id_tipo_estab")
	private Long id;
	
	@Column(length=20,nullable=false,insertable=true,updatable=true)
	private String tipoDeEstabelecimento;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getTipoDeEstabelecimento()
	{
		return tipoDeEstabelecimento;
	}

	public void setTipoDeEstabelecimento(String tipoDeEstabelecimento)
	{
		this.tipoDeEstabelecimento = tipoDeEstabelecimento;
	}
	
	
}
