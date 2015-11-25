package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Carro;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mlgross 
 */
public class CarroDAO implements Serializable{
    
    @PersistenceContext(unitName = "Revenda-WebPU")
    private EntityManager em;
    private List<Carro> listarTodos;

    public CarroDAO() {
    }

    public void persist(Carro objeto) throws Exception {
        em.persist(objeto);        
    }
    
    public void merge(Carro objeto) throws Exception {
        em.merge(objeto);
    }
    
    public void remove(Carro objeto) throws Exception{
        objeto = em.merge(objeto);
        em.remove(objeto);
    }
    
    public Carro getObjectById(Integer id) throws Exception {
        return em.find(Carro.class, id);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Carro> getListarTodos() {
        return em.createQuery("from Carro order by renavan").getResultList();
    }

    public void setListarTodos(List<Carro> listarTodos) {
        this.listarTodos = listarTodos;
    }

}