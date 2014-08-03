package br.com.sabores.ejb.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.sabores.ejb.annotations.GenericDAO;
import br.com.sabores.ejb.enums.GenericDAOTypes;
import br.com.sabores.ejb.model.Endereco;
import br.com.sabores.ejb.model.cep.AC;
import br.com.sabores.ejb.model.cep.AL;
import br.com.sabores.ejb.model.cep.AM;
import br.com.sabores.ejb.model.cep.AP;
import br.com.sabores.ejb.model.cep.BA;
import br.com.sabores.ejb.model.cep.CE;
import br.com.sabores.ejb.model.cep.DF;
import br.com.sabores.ejb.model.cep.ES;
import br.com.sabores.ejb.model.cep.Estados;
import br.com.sabores.ejb.model.cep.GO;
import br.com.sabores.ejb.model.cep.MA;
import br.com.sabores.ejb.model.cep.MG;
import br.com.sabores.ejb.model.cep.MS;
import br.com.sabores.ejb.model.cep.MT;
import br.com.sabores.ejb.model.cep.PA;
import br.com.sabores.ejb.model.cep.PB;
import br.com.sabores.ejb.model.cep.PE;
import br.com.sabores.ejb.model.cep.PI;
import br.com.sabores.ejb.model.cep.PR;
import br.com.sabores.ejb.model.cep.RJ;
import br.com.sabores.ejb.model.cep.RN;
import br.com.sabores.ejb.model.cep.RO;
import br.com.sabores.ejb.model.cep.RR;
import br.com.sabores.ejb.model.cep.RS;
import br.com.sabores.ejb.model.cep.SC;
import br.com.sabores.ejb.model.cep.SE;
import br.com.sabores.ejb.model.cep.SP;
import br.com.sabores.ejb.model.cep.TO;

@SuppressWarnings("serial")
@Stateless
@GenericDAO(type = GenericDAOTypes.Endereco, value = EnderecoDAO.class)
public class EnderecoDAO extends GDAO<Endereco>
{

	public EnderecoDAO()
	{
		super(Endereco.class);
	}
	
	public Endereco buscarUm(String cep)
	{
		//TODO
		Endereco endereco = new Endereco();
		return endereco;
	}
	
	public List<Estados> buscarTodosEstados()
	{
		//TODO
		StringBuilder sql = new StringBuilder();
		sql
			.append("SELECT ")
			.append("e ")
			.append("FROM ")
			.append("Estados e");
		TypedQuery<Estados> typed = super.getEm().createQuery(sql.toString(), Estados.class);
		
		return typed.getResultList();
	}
	
	@SuppressWarnings("rawtypes")
	private Class selecaoEstado(String sigla)
	{
		Map<String, Class> estados = new HashMap<>();
		
		estados.put("AC", AC.class);
		estados.put("AM", AM.class);
		estados.put("PA", PA.class); 
		estados.put("TO", TO.class); 
		estados.put("RR", RR.class); 
		estados.put("RO", RO.class); 
		estados.put("AP", AP.class);
		estados.put("MA", MA.class); 
		estados.put("PI", PI.class); 
		estados.put("CE", CE.class); 
		estados.put("RN", RN.class); 
		estados.put("PB", PB.class);
		estados.put("PE", PE.class); 
		estados.put("AL", AL.class); 
		estados.put("SE", SE.class); 
		estados.put("BA", BA.class);
		estados.put("GO", GO.class); 
		estados.put("MS", MS.class); 
		estados.put("MT", MT.class); 
		estados.put("DF", DF.class);
		estados.put("MG", MG.class); 
		estados.put("RJ", RJ.class); 
		estados.put("SP", SP.class); 
		estados.put("ES", ES.class);
		estados.put("PR", PR.class); 
		estados.put("RS", RS.class); 
		estados.put("SC", SC.class);
		
		return estados.get(sigla);
	}
	
	@SuppressWarnings("unchecked")
	public List<String> buscarTodasCidadesPorEstado(String sigla)
	{
		StringBuilder sql = new StringBuilder();
		sql
			.append("SELECT ")
			.append("cities.cidade ")
			.append("FROM ")
			.append(selecaoEstado(sigla).getClass().getSimpleName())
			.append(" cities");
		Query query = super.getEm().createQuery(sql.toString());
		
		return query.getResultList();
	}

	public br.com.sabores.ejb.model.cep.Estados carregarPelaPK(Class<Estados> classe, String sigla)
	{
		StringBuilder sql = new StringBuilder();
		sql
			.append("SELECT ")
			.append("e ")
			.append("FROM ")
			.append("Estados e")
			.append("WHERE ")
			.append("e.sigla = :sigla");
		TypedQuery<Estados> typed = super.getEm().createQuery(sql.toString(), classe);
		typed.setParameter("sigla", sigla);
		return typed.getResultList().get(0);
	}
	
}
