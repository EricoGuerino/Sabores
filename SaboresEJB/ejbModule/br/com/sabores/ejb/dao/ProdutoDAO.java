package br.com.sabores.ejb.dao;

import br.com.sabores.ejb.annotations.GenericDAO;
import br.com.sabores.ejb.enums.GenericDAOTypes;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.sabores.ejb.model.Produto;

@SuppressWarnings("serial")
@Stateless
@GenericDAO(type = GenericDAOTypes.Produto, value = ProdutoDAO.class)
public class ProdutoDAO extends GDAO<Produto>
{
	public ProdutoDAO()
	{
		super(Produto.class);
	}
	
	public List<Produto> findAll()
	{
		String sql = "SELECT p FROM Produto p";
		TypedQuery<Produto> typedQuery = super.getEm().createQuery(sql, Produto.class);
		return typedQuery.getResultList();
	}
}
