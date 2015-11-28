package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Compra;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author Marcelo
 */
@Stateless
public class CompraDAO implements Serializable{
    
    @PersistenceContext(unitName = "Revenda-WebPU")
    private EntityManager em;
    private List<Compra> listarTodos;

    public CompraDAO() {
    }
  
    public void persist(Compra objeto) throws Exception {
        em.persist(objeto);        
    }
    
    public void merge(Compra objeto) throws Exception {
        em.merge(objeto);
    }
    
    public void remove(Compra objeto) throws Exception{
        objeto = em.merge(objeto);
        em.remove(objeto);
    }
    
    public Compra getObjectById(Integer crv) throws Exception {
        return em.find(Compra.class, crv);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Compra> getListarTodos() {
        return em.createQuery("from Compra order by crv").getResultList();
    }

    public void setListarTodos(List<Compra> listarTodos) {
        this.listarTodos = listarTodos;
    }

}
