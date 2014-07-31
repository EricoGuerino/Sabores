package br.com.sabores.web.control;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;

import br.com.sabores.ejb.facade.CategoriaFacade;
import br.com.sabores.ejb.model.Categoria;

@SuppressWarnings("serial")
public class CategoriaController implements Controller<Categoria>, Serializable
{
	@EJB
	private CategoriaFacade categoriaFacade;
	
	public CategoriaFacade getCategoriaFacade()
	{
		return this.categoriaFacade;
	}

	@Override
	public void saveController(Categoria c)
	{
		getCategoriaFacade().salvar(c);
	}

	@Override
	public void deleteController(Categoria c)
	{
		getCategoriaFacade().apagar(c);
	}

	@Override
	public List<Categoria> findAllController()
	{
		return getCategoriaFacade().buscarTodosOsRegistros();
	}

	@Override
	public Categoria findOneController(Categoria c)
	{
		return getCategoriaFacade().buscarUmRegistro(c.getId());
	}

	@Override
	public void alterarController(Categoria c)
	{
		getCategoriaFacade().alterar(c);
	}
	
}