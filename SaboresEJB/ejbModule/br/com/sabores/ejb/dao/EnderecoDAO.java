package br.com.sabores.ejb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import br.com.sabores.ejb.annotations.GenericDAO;
import br.com.sabores.ejb.enums.GenericDAOTypes;
import br.com.sabores.ejb.model.Endereco;
import br.com.sabores.ejb.model.cep.Cidade;
import br.com.sabores.ejb.model.cep.UF;

@SuppressWarnings("serial")
@Stateless
@GenericDAO(type = GenericDAOTypes.Endereco, value = EnderecoDAO.class)
public class EnderecoDAO extends GDAO<Endereco>
{

	public EnderecoDAO()
	{
		super(Endereco.class);
	}
	
	public Endereco buscarUm(String cep)
	{
		//TODO
		Endereco endereco = new Endereco();
		return endereco;
	}
	
	public List<UF> buscarTodosEstados()
	{
		//TODO
		List<UF> listaDeEstados = new ArrayList<>();
		return listaDeEstados;
	}
	
	public List<Cidade> buscarTodasCidadesPorEstado(String sigla)
	{
		//TODO
		List<Cidade> listaDeCidades = new ArrayList<>();
		return listaDeCidades;
	}
	
}
