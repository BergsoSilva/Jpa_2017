package controle;

import dao.DAOGenerico;
import java.util.List;
import javax.persistence.EntityManager;
import modelo.Cidade;


public class CidadeDAO {
    
    EntityManager gerenciador;
    DAOGenerico<Cidade> dao;
    
    public CidadeDAO(EntityManager gerenciador)  {
        this.gerenciador = gerenciador;
        this.dao = new DAOGenerico<>(gerenciador, Cidade.class);
    }
    
    public void inserir(Cidade cidade)  {
        dao.inserir(cidade);
    }
    /*
    public void alterar(Cidade cidade)  {
        dao.alterar(cidade);
    }
    */
    public void excluir(Cidade cidade)  {
        cidade = gerenciador.find(Cidade.class, cidade.getId());
        dao.excluir(cidade);
    }
    
    public Cidade visualizar(Cidade cidade) {
        return dao.visualizar(cidade.getId());
    }
    
    public List<Cidade> listar()    {
        return dao.listar();
    }
    
}
