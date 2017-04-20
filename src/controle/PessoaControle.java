package controle;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Interesse;
import modelo.Pessoa;
import util.JPAUtil;

public class PessoaControle {

    public PessoaControle() {
    }

    public void inserir(Pessoa p)   {
        EntityManager em = JPAUtil.getJPAUtil();
        em.getTransaction().begin();
        DAOGenerico<Pessoa> dao = new DAOGenerico<Pessoa>(em,Pessoa.class);
        dao.inserir(p);
        em.getTransaction().commit();
        em.close();
    }
    
    public void alterar(Pessoa p)   {
        EntityManager em = JPAUtil.getJPAUtil();
        em.getTransaction().begin();
        DAOGenerico<Pessoa> dao = new DAOGenerico<Pessoa>(em,Pessoa.class);
        Pessoa pessoa=new Pessoa();
       
        dao.alterar(p);
        em.getTransaction().commit();
        em.close();
    }
    
    public void excluir(Pessoa p)   {
        EntityManager em = JPAUtil.getJPAUtil();
        em.getTransaction().begin();
        DAOGenerico<Pessoa> dao = new DAOGenerico<Pessoa>(em,Pessoa.class);
        p = dao.visualizar(p.getId());
        dao.excluir(p);
        em.getTransaction().commit();
        em.close();
    }
   
    public Pessoa visualizar(Pessoa p)   {
        Pessoa pessoa = new Pessoa();
        EntityManager em = JPAUtil.getJPAUtil();
        em.getTransaction().begin();
        DAOGenerico<Pessoa> dao = new DAOGenerico<Pessoa>(em,Pessoa.class);
        pessoa = dao.visualizar(p.getId());
        em.getTransaction().commit();
        em.close();
        return pessoa;
    }
    
    public List<Pessoa> listar()   {
        List<Pessoa> pessoas = new ArrayList<>();
        EntityManager em = JPAUtil.getJPAUtil();
        em.getTransaction().begin();
        DAOGenerico<Pessoa> dao = new DAOGenerico<Pessoa>(em,Pessoa.class);
        pessoas = dao.listar();
        em.getTransaction().commit();
        em.close();
        return pessoas;
        
    }
    
    public List<Interesse> listaIteresse() {
        
        EntityManager em = JPAUtil.getJPAUtil();
        Query consulta = em.createQuery("select i from Interesse i");

        return consulta.getResultList();
    }
      
      
}
