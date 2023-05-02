
package DAO;

import MODELO.vendedores_new;
import java.util.LinkedList;



public interface vendedoresDAO {
      //Vamoa a crear los metodos que queremos ejecutar
    public LinkedList<vendedores_new> listar_new();
    
    public vendedores_new obtener(int codigo);
    
    public void crear(vendedores_new vendedor);
    
    public void modificar(vendedores_new vendedor);
    
    public void eliminar(int codigo);
    
    
}
