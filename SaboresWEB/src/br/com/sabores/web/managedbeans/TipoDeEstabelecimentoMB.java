package br.com.sabores.web.managedbeans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.sabores.ejb.model.TipoDeEstabelecimento;

@Named("tipoDeEstabelecimentoMB")
@RequestScoped
public class TipoDeEstabelecimentoMB
{
	private TipoDeEstabelecimento tipoDeEstabelecimento;
	
	public TipoDeEstabelecimentoMB(){}
	
	@PostConstruct
	public void init()
	{
		this.tipoDeEstabelecimento = new TipoDeEstabelecimento();
	}
	
	public TipoDeEstabelecimento getTipoDeEstabelecimento()
	{
		return tipoDeEstabelecimento;
	}
	
	public void setTipoDeEstabelecimento(TipoDeEstabelecimento tipoDeEstabelecimento)
	{
		this.tipoDeEstabelecimento = tipoDeEstabelecimento;
	}

}
