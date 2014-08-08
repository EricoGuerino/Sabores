package br.com.sabores.web.managedbeans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sabores.ejb.enums.TipoLogradouroEnum;
import br.com.sabores.ejb.model.Endereco;
import br.com.sabores.ejb.model.cep.Estados;
import br.com.sabores.web.control.EnderecoController;

@Named(value="enderecoMB")
@RequestScoped
public class EnderecoMB
{
	private Endereco endereco;
	//TODO alterar tipo destas listas
	private List<Estados> listaDeEstados;
	private List<String> listaDeCidades;
	private List<TipoLogradouroEnum> listaTiposLogradouros;
	private Estados estados;
	private boolean cobranca;
	private boolean entrega;
	
	public EnderecoMB(){}
	
	@Inject
	private EnderecoController enderecoController;
	
	@PostConstruct
	public void init()
	{
		this.listaTiposLogradouros = new ArrayList<>(Arrays.asList(TipoLogradouroEnum.values()));
		this.listaDeEstados = new ArrayList<>(getEnderecoController().buscarEstados());
		this.endereco = new Endereco();
	}
	
	public void atualizarListaCidadesPorEstado()
	{
		this.estados = new Estados();
		this.listaDeCidades = new ArrayList<>(getEnderecoController().buscarCidadesPorEstado(this.estados.getSigla()));
	}
	
	public void mostrarEntrega()
	{
		if(this.entrega == false)
		{
			this.entrega = true;
		} 
		else
		{
			this.entrega = false;
		}
	}
	
	public void mostrarCobranca()
	{
		if(this.cobranca == false)
		{
			this.cobranca = true;
		}
		else
		{
			this.cobranca = false;
		}
	}
	
	public Endereco getEndereco()
	{
		return endereco;
	}
	
	public void setEndereco(Endereco endereco)
	{
		this.endereco = endereco;
	}

	public List<Estados> getListaDeEstados()
	{
		return listaDeEstados;
	}

	public void setListaDeEstados(List<Estados> listaDeEstados)
	{
		this.listaDeEstados = listaDeEstados;
	}

	public List<String> getListaDeCidades()
	{
		return listaDeCidades;
	}

	public void setListaDeCidades(List<String> listaDeCidades)
	{
		this.listaDeCidades = listaDeCidades;
	}
	
	public EnderecoController getEnderecoController()
	{
		return enderecoController;
	}
	
	public void setEstados(Estados estados)
	{
		this.estados = estados;
	}
	
	public Estados getEstados()
	{
		return estados;
	}

	
	public boolean isCobranca()
	{
		return cobranca;
	}

	
	public void setCobranca(boolean cobranca)
	{
		this.cobranca = cobranca;
	}

	
	public boolean isEntrega()
	{
		return entrega;
	}

	public void setEntrega(boolean entrega)
	{
		this.entrega = entrega;
	}
	
	public List<TipoLogradouroEnum> getListaTiposLogradouros()
	{
		return listaTiposLogradouros;
	}
}
