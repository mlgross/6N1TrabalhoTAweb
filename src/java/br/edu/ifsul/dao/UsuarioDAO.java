package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Usuario;
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
public class UsuarioDAO implements Serializable{
    
    @PersistenceContext(unitName = "Revenda-WebPU")
    private EntityManager em;
    private List<Usuario> listarTodos;

    public UsuarioDAO() {
    }

    public void persist(Usuario objeto) throws Exception {
        em.persist(objeto);
    }

    public void merge(Usuario objeto) throws Exception {
        em.merge(objeto);
    }

    public void remove(Usuario objeto) throws Exception {
        objeto = em.merge(objeto);
        em.remove(objeto);
    }

    public Usuario getObjectById(Integer id) throws Exception {
        return em.find(Usuario.class, id);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Usuario> getListarTodos() {
        return em.createQuery("from Usuario order by id").getResultList();
    }

    public void setListarTodos(List<Usuario> listarTodos) {
        this.listarTodos = listarTodos;
    }
}
