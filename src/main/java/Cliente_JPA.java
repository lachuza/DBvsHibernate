
import java.sql.SQLException;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



import javax.persistence.Query;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guillermo.islas
 */
public class Cliente_JPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

                
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager manager = emf.createEntityManager();
        // manager.getTransaction().begin();

        Query query = manager.createQuery("SELECT e FROM Cliente e");

        System.out.println((Collection<Cliente>)  query.getResultList());

            for (Cliente cli: (Collection<Cliente>) query.getResultList()) {
                System.out.println(cli);
            }        
        
        manager.close();
        emf.close();
                
 
    }
    
}
