package br.com.sabores.ejb.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.sabores.ejb.annotations.GenericDAO;
import br.com.sabores.ejb.enums.GenericDAOTypes;
import br.com.sabores.ejb.model.Cliente;

@SuppressWarnings("serial")
@Stateless
@GenericDAO(type = GenericDAOTypes.Cliente, value = ClienteDAO.class)
public class ClienteDAO extends GDAO<Cliente>
{

	public ClienteDAO()
	{
		super(Cliente.class);
	}
	
	public List<Cliente> findAll()
	{
		String sql = "SELECT c FROM Cliente c";
		TypedQuery<Cliente> typedQuery = super.getEm().createQuery(sql, Cliente.class);
		return typedQuery.getResultList();
	}
}
