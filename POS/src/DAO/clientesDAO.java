
package DAO;

import MODELO.clientes_new;
import java.util.LinkedList;

public interface clientesDAO {
      //Vamoa a crear los metodos que queremos ejecutar
    public LinkedList<clientes_new> listar_new();
    
    public clientes_new obtener(int codigo);
    
    public clientes_new obtenerFiltro(String nombre,String nit,String correo,String genero);
    
    public void crear(clientes_new cliente);
    
    public void modificar(clientes_new cliente);
    
    public void eliminar(int codigo);
    
}
