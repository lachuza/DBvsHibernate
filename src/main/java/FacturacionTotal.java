
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
public class FacturacionTotal {
 
    
     public static void main(String[] args) {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");
         EntityManager manager = emf.createEntityManager();
         Query query = manager.createQuery("SELECT e FROM Factura e");
         System.out.println((Collection<Factura>)  query.getResultList());
         
         manager.close();
         emf.close();         
     }
}
