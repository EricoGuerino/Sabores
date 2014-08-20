package br.com.sabores.web.control;

import java.util.List;
import java.util.Locale;


public abstract class AbstractController
{
	private List<?> filteredValue;
	
	public List<?> getFilteredValue()
	{
		return filteredValue;
	}
		
	public void setFilteredValue(List<?> filteredValue)
	{
		this.filteredValue = filteredValue;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean filterByPrice(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if(filterText == null||filterText.equals("")) {
            return true;
        }
         
        if(value == null) {
            return false;
        }
         
        return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
    }
}
