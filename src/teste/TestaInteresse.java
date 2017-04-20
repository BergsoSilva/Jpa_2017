package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Estado;
import modelo.Interesse;
import util.JPAUtil;

public class TestaInteresse {
    
    public static void main(String[] args) {
        
          
        EntityManager em = JPAUtil.getJPAUtil();
        
         Interesse e = new Interesse();
         e.setDescricao("futebol");
         Interesse e1 = new Interesse();
         e1.setDescricao("video game");
         Interesse e2 = new Interesse();
         e2.setDescricao("lutas");
         Interesse e3 = new Interesse();
         e3.setDescricao("musica");
         Interesse e4 = new Interesse();
         e4.setDescricao("cinema");

         em.getTransaction().begin();
         em.persist(e);
         em.persist(e1);
         em.persist(e2);
         em.persist(e3);
         em.persist(e4);
         em.getTransaction().commit();

        
    }
    
}
