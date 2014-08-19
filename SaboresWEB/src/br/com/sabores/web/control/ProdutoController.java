package br.com.sabores.web.control;

import java.util.List;

import javax.ejb.EJB;

import br.com.sabores.ejb.facade.ProdutoFacade;
import br.com.sabores.ejb.model.Produto;

public class ProdutoController implements Controller<Produto>
{
	@EJB
	private ProdutoFacade produtoFacade;

	@Override
	public void saveController(Produto p)
	{
		this.produtoFacade.salvar(p);
	}

	@Override
	public void deleteController(Produto p)
	{
		this.produtoFacade.apagar(p);
	}

	@Override
	public List<Produto> findAllController()
	{
		return this.produtoFacade.buscarTodosOsRegistros();
	}

	@Override
	public Produto findOneController(Produto p)
	{
		return this.produtoFacade.buscarUmRegistro(p.getId());
	}

	@Override
	public void alterarController(Produto p)
	{
		this.produtoFacade.alterar(p);
	}
}
