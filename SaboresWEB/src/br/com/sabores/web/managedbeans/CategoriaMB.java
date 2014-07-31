package br.com.sabores.web.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import br.com.sabores.ejb.model.Categoria;
import br.com.sabores.web.control.CategoriaController;

@SuppressWarnings("serial")
@Named
@SessionScoped
public class CategoriaMB implements Serializable
{
	private Categoria categoria;
	private List<Categoria> allCategorias;
	
	public CategoriaMB(){}
	
	@Inject
	private CategoriaController categoriaController;
	
	
	@PostConstruct
	public void init()
	{
		this.allCategorias = getCategoriaController().findAllController();
		this.categoria = new Categoria();
	}
	
	public void show(ActionEvent event)
	{
		setMostrarNova(true);
	}
	
	public void alterarCategoria()
	{
		categoriaController.alterarController(getCategoria());
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
				"Alteração de Categoria Concluída", getCategoria().getCategoria());
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void onRowEdit(RowEditEvent event) 
	{
		setCategoria((Categoria) event.getObject());
		alterarCategoria();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
        		"Categoria Editada", ((Categoria) event.getObject()).getCategoria());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) 
    {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
        		"Edição de Categoria Cancelada", ((Categoria) event.getObject()).getCategoria());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    private Boolean mostrarNova;
    
	public void salvarCategoria()
	{
		getCategoriaController().saveController(getCategoria());
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
				"Inserção de Categoria Concluída", getCategoria().getCategoria());
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public String removerCategoria()
	{
		getCategoriaController().deleteController(this.categoria);
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
				"Remoção de Categoria Concluída", getCategoria().getCategoria());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "refresh";
	}
	
	public Categoria getCategoria()
	{
		return categoria;
	}
	
	public void setCategoria(Categoria categoria)
	{
		this.categoria = categoria;
	}
	
	public CategoriaController getCategoriaController()
	{
		return categoriaController;
	}

	public List<Categoria> getAllCategorias()
	{
		return allCategorias;
	}

	public void setAllCategorias(List<Categoria> allCategorias)
	{
		this.allCategorias = allCategorias;
	}

	public Boolean getMostrarNova()
	{
		return mostrarNova;
	}

	public void setMostrarNova(Boolean mostrarNova)
	{
		this.mostrarNova = mostrarNova;
	}

	
}
