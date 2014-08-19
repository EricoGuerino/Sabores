package br.com.sabores.web.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import br.com.sabores.ejb.model.Cliente;
import br.com.sabores.ejb.model.Email;
import br.com.sabores.ejb.model.Endereco;
import br.com.sabores.ejb.model.Telefone;
import br.com.sabores.ejb.model.TipoDeEstabelecimento;
import br.com.sabores.web.control.ClienteController;
import br.com.sabores.web.control.EnderecoController;
import br.com.sabores.web.control.TipoDeEstabelecimentoController;

@Named(value="clienteMB")
@RequestScoped
public class ClienteMB
{
	@Inject
	private EnderecoController enderecoController;
	@Inject
	private ClienteController clienteController;
	@Inject
	private TipoDeEstabelecimentoController tipoDeEstabelecimentoController;
	private Endereco estabelecimento;
	private Endereco entrega;
	private Endereco cobranca;
	private Email email;
	private Telefone telefone;
	private List<Endereco> listaEnderecos;
	private List<TipoDeEstabelecimento> listaTiposEstabelecimentos;
	private Cliente cliente;
	
	public ClienteMB(){}

	@PostConstruct
	public void init()
	{
		this.listaTiposEstabelecimentos = new ArrayList<>(getTipoDeEstabelecimentoController().findAllController());
		this.cliente = new Cliente();
		this.estabelecimento = new Endereco();
		this.entrega = new Endereco();
		this.cobranca = new Endereco();
		this.email = new Email();
		this.telefone = new Telefone();
	}
	
//	@PreDestroy
//	public void destroy()
//	{
//		this.cliente = null;
//		this.estabelecimento = null;
//		this.entrega = null;
//		this.cobranca = null;
//		this.email = null;
//		this.telefone = null;
//	}
	
	public void buildCliente()
	{
		estabelecimento.setUf("Minas Gerais");
		entrega.setUf("São Paulo");
		cobranca.setUf("Rio de Janeiro");
		estabelecimento.setCidade("Belo Horizonte");
		entrega.setCidade("São Paulo");
		cobranca.setCidade("Rio de Janeiro");
		listaEnderecos.add(estabelecimento);
		listaEnderecos.add(cobranca);
		listaEnderecos.add(entrega);
		this.cliente.setEmail(email);
		this.cliente.setTelefone(telefone);
		this.cliente.setEndereco(listaEnderecos);
	}
	
	public String salvarCliente()
	{
		buildCliente();
		getClienteController().saveController(this.cliente);
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
				"Inserção de Cliente Concluído", getCliente().getRazaoSocial());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        this.cliente = new Cliente();
        return "toSabores";
	}
	
	public void alterarCliente()
	{
		buildCliente();
		getClienteController().alterarController(this.cliente);
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
				"Alteração de Cliente Concluída", getCliente().getRazaoSocial());
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public String removerCliente()
	{
		getClienteController().deleteController(this.cliente);
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
				"Remoção de Cliente Concluída", getCliente().getRazaoSocial());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        init();
        return "refresh";
	}
	
	public void onRowEdit(RowEditEvent event) 
	{
		setCliente((Cliente) event.getObject());
		alterarCliente();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
        		"Cliente Editado", ((Cliente) event.getObject()).getRazaoSocial());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) 
    {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
        		"Edição de Cliente Cancelado", ((Cliente) event.getObject()).getRazaoSocial());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	public void exportarValoresEstabParaEntregaCobranca()
	{
		this.cobranca = this.estabelecimento;
		this.entrega = this.estabelecimento;
	}
	
	public Cliente getCliente()
	{
		return cliente;
	}

	public void setCliente(Cliente cliente)
	{
		this.cliente = cliente;
	}

	public EnderecoController getEnderecoController()
	{
		return enderecoController;
	}

	public ClienteController getClienteController()
	{
		return clienteController;
	}
	
	public TipoDeEstabelecimentoController getTipoDeEstabelecimentoController()
	{
		return tipoDeEstabelecimentoController;
	}
	
	public Endereco getEstabelecimento()
	{
		return estabelecimento;
	}

	public void setEstabelecimento(Endereco estabelecimento)
	{
		this.estabelecimento = estabelecimento;
	}

	public Endereco getEntrega()
	{
		return entrega;
	}

	public void setEntrega(Endereco entrega)
	{
		this.entrega = entrega;
	}

	public Endereco getCobranca()
	{
		return cobranca;
	}

	public void setCobranca(Endereco cobranca)
	{
		this.cobranca = cobranca;
	}

	public Email getEmail()
	{
		return email;
	}

	public void setEmail(Email email)
	{
		this.email = email;
	}

	public Telefone getTelefone()
	{
		return telefone;
	}

	public void setTelefone(Telefone telefone)
	{
		this.telefone = telefone;
	}
	
	public List<TipoDeEstabelecimento> getListaTiposEstabelecimentos()
	{
		return listaTiposEstabelecimentos;
	}
}
