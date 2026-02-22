package persistenciaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD implements IConexionBD{

    private final String CADENA_CONEXION = "jdbc:mysql://localhost:3306/pizzeria";
    private final String USUARIO = "root";
    private final String CONTRASENIA = "3082006Luis";


    @Override
    public Connection crearConexion() throws SQLException {
        return DriverManager.getConnection(CADENA_CONEXION, USUARIO, CONTRASENIA);
    }
}
