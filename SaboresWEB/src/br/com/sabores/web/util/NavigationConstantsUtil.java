package br.com.sabores.web.util;

//import javax.enterprise.context.ApplicationScoped;
//import javax.inject.Named;

//@ApplicationScoped
//@Named("navigationBean")
public class NavigationConstantsUtil
{
	private final String TO_ADMINISTRACAO = "/pages/public/admin/administracao.xhtml";
	private final String toAdministracao = "/pages/public/admin/administracao.xhtml";
	public String toAdministracao()
	{
		return TO_ADMINISTRACAO;
	}
	
	private static final String toSabores = "/pages/templates/sabores.xhtml";
	
	private static final String toCadastroCategoria = "/pages/public/admin/cadastroCategoria.xhtml";
	private static final String toCadastroFabricante = "/pages/public/admin/cadastroFabricante.xhtml";
	private static final String toCadastroTiposEstabelecimento = "/pages/public/admin/cadastroTipoEstabelecimento.xhtml";
	private static final String toCadastroCliente = "";
	private static final String toCadastroProdutos = "";
	private static final String toCadastroPrecos = "";
	private static final String toCadastroEstoque = "";
	
	private static final String toCategorias = "/pages/public/admin/tabelasDeDados/listarCategorias.xhtml";
	private static final String toFabricantes = "/pages/public/admin/tabelasDeDados/listarFabricantes.xhtml";
	private static final String toTipos = "/pages/public/admin/tabelasDeDados/listarTiposEstabelecimento.xhtml";
	private static final String toProdutos = "";
	private static final String toClientes = "";
	
	public NavigationConstantsUtil(){}
	
	public String getToAdministracao()
	{
		return toAdministracao;
	}
	public String getToSabores()
	{
		return toSabores;
	}
	public String getToCadastroCategoria()
	{
		return toCadastroCategoria;
	}
	public String getToCadastroFabricante()
	{
		return toCadastroFabricante;
	}
	public String getToCadastroTiposEstabelecimento()
	{
		return toCadastroTiposEstabelecimento;
	}
	public String getToCadastroCliente()
	{
		return toCadastroCliente;
	}
	public String getToCadastroProdutos()
	{
		return toCadastroProdutos;
	}
	public String getToCadastroPrecos()
	{
		return toCadastroPrecos;
	}
	public String getToCadastroEstoque()
	{
		return toCadastroEstoque;
	}
	public String getToCategorias()
	{
		return toCategorias;
	}
	public String getToFabricantes()
	{
		return toFabricantes;
	}
	public String getToTipos()
	{
		return toTipos;
	}
	public String getToProdutos()
	{
		return toProdutos;
	}
	public String getToClientes()
	{
		return toClientes;
	}
	
	
}
