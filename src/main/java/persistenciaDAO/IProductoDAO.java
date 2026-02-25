package persistenciaDAO;

import dominio.Producto;
import negocio.PersistenciaException;
import java.util.List;

public interface IProductoDAO {
    void agregarProducto(Producto producto) throws PersistenciaException;
    void actualizarProducto(Producto producto) throws PersistenciaException;
    List<Producto> consultarCatalogo() throws PersistenciaException;
    void cambiarDisponibilidad(int idProducto, boolean disponible) throws PersistenciaException;
}
