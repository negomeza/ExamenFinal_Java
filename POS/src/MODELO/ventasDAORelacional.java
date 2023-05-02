
package MODELO;

import DAO.clientesDAO;
import DAO.ventasDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class ventasDAORelacional implements ventasDAO{

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    conexion acceso = new conexion();

    @Override
    public LinkedList<ventas_new> listar_new() {
    String sql = "select * from venta_detalle_Temp";
        LinkedList<ventas_new> listar = new LinkedList<>();
        
        try {
            //inicializa la base de datos
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {          
               listar.add(new ventas_new(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6)));
            }
            return listar;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null; 
    }

    @Override
    public ventas_new obtener(int codigo) {
    String sql = "select * from venta_detalle_Temp WHERE codigo_detalle = ?";
        
        try {
            //inicializa la base de datos
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            if (rs.next()) {
                ventas_new ven = new ventas_new(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
                return ven;
            } else{
                JOptionPane.showMessageDialog(null, "No se encontrarón resultados");
            }
            return null;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void crear(ventas_new venta) {
    String sql = "INSERT INTO venta_detalle_Temp (codigo_producto, nombre, codigo_cliente, cantidad, precio) values(?,?,?,?,?);";
        
        try {
             con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps = con.prepareStatement(sql);
            ps.setInt(1, venta.getCodigo_producto());
            ps.setString(2, venta.getNombre());
            ps.setInt(3, venta.getCodigo_cliente());
            ps.setInt(4, venta.getCantidad());
            ps.setInt(5, venta.getPrecio());
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void crearFactura(clientes_new cliente) {
        String sql = "CALL registrar_venta(?,?);";
        
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getNit());
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
