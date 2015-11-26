package br.edu.ifsul.controle;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author mlgross 
 */
@ManagedBean(name = "controlePrincipal")
@ViewScoped
public class ControlePrincipal implements Serializable{

    public ControlePrincipal() {
    }
    /**
     * Preparar para login
     * @return 
     */
    public String home() {       
        return "/index?faces-redirect=true";
    }
    
}
