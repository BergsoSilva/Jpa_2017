package controle;

import dao.DAOGenerico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Cidade;
import modelo.Estado;


public class EstadoDAO {
    
    EntityManager gerenciador;
    DAOGenerico<Estado> dao;
    
    public EstadoDAO(EntityManager gerenciador)  {
        this.gerenciador = gerenciador;
        this.dao = new DAOGenerico<>(gerenciador, Estado.class);
    }
    
    public void inserir(Estado estado)  {
        dao.inserir(estado);
    }
   
    public void alterar(Estado estado)  {
        dao.alterar(estado);
    }
    
    public void excluir(Estado estado)  {
        estado = gerenciador.find(Estado.class, estado.getId());
        dao.excluir(estado);
    }
    
    public Estado visualizar(Estado estado) {
        return dao.visualizar(estado.getId());
    }
    
    public List<Estado> listar()    {
        return dao.listar();
    }
    
    public List<Cidade> getTodasCidadesEstado(Estado estado) {
        Query consulta = gerenciador.createQuery("SELECT c FROM Cidade c " +
                "WHERE c.estado.id = :pestado");
        consulta.setParameter("pestado", estado.getId());
        return consulta.getResultList();
    }
    
}
