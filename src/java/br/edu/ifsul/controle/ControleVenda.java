package br.edu.ifsul.controle;

import br.edu.ifsul.dao.CarroDAO;
import br.edu.ifsul.dao.ClienteDAO;
import br.edu.ifsul.dao.VendaDAO;
import br.edu.ifsul.dao.NegociadorDAO;
import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Cliente;
import br.edu.ifsul.modelo.Venda;
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
@ManagedBean(name = "controleVenda")
@SessionScoped
public class ControleVenda implements Serializable{

    @EJB
    private VendaDAO dao;
    private Venda objeto;
    @EJB
    private CarroDAO daoCarro;
    private Carro carro;
    @EJB
    private NegociadorDAO daoNegociador;
    private Negociador negociador;
    @EJB
    private ClienteDAO daoCliente;
    private Cliente cliente;

    public ControleVenda() {
    }

    public String listar() {
        return "/privado/venda/listar?faces-redirect=true";
    }

    public String novo() {
        objeto = new Venda();
        return "formulario";
    }

    public String cancelar() {
        objeto = null;
        return "listar";
    }

    public String salvar() {
        try {
            if (objeto.getNf()== null) {
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

    public String editar(Integer nf) {
        try {
            objeto = dao.getObjectById(nf);
            return "formulario";
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar objeto: " + e.getMessage());
            return "listar";
        }
    }

    public String excluir(Integer nf) {
        try {
            Venda venda = dao.getEm().find(Venda.class, nf);
            dao.remove(venda);
            Util.mensagemInformacao("Objeto removido com sucesso");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao remover objeto:" + Util.getMensagemErro(e));
        }
        return "listar";
    }

    public VendaDAO getDao() {
        return dao;
    }

    public void setDao(VendaDAO dao) {
        this.dao = dao;
    }

    public Venda getObjeto() {
        return objeto;
    }

    public void setObjeto(Venda objeto) {
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




