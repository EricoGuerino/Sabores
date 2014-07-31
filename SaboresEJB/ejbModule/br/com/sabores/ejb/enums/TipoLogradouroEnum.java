package br.com.sabores.ejb.enums;

public enum TipoLogradouroEnum
{
	RUA("Rua"), AVENIDA("Avenida"), ALAMEDA("Alameda"), TRAVESSA("Travessa"), BECO("Beco"), PRACA("Praça"), 
	RODOVIA("Rodovia"), ESTRADA_SEM_NOME("Estrada sem nome"), PONTE("Ponte"), VIADUTO("Viaduto");
	
	private String descricao;
	
	private TipoLogradouroEnum(String dsc)
	{
		this.setDescricao(dsc);
	}

	public String getDescricao()
	{
		return descricao;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}
}
