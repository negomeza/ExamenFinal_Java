
package DAO;

import MODELO.clientes_new;
import MODELO.ventas_new;
import java.util.LinkedList;

public interface ventasDAO {
    
    public LinkedList<ventas_new> listar_new();
    
    public ventas_new obtener(int codigo);
    
    public void crear(ventas_new venta);
    
    public void crearFactura(clientes_new venta);
    
}
