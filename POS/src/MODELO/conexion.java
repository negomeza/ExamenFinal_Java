
package MODELO;

import java.sql.Connection;
import java.sql.DriverManager;


public class conexion {
    Connection con;
    String url = "jdbc:mysql://localhost:3306/pos";
    String user="root";
    String pass="";
    
    public Connection Conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
        } catch (Exception e) {
            System.out.println("error:");
            System.out.println(e);
        }
        return con;
    }
    
    public static void main(String[] args) {
        conexion c = new conexion();
        System.out.println(c.Conectar());
    }
}
