package br.com.sabores.ejb.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.sabores.ejb.annotations.GenericDAO;
import br.com.sabores.ejb.enums.GenericDAOTypes;
import br.com.sabores.ejb.model.TipoDeEstabelecimento;

@SuppressWarnings("serial")
@Stateless
@GenericDAO(type=GenericDAOTypes.TipoDeEstabelecimento, value=TipoDeEstabelecimentoDAO.class)
public class TipoDeEstabelecimentoDAO extends GDAO<TipoDeEstabelecimento>
{
	public TipoDeEstabelecimentoDAO()
	{
		super(TipoDeEstabelecimento.class);
	}
	
	public List<TipoDeEstabelecimento> findAll()
	{
		String sql = "SELECT tp FROM TipoDeEstabelecimento tp";
		TypedQuery<TipoDeEstabelecimento> typedQuery = super.getEm().createQuery(sql, TipoDeEstabelecimento.class);
		return typedQuery.getResultList();
	}
}
