package br.edu.ifsul.controle;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author mlgross 
 */
@ManagedBean(name = "controleCarro")
@SessionScoped
public class ControleCarro implements Serializable{

    public ControleCarro() {
    }
    
    public String listar() {
        return "/privado/cidade/listar?faces-redirect=true";
    }
}
