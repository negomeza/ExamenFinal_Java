/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

import DAO.productosDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author NELSON
 */
public class productosDAORelacional implements productosDAO{

    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    conexion acceso = new conexion();
    
    @Override
    public LinkedList<productos_new> listar_new() {
        String sql = "select * from productos";
        LinkedList<productos_new> listar = new LinkedList<>();
        
        try {
            //inicializa la base de datos
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
               listar.add(new productos_new(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
            }
            return listar;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null; 
    }

    @Override
    public productos_new obtener(int codigo) {
    String sql = "select * from productos WHERE codigo = ?";
        
        try {
            //inicializa la base de datos
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            if (rs.next()) {
                productos_new pro = new productos_new(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
                return pro;
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
    public void crear(productos_new producto) {
    String sql = "INSERT INTO productos (codigo, nombre, descripcion, cantidad, precio) values(?,?,?,?,?);";
        
        try {
             con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps = con.prepareStatement(sql);
            ps.setInt(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getDescripcion());
            ps.setInt(4, producto.getCantidad());
            ps.setInt(5, producto.getPrecio());
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void modificar(productos_new producto) {
    String sql = "UPDATE productos set nombre =?,descripcion=?,cantidad=?, precio = ? WHERE codigo = ?;";
        
        try {
             con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
             ps.setString(2, producto.getDescripcion());
            ps.setInt(3, producto.getCantidad());
            ps.setInt(4, producto.getPrecio());
            ps.setInt(5, producto.getCodigo());
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void eliminar(int codigo) {
        String sql = "DELETE FROM productos WHERE codigo = ?;";
        
        try {
             con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
