package controle;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import modelo.Pessoa;
import util.JPAUtil;

public class PessoaDAO {
    
    EntityManager gerenciador;
    DAOGenerico<Pessoa> dao;

    public PessoaDAO(EntityManager gerenciador) {
        this.gerenciador = gerenciador;
        this.dao = new DAOGenerico<>(gerenciador, Pessoa.class);
    }
    
    public void inserir(Pessoa pessoa)    {
        dao.inserir(pessoa);
    }
    
    public void excluir(Pessoa pessoa)    {
        pessoa = gerenciador.find(Pessoa.class, pessoa.getId());
        dao.excluir(pessoa);
    }
    public void alterar(Pessoa pessoa){
        dao.alterar(pessoa);
    }
    
    public Pessoa visualizar(Pessoa pessoa)  {
        pessoa = gerenciador.find(Pessoa.class, pessoa.getId());
        return dao.visualizar(pessoa.getId());
    }
    
    public List<Pessoa> listar()   {
        return dao.listar();
    }
    
    public Double calcularMedia(Pessoa pessoa){
        EntityManager em = JPAUtil.getJPAUtil();
      
        TypedQuery<Double> consulta = gerenciador.createQuery("select distinct avg(p.cidade.populacao) from Pessoa p ", Double.class);
        
       
       
        Double media = consulta.getSingleResult();
        return media;
    }
}
