package br.com.sabores.web.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.sabores.ejb.model.Endereco;

@Named(value="enderecoMB")
@RequestScoped
public class EnderecoMB
{
	private Endereco endereco;
	//TODO alterar tipo destas listas
	private List<Endereco> listaDeEstados;
	private List<Endereco> listaDeCidades;
	public EnderecoMB(){}
	
	@PostConstruct
	public void init()
	{
		this.listaDeCidades = new ArrayList<>();
		this.listaDeEstados = new ArrayList<>();
		this.endereco = new Endereco();
	}
	
	public Endereco getEndereco()
	{
		return endereco;
	}
	
	public void setEndereco(Endereco endereco)
	{
		this.endereco = endereco;
	}

	public List<Endereco> getListaDeEstados()
	{
		return listaDeEstados;
	}

	public void setListaDeEstados(List<Endereco> listaDeEstados)
	{
		this.listaDeEstados = listaDeEstados;
	}

	public List<Endereco> getListaDeCidades()
	{
		return listaDeCidades;
	}

	public void setListaDeCidades(List<Endereco> listaDeCidades)
	{
		this.listaDeCidades = listaDeCidades;
	}
	
	
}
