package br.com.sabores.web.managedbeans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sabores.ejb.model.Cliente;
import br.com.sabores.ejb.model.Endereco;
import br.com.sabores.web.control.EnderecoController;

@Named(value="clienteMB")
@RequestScoped
public class ClienteMB
{
	@Inject
	private EnderecoController enderecoController;
	
	private Endereco endereco;
	
	private Cliente cliente;
	
	public ClienteMB(){}

	@PostConstruct
	public void init()
	{
		this.cliente = new Cliente();
		this.endereco = new Endereco();
	}
	
	public Cliente getCliente()
	{
		return cliente;
	}

	public void setCliente(Cliente cliente)
	{
		this.cliente = cliente;
	}

	public EnderecoController getEnderecoController()
	{
		return enderecoController;
	}
	
	public Endereco getEndereco()
	{
		return endereco;
	}
	
	public void setEndereco(Endereco endereco)
	{
		this.endereco = endereco;
	}
	
}
