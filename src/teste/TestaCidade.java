/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teste;

import controle.CidadeControle;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import modelo.Cidade;
import modelo.Estado;
import util.JPAUtil;

/**
 *
 * @author Administrador
 */
public class TestaCidade {
     public static void main(String[] args) {
        
       EntityManager em=JPAUtil.getJPAUtil();
        
//        Cidade c1=new Cidade();
//        c1.setNome("Novo Aira");
//        c1.setEstado(e);
//        em.getTransaction().begin();
//        em.persist(c1);
//        em.getTransaction().rollback();
//        
        
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
        
        /* Não precisa fazer cach
        TypedQuery<Cidade> consulta = em.createQuery("SELECT c FROM Cidade c",Cidade.class);
        List<Cidade> cidades = consulta.getResultList();
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
        
        //Query consulta = em.createQuery("SELECT avg(c.populacao) FROM Cidade c");
        Query consulta = em.createNamedQuery("Cidade.MediaPopulacao",Double.class);
        Double soma =(Double) consulta.getSingleResult();
        
        System.out.println("MEDIA DA POPULAÇÃO "+soma);
        
        
       
    }
}
