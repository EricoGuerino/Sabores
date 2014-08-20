package br.com.sabores.web.control;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;

import br.com.sabores.ejb.facade.TipoDeEstabelecimentoFacade;
import br.com.sabores.ejb.model.TipoDeEstabelecimento;

@SuppressWarnings("serial")
public class TipoDeEstabelecimentoController extends AbstractController implements Controller<TipoDeEstabelecimento>,Serializable
{

	@EJB
	private TipoDeEstabelecimentoFacade tipoEstabelecimentoFacade;
	
	@Override
	public void saveController(TipoDeEstabelecimento tipo)
	{
		tipoEstabelecimentoFacade.salvar(tipo);
	}

	@Override
	public void alterarController(TipoDeEstabelecimento tipo)
	{
		tipoEstabelecimentoFacade.alterar(tipo);
	}

	@Override
	public void deleteController(TipoDeEstabelecimento tipo)
	{
		tipoEstabelecimentoFacade.apagar(tipo);
	}

	@Override
	public List<TipoDeEstabelecimento> findAllController()
	{
		return tipoEstabelecimentoFacade.buscarTodosOsRegistros();
	}

	@Override
	public TipoDeEstabelecimento findOneController(TipoDeEstabelecimento tipo)
	{
		return tipoEstabelecimentoFacade.buscarUmRegistro(tipo.getId());
	}

}
