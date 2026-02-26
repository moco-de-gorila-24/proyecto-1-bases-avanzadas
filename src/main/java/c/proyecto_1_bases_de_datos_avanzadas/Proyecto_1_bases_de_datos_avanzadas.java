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
import persistenciaDAO.IClienteDAO; 
import negocioDAO.ClienteDAO;      
import java.sql.Date;
/**
 *
 * @author Luis
 */
public class Proyecto_1_bases_de_datos_avanzadas {

    public static void main(String[] args) {
        Login logi = new Login();
        logi.setVisible(true); 

    }
}