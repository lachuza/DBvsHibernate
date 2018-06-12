
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Cliente_xml {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        //System.setProperty("javax.xml.accessExternalDTD", "all");
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // obtiene los valores de hibernate.cfg.xml
                .build();

        try {
           
            SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();        
     
            Session session = sessionFactory.openSession();
    
            session.beginTransaction();
            
            CriteriaQuery<Cliente> q = session.getCriteriaBuilder().createQuery(Cliente.class);
            q.select(q.from(Cliente.class));
            List<Cliente> cl = session.createQuery(q).list();

            System.out.println("-------Todos los clientes con sus teléfonos-----------------------------------");              
            for (Cliente cli:cl) {
                System.out.println(cli);
                for (Telefono tel:cli.getTelefono()) {
                    System.out.println(tel);
                }                
            }

            System.out.println("-------Todos los clientes con sus Facturas y detalles-----------------------------------");              
            for (Cliente cli:cl) {
                System.out.println(cli);
                for (Factura fac:cli.getFactura()) {
                    System.out.println(fac);
//                    for (DetalleFactura detfac:fac.getDetalleFactura()) {
//                        System.out.println(detfac);
//                    }                       
                }                
            }
            System.out.println("-------clientes 1 con sus Facturas y detalles-----------------------------------");  
            Cliente cli = (Cliente) session.load(Cliente.class, 1);            
            System.out.println(cli);
            for (Factura fac:cli.getFactura()) {
                System.out.println(fac);
                for (DetalleFactura detfac:fac.getDetalleFactura()) {
                    Producto prod = detfac.getProducto();
                    System.out.println(prod);
                    System.out.println(detfac);                    
                }                       
            }                
            System.out.println("-----------Imprimo el cliente 1--------------------------------------------");            
            Cliente c = (Cliente) session.load(Cliente.class, 1);
            System.out.println(c);
            System.out.println("----------TELEFONOS DEL CLIENTE 1-----------------------------------------------");
            for (Telefono tel:c.getTelefono()) {
                System.out.println(tel);
            }
            System.out.println("---------Imprimo el cliente 5------------------------------------------------");
            Cliente c2 = session.get(Cliente.class, 5);
            System.out.println(c2);
            System.out.println("-----------------Get de un número de telefono 513-4998612-------------------------------------");            
            Telefono t = session.get(Telefono.class, new Telefono.Numero(513, 4998612));
            System.out.println(t);
            System.out.println("---------------------------------------------------------");      
            Query q2 = session.createQuery("from Cliente where activo >= :act", Cliente.class);
            q2.setParameter("act", 100);
            List<Cliente> l = q2.list();
            System.out.println("Clientes no Activos");
            for(Cliente cli2:l) {
                    System.out.println(cli2);
            }
            System.out.println("---------------------------------------------------------");            
            Query q3 = session.createQuery("select max(nro_cliente) from Cliente");
            int a = (int) q3.uniqueResult();
            System.out.println(a);
            
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        }
        catch (Exception e) {
            if (registry != null) StandardServiceRegistryBuilder.destroy(registry);
            throw e;           
        }
      }


    
}
