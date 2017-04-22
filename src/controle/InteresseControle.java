package controle;

import dao.DAOGenerico;
import java.util.List;
import javax.persistence.EntityManager;
import modelo.Interesse;


public class InteresseControle {
    
    EntityManager gerenciador;
    DAOGenerico<Interesse> dao;
    
    public InteresseControle(EntityManager gerenciador)  {
        this.gerenciador = gerenciador;
        this.dao = new DAOGenerico<>(gerenciador, Interesse.class);
    }
    
   
    public List<Interesse> listar()    {
        return dao.listar();
    }
    
  
}
