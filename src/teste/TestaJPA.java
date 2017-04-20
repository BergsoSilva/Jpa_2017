/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Administrador
 */
public class TestaJPA {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Framework230217PU");
        
        EntityManager em = emf.createEntityManager();
        
        System.out.println("Gerenciador de Entidade: " + em.toString());
        
        System.out.println("Fábrica de Entidade: " + emf.toString());
        
        em.close();
        
        emf.close();
        
    }
    
}
