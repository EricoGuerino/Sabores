package br.com.sabores.ejb.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.sabores.ejb.annotations.GenericDAO;
import br.com.sabores.ejb.dao.EnderecoDAO;
import br.com.sabores.ejb.enums.GenericDAOTypes;
import br.com.sabores.ejb.model.Endereco;
import br.com.sabores.ejb.model.cep.Cidade;
import br.com.sabores.ejb.model.cep.UF;

@Stateless
public class EnderecoFacadeImp implements EnderecoFacade
{
	@Inject @GenericDAO(type = GenericDAOTypes.Endereco, value = EnderecoDAO.class)
	private EnderecoDAO enderecoDAO;

	@Override
	public Endereco buscarEndereco(String cep)
	{
		return enderecoDAO.buscarUm(cep);
	}

	@Override
	public List<UF> buscarTodosEstados()
	{
		return enderecoDAO.buscarTodosEstados();
	}

	@Override
	public List<Cidade> buscarTodasCidadesPorEstado(String sigla)
	{
		return enderecoDAO.buscarTodasCidadesPorEstado(sigla);
	}
	
}