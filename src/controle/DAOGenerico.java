package controle;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DAOGenerico<tipo> {
    
    private EntityManager gerenciador;
    private Class<tipo> classe;
    
    public DAOGenerico (EntityManager gerenciador, Class<tipo> classe)  {
        this.gerenciador = gerenciador;
        this.classe = classe;
    }
    
    public void inserir(tipo objeto)   {
        gerenciador.persist(objeto);
    }
    public void alterar(tipo objeto){
        gerenciador.merge(objeto);
    }
    
    public void excluir(tipo objeto)    {
        gerenciador.remove(objeto);
    }
    
    public tipo visualizar(long id)    {
        return gerenciador.find(classe, id);
    }
    
    public List<tipo> listar()  {
        Query consulta = gerenciador.createQuery("SELECT o FROM " + classe.getName() + " o");
        return consulta.getResultList();
    }
}