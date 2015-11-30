package br.edu.ifsul.controle;

import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import br.edu.ifsul.dao.NegociadorDAO;
import br.edu.ifsul.modelo.Negociador;

/**
 *
 * @author mlgross
 */
@ManagedBean(name = "controleNegociador")
@SessionScoped
public class ControleNegociador implements Serializable{
    
    @EJB
    private NegociadorDAO dao;
    private Negociador objeto;

    public ControleNegociador() {
    }
    
    public String listar() {
        return "/privado/negociador/listar?faces-redirect=true";
    }    
    
    public String novo() {
        objeto = new Negociador();
        return "formulario";
    }
    
    public String salvar() {
        try {
            if (objeto.getPis()== null) {
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

    public String editar(Integer pis) {
        try {
            objeto = dao.getObjectById(pis);
            return "formulario";
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar objeto: "+e.getMessage());
            return "listar";
        }
    }
    
    public void excluir(Integer pis){
        try {
            objeto = dao.getObjectById(pis);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso");
        } catch (Exception e){
            Util.mensagemErro("Erro ao remover objeto:"+Util.getMensagemErro(e));
        }
    }

    public NegociadorDAO getDao() {
        return dao;
    }

    public void setDao(NegociadorDAO dao) {
        this.dao = dao;
    }

    public Negociador getObjeto() {
        return objeto;
    }

    public void setObjeto(Negociador objeto) {
        this.objeto = objeto;
    }
    
    
}
