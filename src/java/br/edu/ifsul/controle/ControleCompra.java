package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CarroDAO;
import br.edu.ifsul.dao.ClienteDAO;
import br.edu.ifsul.dao.CompraDAO;
import br.edu.ifsul.dao.NegociadorDAO;
import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Cliente;
import br.edu.ifsul.modelo.Compra;
import br.edu.ifsul.modelo.Negociador;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author mlgross
 */
@ManagedBean(name = "controleCompra")
@SessionScoped
public class ControleCompra implements Serializable {

    @EJB
    private CompraDAO dao;
    private Compra objeto;
    @EJB
    private CarroDAO daoCarro;
    private Carro carro;
    @EJB
    private NegociadorDAO daoNegociador;
    private Negociador negociador;
    @EJB
    private ClienteDAO daoCliente;
    private Cliente cliente;

    public ControleCompra() {
    }

    public String listar() {
        return "/privado/compra/listar?faces-redirect=true";
    }

    public String novo() {
        objeto = new Compra();
        return "formulario";
    }

    public String cancelar() {
        objeto = null;
        return "listar";
    }

    public String salvar() {
        try {
            if (objeto.getCrv() == null) {
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

    public String editar(Integer crv) {
        try {
            objeto = dao.getObjectById(crv);
            return "formulario";
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar objeto: " + e.getMessage());
            return "listar";
        }
    }

    public String excluir(Integer crv) {
        try {
            System.out.println(crv);
            Compra compra = dao.getEm().find(Compra.class, crv);
            System.out.println(compra.getCrv());
            dao.remove(compra);
            Util.mensagemInformacao("Objeto removido com sucesso");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao remover objeto:" + Util.getMensagemErro(e));
        }
        return "listar";
    }

    public CompraDAO getDao() {
        return dao;
    }

    public void setDao(CompraDAO dao) {
        this.dao = dao;
    }

    public Compra getObjeto() {
        return objeto;
    }

    public void setObjeto(Compra objeto) {
        this.objeto = objeto;
    }

    public CarroDAO getDaoCarro() {
        return daoCarro;
    }

    public void setDaoCarro(CarroDAO daoCarro) {
        this.daoCarro = daoCarro;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public NegociadorDAO getDaoNegociador() {
        return daoNegociador;
    }

    public void setDaoNegociador(NegociadorDAO daoNegociador) {
        this.daoNegociador = daoNegociador;
    }

    public Negociador getNegociador() {
        return negociador;
    }

    public void setNegociador(Negociador negociador) {
        this.negociador = negociador;
    }

    public ClienteDAO getDaoCliente() {
        return daoCliente;
    }

    public void setDaoCliente(ClienteDAO daoCliente) {
        this.daoCliente = daoCliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
