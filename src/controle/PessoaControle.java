package controle;

import dao.DAOGenerico;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import modelo.Cidade;
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
    
    public List<Interesse> listaIteressePessoa() {
        
        EntityManager em = JPAUtil.getJPAUtil();
        Query consulta = em.createQuery(" select *from interesse i \n" +
                                        " left outer join pessoa_interesse pi on i.id= pi.interesses_id\n" +
                                         " left outer join pessoa p on pi.interesses_id=p.id");

        return consulta.getResultList();
        
   
    }
    
    public List<Pessoa> getPessoas(Pessoa pessoa,String order) {
        
        String jpql = "select p from Pessoa p  WHERE p.nome like :nomePessoa";
        
        String orderby= " order by p.nome ";
        
        EntityManager em = JPAUtil.getJPAUtil();
        
        Query query = em.createQuery(jpql+orderby+order);

        query.setParameter("nomePessoa", "%" +pessoa.getNome()+"%");
        
        return query.getResultList();
    }
    
    public Double mediaAritimetica(List<Pessoa> pessoasTabela){
        
         int soma=0;
        
        List<Cidade> filtro=new ArrayList<>();
        
       
        
        for (int i = 0; i < pessoasTabela.size(); i++) {
             if(!filtro.contains(pessoasTabela.get(i).getCidade()))
                  filtro.add(pessoasTabela.get(i).getCidade());
        }
       
        for (Cidade cidade : filtro) {
             soma=soma+cidade.getPopulacao();
        }
        
      
        
        return Double.valueOf(soma/filtro.size());
    }
      
}
