/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teste;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import modelo.Cidade;

/**
 *
 * @author Administrador
 */
public class TestaCidade {
     public static void main(String[] args) {
        Scanner pausa=new Scanner(System.in);
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("Framework230217PU");
        
        /* Cidade c=new Cidade();
         c.setNome("manacapuru");*/
         EntityManager em = emf.createEntityManager();
          
        // c.setEstado(em.getReference(Estado.class, 1L));
         Cidade c=em.find(Cidade.class,1L);
         c.setId(1L);
         em.getTransaction().begin();
         c.setNome("alterado");
         //Cidade cidadeManager =em.merge(c);
         em.getTransaction().commit();
        
        
        
        
        /*Cidade c1=new Cidade();
        c1.setNome("manaus");
        EntityManager em=JPAUtil.getJPAUtil();
        em.getTransaction().begin();
        em.persist(c1);
        em.getTransaction().rollback();
        
        Cidade c=new Cidade();
        c.setNome("alterado");
       
        pausa.nextLine();
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().rollback();
        
         /*Cidade c = new Cidade();
         c.setNome("manaus");
         Cidade c1 = new Cidade();
         c1.setNome("sao paulo");
         Cidade c2 = new Cidade();
         c2.setNome("rio de janeiro");
         Cidade c3 = new Cidade();
         c3.setNome("brasilia");
         Cidade c4 = new Cidade();
         c4.setNome("Para");

         em.getTransaction().begin();
         em.persist(c);
         em.persist(c1);
         em.persist(c2);
         em.persist(c3);
         em.persist(c4);
         em.getTransaction().commit();*/

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
        Query consulta = em.createQuery("SELECT c FROM Cidade c");
        List<Cidade> cidades = (List<Cidade>) consulta.getResultList();
        System.out.println("######################");
        System.out.println("Lista Original");
        System.out.println("######################");
        for(Cidade ca: cidades)  {
            System.out.println("Nome: " + ca);
        }
        
        
       /* em.getTransaction().begin();
        Pessoa p1 = em.find(Pessoa.class, 3L);
        em.remove(p1);
        em.getTransaction().commit();*/
        em.clear();
        em.close();
    
    }
}
