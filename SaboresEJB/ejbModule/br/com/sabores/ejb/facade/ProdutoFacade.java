package br.com.sabores.ejb.facade;

import javax.ejb.Local;
import br.com.sabores.ejb.model.Produto;

@Local
public interface ProdutoFacade extends Facade<Produto>
{

}
