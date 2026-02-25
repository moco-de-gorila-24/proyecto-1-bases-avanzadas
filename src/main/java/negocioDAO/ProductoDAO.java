package negocioDAO;

import dominio.Producto;
import negocio.PersistenciaException;
import persistenciaBD.IConexionBD;
import persistenciaDAO.IProductoDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO implements IProductoDAO {

    private final IConexionBD conexionBD;

    public ProductoDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public void agregarProducto(Producto producto) throws PersistenciaException {
        String sql = "INSERT INTO Producto (nombre, tamaño, descripcion, precio, ingredientesBase, disponible) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getTamaño());
            ps.setString(3, producto.getDescripcion());
            ps.setFloat(4, producto.getPrecio());
            ps.setString(5, producto.getIngredientesBase());
            ps.setBoolean(6, producto.isDisponible());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenciaException("Error al agregar producto: " + e.getMessage());
        }
    }

    @Override
    public List<Producto> consultarCatalogo() throws PersistenciaException {
        List<Producto> lista = new ArrayList<>();
        // Solo consultamos los que están marcados como disponibles para el cliente
        String sql = "SELECT * FROM Producto WHERE disponible = TRUE";

        try (Connection conn = conexionBD.crearConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Producto p = new Producto(
                        rs.getInt("idProducto"),
                        rs.getString("nombre"),
                        rs.getString("tamaño"),
                        rs.getString("descripcion"),
                        rs.getFloat("precio"),
                        rs.getString("ingredientesBase"),
                        rs.getBoolean("disponible")
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al consultar catálogo: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public void actualizarProducto(Producto producto) throws PersistenciaException {
        String sql = "UPDATE Producto SET nombre=?, tamaño=?, descripcion=?, precio=?, ingredientesBase=? WHERE idProducto=?";

        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getTamaño());
            ps.setString(3, producto.getDescripcion());
            ps.setFloat(4, producto.getPrecio());
            ps.setString(5, producto.getIngredientesBase());
            ps.setInt(6, producto.getIdProducto());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenciaException("Error al actualizar producto: " + e.getMessage());
        }
    }

    @Override
    public void cambiarDisponibilidad(int idProducto, boolean disponible) throws PersistenciaException {
        // En lugar de DELETE, usamos este método para cumplir con la regla de negocio
        String sql = "UPDATE Producto SET disponible = ? WHERE idProducto = ?";

        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setBoolean(1, disponible);
            ps.setInt(2, idProducto);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenciaException("Error al cambiar estado del producto: " + e.getMessage());
        }
    }
}
