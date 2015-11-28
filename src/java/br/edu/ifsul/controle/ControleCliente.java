package br.edu.ifsul.controle;

import br.edu.ifsul.dao.ClienteDAO;
import br.edu.ifsul.modelo.Cliente;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import br.edu.ifsul.converters.ConverterEmposse;

/**
 *
 * @author mlgross 
 */
@ManagedBean(name = "controleCliente")
@SessionScoped
public class ControleCliente implements Serializable{
    
    @EJB
    private ClienteDAO dao;
    private Cliente objeto;

    public ControleCliente() {
    }
    
    public String listar() {
        return "/privado/cliente/listar?faces-redirect=true";
    }    

    
    public String novo() {
        objeto = new Cliente();
        return "formulario";
    }

    public String salvar() {
        try {
            if (objeto.getCpf()== null) {
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso");
            return "listar";
        } catch (Exception e) {
            Util.mensagemErro("Erro ao persistir objeto: " + e.getMessage());
            return "formulario";
        }
    }

    public String cancelar() {
        objeto = null;
        return "listar";
    }

    public String editar(String id) {
        try {
            objeto = dao.getObjectById(id);
            return "formulario";
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar objeto: "+e.getMessage());
            return "listar";
        }
    }
    
    public void excluir(String id){
        try {
            objeto = dao.getObjectById(id);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso");
        } catch (Exception e){
            Util.mensagemErro("Erro ao remover objeto:"+Util.getMensagemErro(e));
        }
    }

    public ClienteDAO getDao() {
        return dao;
    }

    public void setDao(ClienteDAO dao) {
        this.dao = dao;
    }

    public Cliente getObjeto() {
        return objeto;
    }

    public void setObjeto(Cliente objeto) {
        this.objeto = objeto;
    }

}
