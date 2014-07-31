package br.com.sabores.ejb.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.sabores.ejb.annotations.GenericDAO;
import br.com.sabores.ejb.dao.ClienteDAO;
import br.com.sabores.ejb.enums.GenericDAOTypes;
import br.com.sabores.ejb.model.Cliente;

@Stateless
public class ClienteFacadeImp implements ClienteFacade
{
	@Inject @GenericDAO(type = GenericDAOTypes.Cliente, value = ClienteDAO.class)
	private ClienteDAO clienteDAO;
	
	@Override
	public boolean salvar(Cliente t)
	{
		clienteDAO.inserir(t);
		return true;
	}

	@Override
	public boolean apagar(Cliente t)
	{
		clienteDAO.apagar(t.getId());
		return true;
	}

	@Override
	public boolean alterar(Cliente t)
	{
		clienteDAO.alterar(t);
		return true;
	}

	@Override
	public Cliente buscarUmRegistro(Long id)
	{
		return clienteDAO.findOne(id);
	}

	@Override
	public List<Cliente> buscarTodosOsRegistros()
	{
		return clienteDAO.findAll();
	}
}
