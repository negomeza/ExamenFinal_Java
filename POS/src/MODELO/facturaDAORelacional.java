
package MODELO;

import DAO.facturaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class facturaDAORelacional implements facturaDAO{

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    conexion acceso = new conexion();

    @Override
    public factura_new obtener(int codigo, String nit, String nombre) {
       String sql = "select  * from factura WHERE codigo like ? and nombre like ? and nit like ? ";
        //
        try {
            //inicializa la base de datos
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + codigo + "%");
            ps.setString(2, "%" + nombre + "%");
            ps.setString(3, "%" + nit + "%");
            
            rs = ps.executeQuery();
            if (rs.next()) {
                factura_new ven = new factura_new(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getInt(5));
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

    
}
