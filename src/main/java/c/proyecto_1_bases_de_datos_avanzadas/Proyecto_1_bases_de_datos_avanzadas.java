/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package c.proyecto_1_bases_de_datos_avanzadas;

import dominio.Cliente;
import negocio.PersistenciaException;
import paneles.Login;
import paneles.Register;
import persistenciaBD.ConexionBD;
import persistenciaBD.IConexionBD;
import persistenciaDAO.ClienteDAO;
import persistenciaDAO.IClienteDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author Luis
 */
public class Proyecto_1_bases_de_datos_avanzadas {

    public static void main(String[] args) {
        Register login = new Register();
        //login.mostrar();

        Login logi = new Login();
        logi.mostrar();

//        try{
//            IConexionBD conexion = new ConexionBD();
//            IClienteDAO clienteDAO = new ClienteDAO(conexion);
//
           Cliente cliente = new Cliente(3, "Charly","Duarte", "Mendez" , Date.valueOf("2005-03-21"),"kino", "obregonyork",85175);
//
//            clienteDAO.agregarCliente(cliente);
//        }
//        catch (PersistenciaException e) {
//            throw new RuntimeException(e);
//        }

    }
}
