package br.com.sabores.web.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import br.com.sabores.ejb.model.Fabricante;
import br.com.sabores.web.control.FabricanteController;

@SuppressWarnings("serial")
@Named
@RequestScoped
public class FabricanteMB implements Serializable
{
	
	private Fabricante fabricante;
	private List<Fabricante> allFabricantes;
	
	@Inject
	private FabricanteController fabricanteController;
	
	public FabricanteMB(){}
	
	@PostConstruct
	public void init()
	{
		this.allFabricantes = getFabricanteController().findAllController();
		this.fabricante = new Fabricante();
	}
	
	public void salvarFabricante()
	{
		getFabricanteController().saveController(getFabricante());
	}
	
	public void alterarFabricante()
	{
		getFabricanteController().alterarController(getFabricante());
	}
	
	public void onRowEdit(RowEditEvent event) 
	{
		setFabricante((Fabricante) event.getObject());
		alterarFabricante();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
        		"Fabricante Editado", ((Fabricante) event.getObject()).getFabricante());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) 
    {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
        		"Edição de Categoria Cancelada", ((Fabricante) event.getObject()).getFabricante());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String removerFabricante()
	{
		getFabricanteController().deleteController(getFabricante());
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
				"Remoção de Fabricante Concluído", getFabricante().getFabricante());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "refresh";
	}
	
	public FabricanteController getFabricanteController()
	{
		return fabricanteController;
	}
	

	public Fabricante getFabricante()
	{
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante)
	{
		this.fabricante = fabricante;
	}

	public List<Fabricante> getAllFabricantes()
	{
		return allFabricantes;
	}
	
	public void setAllFabricantes(List<Fabricante> allFabricantes)
	{
		this.allFabricantes = allFabricantes;
	}
}
