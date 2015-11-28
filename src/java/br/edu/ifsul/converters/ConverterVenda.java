package br.edu.ifsul.converters;

import br.edu.ifsul.modelo.Venda;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mlgross
 */
@FacesConverter(value = "converterVenda")
public class ConverterVenda implements Converter, Serializable{
  
    @PersistenceContext(unitName = "Revenda-WebPU")
    private EntityManager em;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null) {
            return null;
        }
        return em.find(Venda.class, Integer.parseInt(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null) {
            return null;
        }
        Venda obj = (Venda) o;
        return obj.getNf().toString();
    }
    
}
