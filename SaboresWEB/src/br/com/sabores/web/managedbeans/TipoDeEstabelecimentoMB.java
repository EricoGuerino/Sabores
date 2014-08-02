package br.com.sabores.web.managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import br.com.sabores.ejb.model.TipoDeEstabelecimento;
import br.com.sabores.web.control.TipoDeEstabelecimentoController;

@Named("tipoDeEstabelecimentoMB")
@RequestScoped
public class TipoDeEstabelecimentoMB
{
	private TipoDeEstabelecimento tipoDeEstabelecimento;
	private List<TipoDeEstabelecimento> allTiposEstabelecimentos;
	
	@Inject
	private TipoDeEstabelecimentoController tipoEstabelecimentoController;
	
	public TipoDeEstabelecimentoMB(){}
	
	@PostConstruct
	public void init()
	{
		this.allTiposEstabelecimentos = tipoEstabelecimentoController.findAllController();
		this.tipoDeEstabelecimento = new TipoDeEstabelecimento();
	}
	
	@PreDestroy
	public void destroy()
	{
		this.tipoDeEstabelecimento = null;
		allTiposEstabelecimentos.clear();
		allTiposEstabelecimentos = null;
	}
	
	public void alterarTipoDeEstabelecimento()
	{
		getTipoEstabelecimentoController().alterarController(this.tipoDeEstabelecimento);
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
				"Alteração de Tipo de Estabelecimento Concluída", getTipoDeEstabelecimento().getTipoDeEstabelecimento());
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void onRowEdit(RowEditEvent event) 
	{
		setTipoDeEstabelecimento((TipoDeEstabelecimento) event.getObject());
		alterarTipoDeEstabelecimento();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
        		"Tipo de Estabelecimento Editada", ((TipoDeEstabelecimento) event.getObject()).getTipoDeEstabelecimento());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) 
    {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
        		"Edição de Tipo de Estabelecimento Cancelada", ((TipoDeEstabelecimento) event.getObject()).getTipoDeEstabelecimento());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    
	public void salvarTipoDeEstabelecimento()
	{
		getTipoEstabelecimentoController().saveController(this.tipoDeEstabelecimento);
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
				"Inserção de Tipo de Estabelecimento Concluída", getTipoDeEstabelecimento().getTipoDeEstabelecimento());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        this.tipoDeEstabelecimento = new TipoDeEstabelecimento();
	}
	
	public String removerTipoDeEstabelecimento()
	{
		getTipoEstabelecimentoController().deleteController(this.tipoDeEstabelecimento);
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
				"Remoção de Tipo de Estabelecimento Concluída", getTipoDeEstabelecimento().getTipoDeEstabelecimento());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        init();
        return "refresh";
	}
	
	public TipoDeEstabelecimento getTipoDeEstabelecimento()
	{
		return tipoDeEstabelecimento;
	}
	
	public void setTipoDeEstabelecimento(TipoDeEstabelecimento tipoDeEstabelecimento)
	{
		this.tipoDeEstabelecimento = tipoDeEstabelecimento;
	}
	
	public List<TipoDeEstabelecimento> getAllTiposEstabelecimentos()
	{
		return allTiposEstabelecimentos;
	}
	
	public TipoDeEstabelecimentoController getTipoEstabelecimentoController()
	{
		return tipoEstabelecimentoController;
	}
}
