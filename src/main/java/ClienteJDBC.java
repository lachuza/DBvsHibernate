
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guillermo.islas
 */
public class ClienteJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {        
                String url = "jdbc:mysql://localhost:3306/prueba";
                Connection conn = DriverManager.getConnection(url, "root", "tAndil111");
                PreparedStatement st = conn.prepareStatement("SELECT * FROM e01_CLIENTE");
                ResultSet resultSet = st.executeQuery();
                while (resultSet.next()) {
                        int id = resultSet.getInt("nro_cliente");
                        String nombre = resultSet.getString("nombre");
                        String apellido = resultSet.getString("apellido");
                        String direccion = resultSet.getString("direccion");
                        boolean activo = resultSet.getBoolean("activo");
                        System.out.println("" + id + ", " + nombre + ", " + apellido + ", " + direccion + ", " + activo);
                }
                
                st.close();
                conn.close();
                
                System.out.println("-------------------------------------------");        
        } catch (SQLException ex) {
                ex.printStackTrace();
        }        
    
    }
}