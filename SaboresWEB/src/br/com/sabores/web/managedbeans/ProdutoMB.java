package br.com.sabores.web.managedbeans;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.component.api.UIColumn;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.UploadedFile;

import br.com.sabores.ejb.model.Categoria;
import br.com.sabores.ejb.model.Fabricante;
import br.com.sabores.ejb.model.Produto;
import br.com.sabores.web.control.CategoriaController;
import br.com.sabores.web.control.FabricanteController;
import br.com.sabores.web.control.ProdutoController;

@SuppressWarnings("serial")
@Named
@RequestScoped
public class ProdutoMB implements Serializable
{
	private Produto produto;
	private List<Produto> allProdutos;
	private List<Categoria> allCategorias;
	private List<Fabricante> allFabricante;
	private Boolean mostrarNova;
	private Boolean mostrarGraphicImage;
	
	@Inject
	private ProdutoController produtoController;
	@Inject
	private CategoriaController categoriaController;
	@Inject
	private FabricanteController fabricanteController;
	
	public ProdutoMB(){}
	
	@PostConstruct
	public void init()
	{
		this.allProdutos = getProdutoController().findAllController();
		this.allCategorias = getCategoriaController().findAllController();
		this.allFabricante = getFabricanteController().findAllController();
		this.produto = new Produto();
	}
	
	@PreDestroy
	public void destroy()
	{
		this.produto = null;
		allProdutos.clear();
		allProdutos = null;
	}
	
	public void show(ActionEvent event)
	{
		setMostrarNova(true);
	}
	
	public void onCellEdit(CellEditEvent event) 
	{
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();
		
        UIColumn uicolumn = event.getColumn();
        if(uicolumn.getHeaderText().equals("Editar Estoque"))
        {
        	this.produto.setEstoque((Short)newValue);
        	alterarProduto();
        } 
        else if(uicolumn.getHeaderText().equals("Editar Preço"))
        {
        	this.produto.setPreco((Double)newValue);
        	alterarProduto();
        }
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Célula Alterada", "Valor Anterior: " + oldValue + ", Valor Alterado:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
	
	public void onRowEdit(RowEditEvent event) 
	{
		setProduto((Produto) event.getObject());
		alterarProduto();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
        		"Produto Editado", ((Produto) event.getObject()).getProduto());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) 
    {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
        		"Edição de Produto Cancelada", ((Produto) event.getObject()).getProduto());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void fotoDoProdutoHandler(FileUploadEvent event) throws IOException
    {
		FacesMessage message = new FacesMessage("Sucesso", event.getFile().getFileName() + " Foto Carregada.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        this.produto.setFotoDoProduto(event.getFile().getContents());
        UploadedFile upFile = event.getFile();
        setarFotoParaExibicao(upFile);
	}
    
    private void setarFotoParaExibicao(UploadedFile upFile) throws IOException 
    {
        this.produto.setFoto(null);
        byte[] bytes = upFile.getContents();
        String nome = upFile.getFileName(); 
        String formato = upFile.getContentType();
        InputStream stream = new ByteArrayInputStream(bytes);
        stream.read(bytes);
       
        this.produto.setFoto(new DefaultStreamedContent(stream, formato, nome));
    }
    
    public void alterarProduto()
	{
		produtoController.alterarController(this.produto);
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
				"Alteração de Produto Concluída", getProduto().getProduto());
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void salvarProduto()
	{
		getProdutoController().saveController(this.produto);
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
				"Inserção de Produto Concluída", getProduto().getProduto());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        this.produto = new Produto();
	}
	
	public String removerProduto()
	{
		getProdutoController().deleteController(this.produto);
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
				"Remoção de Produto Concluída", getProduto().getProduto());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        init();
        return "refresh";
	}
	
	public Produto getProduto()
	{
		return produto;
	}
	
	public void setProduto(Produto produto)
	{
		this.produto = produto;
	}
	
	public ProdutoController getProdutoController()
	{
		return produtoController;
	}

	public List<Produto> getAllProdutos()
	{
		return allProdutos;
	}

	public void setAllProdutos(List<Produto> allProdutos)
	{
		this.allProdutos = allProdutos;
	}

	public Boolean getMostrarNova()
	{
		return mostrarNova;
	}

	public void setMostrarNova(Boolean mostrarNova)
	{
		this.mostrarNova = mostrarNova;
	}

	public FabricanteController getFabricanteController()
	{
		return fabricanteController;
	}
	
	public CategoriaController getCategoriaController()
	{
		return categoriaController;
	}
	
	public List<Fabricante> getAllFabricante()
	{
		return allFabricante;
	}
	
	public List<Categoria> getAllCategorias()
	{
		return allCategorias;
	}

	public Boolean getMostrarGraphicImage()
	{
		return mostrarGraphicImage;
	}
	
	public void setMostrarGraphicImage(Boolean mostrarGraphicImage)
	{
		this.mostrarGraphicImage = mostrarGraphicImage;
	}
}
