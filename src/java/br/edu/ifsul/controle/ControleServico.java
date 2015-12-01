package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CarroDAO;
import br.edu.ifsul.dao.ReparadorDAO;
import br.edu.ifsul.dao.ServicoDAO;
import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Reparador;
import br.edu.ifsul.modelo.Servico;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author mlgross
 */
@ManagedBean(name = "controleServico")
@SessionScoped
public class ControleServico implements Serializable {

    @EJB
    private ServicoDAO dao;
    private Servico objeto;
    @EJB
    private ReparadorDAO daoReparador;
    private Reparador reparador;
    @EJB
    private CarroDAO daoCarro;
    private Carro carro;

    public ControleServico() {
    }

    public String listar() {
        return "/privado/servico/listar?faces-redirect=true";
    }

    public String novo() {
        objeto = new Servico();
        return "formulario";
    }

    public String cancelar() {
        objeto = null;
        return "listar";
    }

    public String salvar() {
        try {
            if (objeto.getNumero() == null) {
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

    public String editar(Integer numero) {
        try {
            objeto = dao.getObjectById(numero);
            return "formulario";
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar objeto: " + e.getMessage());
            return "listar";
        }
    }

    public void excluir(Integer numero) {
        try {
            objeto = dao.getObjectById(numero);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao remover objeto:" + Util.getMensagemErro(e));
        }
    }

    public ServicoDAO getDao() {
        return dao;
    }

    public void setDao(ServicoDAO dao) {
        this.dao = dao;
    }

    public Servico getObjeto() {
        return objeto;
    }

    public void setObjeto(Servico objeto) {
        this.objeto = objeto;
    }

    public ReparadorDAO getDaoReparador() {
        return daoReparador;
    }

    public void setDaoReparador(ReparadorDAO daoReparador) {
        this.daoReparador = daoReparador;
    }

    public CarroDAO getDaoCarro() {
        return daoCarro;
    }

    public void setDaoCarro(CarroDAO daoCarro) {
        this.daoCarro = daoCarro;
    }

    public Reparador getReparador() {
        return reparador;
    }

    public void setReparador(Reparador reparador) {
        this.reparador = reparador;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

}
