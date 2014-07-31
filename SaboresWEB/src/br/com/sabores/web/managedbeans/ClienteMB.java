package br.com.sabores.web.managedbeans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sabores.ejb.model.Cliente;

@Named(value="clienteMB")
@RequestScoped
public class ClienteMB
{
	@Inject
	private EnderecoMB enderecoMB;
	
	@Inject
	private EmailMB emailMB;
	
	@Inject
	private TelefoneMB telefoneMB;
	
	private Cliente cliente;
	
	public ClienteMB(){}

	@PostConstruct
	public void init()
	{
		this.cliente = new Cliente();
	}
	
	public Cliente getCliente()
	{
		return cliente;
	}

	public void setCliente(Cliente cliente)
	{
		this.cliente = cliente;
	}

	public EnderecoMB getEnderecoMB()
	{
		return enderecoMB;
	}

	public void setEnderecoMB(EnderecoMB enderecoMB)
	{
		this.enderecoMB = enderecoMB;
	}

	public EmailMB getEmailMB()
	{
		return emailMB;
	}

	public void setEmailMB(EmailMB emailMB)
	{
		this.emailMB = emailMB;
	}

	public TelefoneMB getTelefoneMB()
	{
		return telefoneMB;
	}

	public void setTelefoneMB(TelefoneMB telefoneMB)
	{
		this.telefoneMB = telefoneMB;
	}
	
	
}
