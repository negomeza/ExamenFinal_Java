
package MODELO;

import DAO.clientesDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class clientesDAORelacional implements clientesDAO{

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    conexion acceso = new conexion();

    @Override
    public LinkedList<clientes_new> listar_new() {
    String sql = "select * from clientes";
        LinkedList<clientes_new> listar = new LinkedList<>();
        
        try {
            //inicializa la base de datos
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
               listar.add(new clientes_new(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            return listar;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null; 
    }

    @Override
    public clientes_new obtener(int codigo) {
    String sql = "select * from clientes WHERE codigo = ?";
        
        try {
            //inicializa la base de datos
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            if (rs.next()) {
                clientes_new ven = new clientes_new(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
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
    public void crear(clientes_new cliente) {
    String sql = "INSERT INTO clientes (codigo, nombre, nit, correo, genero) values(?,?,?,?,?);";
        
        try {
             con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getCodigo());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getNit());
            ps.setString(4, cliente.getCorreo());
            ps.setString(5, cliente.getGenero());
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void modificar(clientes_new cliente) {
    String sql = "UPDATE clientes set nombre =?,nit=?,correo=?, genero= ? WHERE codigo = ?;";
        
        try {
             con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getNit());
            ps.setString(3, cliente.getCorreo());
             ps.setString(4, cliente.getGenero());
            ps.setInt(5, cliente.getCodigo());
            ps.executeUpdate();
            }  catch (Exception e) {
            System.out.println(e);
            }
    }

    @Override
    public void eliminar(int codigo) {
    String sql = "DELETE FROM clientes WHERE codigo = ?;";
    
        try {
             con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public clientes_new obtenerFiltro(String nombre , String nit, String correo, String genero) {
    String sql = "select  * from clientes WHERE nombre like ? and nit like ? and correo like ? and genero like ?";
        //
        try {
            //inicializa la base de datos
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + nombre + "%");
            ps.setString(2, "%" + nit + "%");
            ps.setString(3, "%" + correo + "%");
            ps.setString(4, "%" + genero + "%");
            
            rs = ps.executeQuery();
            if (rs.next()) {
                clientes_new ven = new clientes_new(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
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
