package br.edu.ifsul.converters;

import br.edu.ifsul.modelo.Reparador;
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
@FacesConverter(value = "converterReparador")
public class ConverterReparador implements Converter, Serializable {

    @PersistenceContext(unitName = "Revenda-WebPU")
    private EntityManager em;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null) {
            return null;
        }
        return em.find(Reparador.class, Integer.parseInt(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null) {
            return "";
        }
        Reparador obj = (Reparador) o;
        return obj.getPis().toString();  
    }

}
