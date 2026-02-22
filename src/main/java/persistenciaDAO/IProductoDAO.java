package persistenciaDAO;

import dominio.Producto;
import negocio.PersistenciaException;

public interface IProductoDAO {
    Producto agregarProducto(Producto producto) throws PersistenciaException;

    Producto actualizarProducto(Producto producto) throws PersistenciaException;





}

