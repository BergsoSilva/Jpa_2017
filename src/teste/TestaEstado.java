package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Estado;
import util.JPAUtil;

public class TestaEstado {
    
    public static void main(String[] args) {
        
          
        EntityManager em = JPAUtil.getJPAUtil();
        
         Estado e = new Estado();
         e.setNome("amazonas");
         Estado e1 = new Estado();
         e1.setNome("sao paulo");
         Estado e2 = new Estado();
         e2.setNome("rio de janeiro");
         Estado e3 = new Estado();
         e3.setNome("brasilia");
         Estado e4 = new Estado();
         e4.setNome("Para");

         em.getTransaction().begin();
         em.persist(e);
         em.persist(e1);
         em.persist(e2);
         em.persist(e3);
         em.persist(e4);
         em.getTransaction().commit();

        
    }
    
}
