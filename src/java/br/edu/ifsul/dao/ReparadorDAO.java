package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Reparador;
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
public class ReparadorDAO implements Serializable{
    
    @PersistenceContext(unitName = "Revenda-WebPU")
    private EntityManager em;
    private List<Reparador> listarTodos;

    public ReparadorDAO() {
    }
    
    public void persist(Reparador objeto) throws Exception {
        em.persist(objeto);        
    }
    
    public void merge(Reparador objeto) throws Exception {
        em.merge(objeto);
    }
    
    public void remove(Reparador objeto) throws Exception{
        objeto = em.merge(objeto);
        em.remove(objeto);
    }
    
    public Reparador getObjectById(Integer pis) throws Exception {
        return em.find(Reparador.class, pis);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Reparador> getListarTodos() {
        return em.createQuery("from Reparador order by pis").getResultList();
    }

    public List<Reparador> getListarTodosAtivos() {
        return em.createQuery("from Reparador where ativo=TRUE order by pis").getResultList();
    }
    
    public void setListarTodos(List<Reparador> listarTodos) {
        this.listarTodos = listarTodos;
    }
    
}
