package br.edu.ifsul.util;

import br.edu.ifsul.modelo.Compra;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mlgross
 */
public class TesteCompraDAO implements Serializable {

    public static void main(String[] args) {

        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("Revenda-ModelPU");
        EntityManager em = emf.createEntityManager();
      
        em.getTransaction().begin();
        Compra Objeto = em.find(Compra.class, 335353454);
        em.remove(Objeto);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
