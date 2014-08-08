//package br.com.sabores.ejb.reports;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//import javax.annotation.PostConstruct;
//import javax.ejb.EJB;
//import javax.ejb.Stateless;
//
//import net.sf.jasperreports.engine.JRDataSource;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JRField;
//import br.com.sabores.ejb.facade.CategoriaFacade;
//import br.com.sabores.ejb.model.Categoria;
//
//@Stateless
//public class CategoriaReports implements JRDataSource {
//
//	@EJB
//	private CategoriaFacade categoriaFacade;
//	
//	private List<Categoria> categorias;
//	
//	private List<Long> codigo;
//	private List<String> categoria;
//	
//	public void buildListasReport(){
//		this.codigo = new ArrayList<>(this.categorias.size());
//		this.categoria = new ArrayList<>(this.categorias.size());
//		for (Categoria cat : this.categorias)
//		{
//			codigo.add(cat.getId());
//			categoria.add(cat.getCategoria());
//		}
//	}
//	
//	@PostConstruct
//	public void init(){
//		this.categorias = categoriaFacade.buscarTodosOsRegistros();
//		buildListasReport();
//	}
//	
//	public CategoriaReports(){}
//	
//	/**
//	 * Variable to store how much records were read
//	 */
//	private int counter = -1;
//	
//	/**
//	 * Variables to store the number of fields, and their names, in the report
//	 */
//	private HashMap<String, Integer> fieldsNumber = new HashMap<String, Integer>();
//	
//	/**
//	 * Method used to know if there are records to read.
//	 */
//	private int lastFieldsAdded = 0;
//	
//	@Override
//	public boolean next() throws JRException {
//		if (counter < this.categorias.size()-1) {
//			counter++;
//			return true;
//		}
//		return false;
//	}
//
//	/**
//	 * This method is called for every field defined in the report. So if i have 2 fields it is called 2 times for every record, and 
//	 * for each of them it must provide a value.
//	 * The parameter can be used to understand for which field is requested, in fact it contains the name of the requested field. This 
//	 * data adapter is done with the goal of return two values, a name and an age. An easy option would be expect a field with the name 
//	 * "Name" and one with name "Age". But we can do something more flexible, in this case we will enumerate all the fields requested and 
//	 * and the first two will be assumed to be for name and age, for all the others will be returned an empty string. So we can have a report 
//	 * with more than two fields, but the name and the age will be returned each time only for the first two. 
//	 * 
//	 * If this example is too much complex refer to the method getFieldValue2, where is shown the first explained, and simple solution, where we 
//	 * expect two fields with a precise name.
//	 */
//	@Override
//	public Object getFieldValue(JRField jrField) throws JRException {
//		Integer fieldIndex;
//		if (fieldsNumber.containsKey(jrField.getName()))
//			fieldIndex = fieldsNumber.get(jrField.getName());
//		else {
//			fieldsNumber.put(jrField.getName(), lastFieldsAdded);
//			fieldIndex = lastFieldsAdded;
//			lastFieldsAdded ++;
//		}
//		if (fieldIndex == 0) return this.codigo.get(counter);
//		else if (fieldIndex == 1) return this.categoria.get(counter);
//		return "";
//	}
//	
////	/**
////	 * Example of a simpler getFieldValue, not actually used
////	 */
////	public Object getFieldValue2(JRField jrField) throws JRException {
////		if (jrField.getName().equals("Name")) return nameArray[counter];
////		else if (jrField.getName().equals("Age")) return ageArray[counter];
////		return "";
////	}
//	
//	/**
//	 * Return an instance of the class that implements the custom data adapter.
//	 */
//	public static JRDataSource getDataSource(){
//		return new CategoriaReports();
//	}
//	
//	public CategoriaFacade getCategoriaFacade()
//	{
//		return categoriaFacade;
//	}
//	
//	public List<Categoria> getCategorias()
//	{
//		return categorias;
//	}
//	
//	public List<String> getCategoria()
//	{
//		return categoria;
//	}
//	
//	public List<Long> getCodigo()
//	{
//		return codigo;
//	}
//}
