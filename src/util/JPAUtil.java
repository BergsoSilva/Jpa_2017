package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    
    private static EntityManagerFactory fabrica;
    
    static {
        fabrica = Persistence.createEntityManagerFactory("Framework230217PU");
    }
    
    public static EntityManager getJPAUtil()    {
        return fabrica.createEntityManager();
    }
    
    public static void fecharFabrica()  {
        fabrica.close();
    }
    
}
