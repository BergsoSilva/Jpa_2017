package controle;

import java.util.List;
import javax.persistence.EntityManager;
import modelo.Interesse;


public class InteresseDAO {
    
    EntityManager gerenciador;
    DAOGenerico<Interesse> dao;
    
    public InteresseDAO(EntityManager gerenciador)  {
        this.gerenciador = gerenciador;
        this.dao = new DAOGenerico<>(gerenciador, Interesse.class);
    }
    
   
    public List<Interesse> listar()    {
        return dao.listar();
    }
    
  
}
