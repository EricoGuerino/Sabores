package br.com.sabores.web.managedbeans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.sabores.ejb.model.Email;

@Named(value="emailMB")
@RequestScoped
public class EmailMB
{

	private Email email;
	
	public EmailMB(){}
	
	@PostConstruct
	public void init()
	{
		this.email = new Email();
	}

	public Email getEmail()
	{
		return email;
	}

	public void setEmail(Email email)
	{
		this.email = email;
	}
	
	

}
