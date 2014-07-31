package br.com.sabores.web.control;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;

import br.com.sabores.ejb.facade.FabricanteFacade;
import br.com.sabores.ejb.model.Fabricante;

@SuppressWarnings("serial")
public class FabricanteController implements Controller<Fabricante>,Serializable
{
	@EJB
	private FabricanteFacade fabricanteFacade;
	
	public FabricanteFacade getFabricanteFacade()
	{
		return fabricanteFacade;
	}

	@Override
	public void saveController(Fabricante f)
	{
		getFabricanteFacade().salvar(f);
	}

	@Override
	public void deleteController(Fabricante f)
	{
		getFabricanteFacade().apagar(f);
	}

	@Override
	public List<Fabricante> findAllController()
	{
		return getFabricanteFacade().buscarTodosOsRegistros();
	}

	@Override
	public Fabricante findOneController(Fabricante f)
	{
		return getFabricanteFacade().buscarUmRegistro(f.getId());
	}

	@Override
	public void alterarController(Fabricante f)
	{
		getFabricanteFacade().alterar(f);
	}
	
	
}
