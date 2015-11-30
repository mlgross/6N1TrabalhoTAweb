package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Negociador;
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
public class NegociadorDAO implements Serializable {

    @PersistenceContext(unitName = "Revenda-WebPU")
    private EntityManager em;
    private List<Negociador> listarTodos;

    public NegociadorDAO() {
    }

    public void persist(Negociador objeto) throws Exception {
        em.persist(objeto);
    }

    public void merge(Negociador objeto) throws Exception {
        em.merge(objeto);
    }

    public void remove(Negociador objeto) throws Exception {
        objeto = em.merge(objeto);
        em.remove(objeto);
    }

    public Negociador getObjectById(Integer pis) throws Exception {
        return em.find(Negociador.class, pis);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Negociador> getListarTodos() {
        return em.createQuery("from Negociador order by pis").getResultList();
    }

    public void setListarTodos(List<Negociador> listarTodos) {
        this.listarTodos = listarTodos;
    }
}
