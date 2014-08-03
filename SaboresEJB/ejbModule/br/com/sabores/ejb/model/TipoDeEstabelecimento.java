package br.com.sabores.ejb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="tipo_de_estabelecimento")
public class TipoDeEstabelecimento
{
	@TableGenerator(name="tipo_estabelecimento_gen",
			table="id_generator",
			pkColumnName="generator_name",
			valueColumnName="generator_value",
			pkColumnValue="tipos_generator",
			initialValue=0,
			allocationSize=5)
	@Id 
	@GeneratedValue(generator="tipo_estabelecimento_gen")
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
