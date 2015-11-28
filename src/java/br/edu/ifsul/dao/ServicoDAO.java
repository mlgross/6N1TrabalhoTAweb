package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Servico;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mlgross
 */
@Stateless
public class ServicoDAO implements Serializable{
    
    @PersistenceContext(unitName = "Revenda-WebPU")
    private EntityManager em;
    private List<ServicoDAO> listarTodos;

    public ServicoDAO() {
    }
 
    public void persist(Servico objeto) throws Exception {
        em.persist(objeto);
    }

    public void merge(Servico objeto) throws Exception {
        em.merge(objeto);
    }

    public void remove(Servico objeto) throws Exception {
        objeto = em.merge(objeto);
        em.remove(objeto);
    }

    public Servico getObjectById(Integer numero) throws Exception {
        return em.find(Servico.class, numero);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<ServicoDAO> getListarTodos() {
        return listarTodos;
    }

    public void setListarTodos(List<ServicoDAO> listarTodos) {
        this.listarTodos = listarTodos;
    }
    
}
