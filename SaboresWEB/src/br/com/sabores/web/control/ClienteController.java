package br.com.sabores.web.control;

import java.util.List;

import javax.ejb.EJB;

import br.com.sabores.ejb.facade.ClienteFacade;
import br.com.sabores.ejb.model.Cliente;

public class ClienteController extends AbstractController implements Controller<Cliente>
{

	@EJB
	private ClienteFacade ClienteFacade;
	
	public ClienteFacade getClienteFacade()
	{
		return ClienteFacade;
	}
	
	@Override
	public void saveController(Cliente c)
	{
		getClienteFacade().salvar(c);
	}

	@Override
	public void deleteController(Cliente c)
	{
		getClienteFacade().apagar(c);
	}

	@Override
	public List<Cliente> findAllController()
	{
		return getClienteFacade().buscarTodosOsRegistros();
	}

	@Override
	public Cliente findOneController(Cliente c)
	{
		return getClienteFacade().buscarUmRegistro(c.getId());
	}

	@Override
	public void alterarController(Cliente f)
	{
		getClienteFacade().alterar(f);
	}
	
}
