/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

import DAO.vendedoresDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author NELSON
 */
public class vendedoresDAORelacional implements vendedoresDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    conexion acceso = new conexion();

    
    @Override
    public LinkedList<vendedores_new> listar_new() {
        String sql = "select * from vendedores";
        LinkedList<vendedores_new> listar = new LinkedList<>();
        
        try {
            //inicializa la base de datos
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
               listar.add(new vendedores_new(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6)));
            }
            return listar;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null; 
    }
    



    @Override
    public vendedores_new obtener(int codigo) {
        String sql = "select * from vendedores WHERE codigo = ?";
        
        try {
            //inicializa la base de datos
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            if (rs.next()) {
                vendedores_new ven = new vendedores_new(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6));
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
    public void crear(vendedores_new vendedor) {
        String sql = "INSERT INTO vendedores (codigo, nombre, caja, ventas, genero, contrasenia) values(?,?,?,?,?,?);";
        
        try {
             con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps = con.prepareStatement(sql);
            ps.setInt(1, vendedor.getCodigo());
            ps.setString(2, vendedor.getNombre());
            ps.setInt(3, vendedor.getCaja());
            ps.setInt(4, vendedor.getVentas());
            ps.setString(5, vendedor.getGenero());
            ps.setString(6, vendedor.getContrasenia());
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void modificar(vendedores_new vendedor) {
        String sql = "UPDATE vendedores set nombre =?,caja=?,ventas=?, genero = ?, contrasenia=? WHERE codigo = ?;";
        
        try {
             con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, vendedor.getNombre());
            ps.setInt(2, vendedor.getCaja());
            ps.setInt(3, vendedor.getVentas());
             ps.setString(4, vendedor.getGenero());
            ps.setString(5, vendedor.getContrasenia());
            ps.setInt(6, vendedor.getCodigo());
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void eliminar(int codigo) {
        String sql = "DELETE FROM vendedores WHERE codigo = ?;";
        
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
