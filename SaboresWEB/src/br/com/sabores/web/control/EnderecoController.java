package br.com.sabores.web.control;

import java.util.List;

import javax.ejb.EJB;

import br.com.sabores.ejb.facade.EnderecoFacade;
import br.com.sabores.ejb.model.Endereco;
import br.com.sabores.ejb.model.cep.Estados;

public class EnderecoController
{
	
	@EJB
	private EnderecoFacade enderecoFacade;
	
	public EnderecoFacade getEnderecoFacade()
	{
		return enderecoFacade;
	}
	
	public Endereco buscarEnderecoEspecifico(String cep)
	{
		return getEnderecoFacade().buscarEndereco(cep);
	}
	
	public List<String> buscarCidadesPorEstado(String sigla){
		return getEnderecoFacade().buscarTodasCidadesPorEstado(sigla);
	}
	
	public List<Estados> buscarEstados(){
		return getEnderecoFacade().buscarTodosEstados();
	}
	
}
