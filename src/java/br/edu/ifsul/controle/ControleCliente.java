package br.edu.ifsul.controle;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author mlgross 
 */
@ManagedBean(name = "controleCliente")
@SessionScoped
public class ControleCliente implements Serializable{

    public ControleCliente() {
    }
    
    public String listar() {
        return "/privado/cidade/listar?faces-redirect=true";
    }    
    
}
