package br.com.sabores.ejb.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.sabores.ejb.model.Endereco;
import br.com.sabores.ejb.model.cep.Cidade;
import br.com.sabores.ejb.model.cep.UF;

@Local
public interface EnderecoFacade
{
	Endereco buscarEndereco(String cep);
	List<UF> buscarTodosEstados();
	List<Cidade> buscarTodasCidadesPorEstado(String sigla);
}