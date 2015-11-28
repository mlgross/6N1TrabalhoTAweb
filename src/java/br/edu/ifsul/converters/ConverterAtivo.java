package br.edu.ifsul.converters;

import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author mlgross
 */
@FacesConverter(value = "converterAtivo")
public class ConverterAtivo implements Converter, Serializable{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null) {
            return null;
        }
        try {
            if (string.equalsIgnoreCase("Ativo")) {
                return Boolean.TRUE;
            }
            if (string.equalsIgnoreCase("Inativo")) {
                return Boolean.FALSE;
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Boolean obj = (Boolean) o;
        if (obj == Boolean.TRUE) {
            return "Sim";
        }
        if (obj == Boolean.FALSE) {
            return "Não";
        }
        return "";
    }
    
}
