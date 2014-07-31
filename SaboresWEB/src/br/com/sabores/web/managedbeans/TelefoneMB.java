package br.com.sabores.web.managedbeans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.sabores.ejb.model.Telefone;

@Named(value="telefoneMB")
@RequestScoped
public class TelefoneMB
{
	private Telefone telefone;
	//TODO
	
	public TelefoneMB(){}
	
	@PostConstruct
	public void init()
	{
		this.telefone = new Telefone();
	}
	
	public Telefone getTelefone()
	{
		return telefone;
	}
	
	public void setTelefone(Telefone telefone)
	{
		this.telefone = telefone;
	}
}
