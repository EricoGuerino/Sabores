package br.com.sabores.ejb.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.sabores.ejb.annotations.GenericDAO;
import br.com.sabores.ejb.dao.ProdutoDAO;
import br.com.sabores.ejb.enums.GenericDAOTypes;
import br.com.sabores.ejb.model.Produto;

@Stateless
public class ProdutoFacadeImp implements ProdutoFacade
{

	@Inject @GenericDAO(type = GenericDAOTypes.Produto, value = ProdutoDAO.class)
	private ProdutoDAO produtoDAO;
	
	@Override
	public boolean salvar(Produto t)
	{
		produtoDAO.inserir(t);
		return true;
	}

	@Override
	public boolean apagar(Produto t)
	{
		produtoDAO.apagar(t.getId());
		return true;
	}

	@Override
	public boolean alterar(Produto t)
	{
		produtoDAO.alterar(t);
		return true;
	}

	@Override
	public Produto buscarUmRegistro(Long id)
	{
		return produtoDAO.findOne(id);
	}

	@Override
	public List<Produto> buscarTodosOsRegistros()
	{
		return produtoDAO.findAll();
	}

}
