package br.com.sabores.ejb.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.sabores.ejb.annotations.GenericDAO;
import br.com.sabores.ejb.enums.GenericDAOTypes;
import br.com.sabores.ejb.model.Categoria;

@SuppressWarnings("serial")
@Stateless
@GenericDAO(type = GenericDAOTypes.Categoria, value = CategoriaDAO.class)
public class CategoriaDAO extends GDAO<Categoria>
{
	public CategoriaDAO()
	{
		super(Categoria.class);
	}

	public List<Categoria> findAll()
	{
		String sql = "SELECT c FROM Categoria c";
		TypedQuery<Categoria> typedQuery = super.getEm().createQuery(sql, Categoria.class);
		return typedQuery.getResultList();
	}
	
}
