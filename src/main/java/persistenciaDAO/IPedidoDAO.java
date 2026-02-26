/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistenciaDAO;


import dominio.Pedidos;
import negocio.PersistenciaException;
import java.util.List;
/**
 *
 * @author oscar
 */
public interface IPedidoDAO {

    void agregarPedido(Pedidos pedido) throws PersistenciaException;
    List<Pedidos> buscarPedidos(String filtro) throws PersistenciaException;
    void actualizarEstado(int idPedido, String nuevoEstado) throws PersistenciaException;
    List<Pedidos> buscarPedidosListos() throws PersistenciaException;
    void registrarEntregaYPago(int idPedido, String metodoPago, double monto) throws PersistenciaException;
}