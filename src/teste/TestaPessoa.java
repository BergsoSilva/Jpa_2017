/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teste;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import modelo.Pessoa;

/**
 *
 * @author Administrador
 */
public class TestaPessoa {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Framework230217PU");
        EntityManager em = emf.createEntityManager();
        
        /*
        Pessoa p = new Pessoa();
        p.setNome("Joao");
        p.setTelefone("3223-5698");
        Pessoa p1 = new Pessoa();
        p1.setNome("Adrea");
        p1.setTelefone("9999-9999");
        Pessoa p2 = new Pessoa();
        p2.setNome("Monica");
        p2.setTelefone("8888-8888");
        Pessoa p3 = new Pessoa();
        p3.setNome("Karine");
        p3.setTelefone("7777-7777");
        Pessoa p4 = new Pessoa();
        p4.setNome("Niquele");
        p4.setTelefone("6666-6666");
        
        /**
         * Persistindo Pessoa
         *//*
        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.persist(p4);
        em.getTransaction().commit();

        /**
         * Consultando Pessoa
         *//*
        em.getTransaction().begin();
        Pessoa p = em.find(Pessoa.class, 1L);
        System.out.println(p);
        em.getTransaction().commit();
        */
        
        /**
         * Lista Pessoas
         */
        Query consulta = em.createQuery("SELECT p FROM Pessoa p");
        List<Pessoa> pessoas = (List<Pessoa>) consulta.getResultList();
        System.out.println("######################");
        System.out.println("Lista Original");
        System.out.println("######################");
        for(Pessoa p: pessoas)  {
            System.out.println("Nome: " + p);
        }
        
        
        em.getTransaction().begin();
        Pessoa p1 = em.find(Pessoa.class, 3L);
        em.remove(p1);
        em.getTransaction().commit();
        
        
        /**
         * Lista Pessoas
         */
        Query consulta1 = em.createQuery("SELECT p FROM Pessoa p");
        List<Pessoa> pessoas1 = (List<Pessoa>) consulta1.getResultList();
        System.out.println("######################");
        System.out.println("Lista Alterada");
        System.out.println("######################");
        for(Pessoa a: pessoas1)  {
            System.out.println("Nome: " + a);
        }
        
        em.close();
        emf.close();
    }
    
}
