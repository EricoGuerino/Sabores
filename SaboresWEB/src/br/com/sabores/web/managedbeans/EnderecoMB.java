package br.com.sabores.web.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

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
	private Estados estados;
	
	public EnderecoMB(){}
	
	@Inject
	private EnderecoController enderecoController;
	
	@PostConstruct
	public void init()
	{
		this.listaDeEstados = new ArrayList<>(getEnderecoController().buscarEstados());
		this.endereco = new Endereco();
	}
	
	public void atualizarListaCidadesPorEstado()
	{
		this.estados = new Estados();
		this.listaDeCidades = new ArrayList<>(getEnderecoController().buscarCidadesPorEstado(this.estados.getSigla()));
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
}
