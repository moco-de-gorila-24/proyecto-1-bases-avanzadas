package paneles;

import javax.swing.*;
import java.awt.*;

public class Register extends JDialog {

    public Register(){

    }

    public void mostrar(){
        setTitle("Login");
        setLayout(new BorderLayout());
        setSize(1080,720);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel titulo = new JLabel("Registro de clientes");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel labelNombre = new JLabel("Ingrese su nombre ");
        labelNombre.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField textFieldNombre = new JTextField(20);

        JLabel labelApellidoPaterno = new JLabel("Ingrese su apellido paterno");
        labelApellidoPaterno.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField textFieldApellidoPaterno = new JTextField(20);

        JLabel labelApellidoMaterno = new JLabel("Ingrese su apellido materno");
        labelApellidoMaterno.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField textFieldApellidoMaterno = new JTextField(20);

        JLabel labelFecha = new JLabel("Ingrese la fecha de nacimiento");
        labelFecha.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField textFieldFecha = new JTextField(20);

        JLabel labelCalle = new JLabel("Ingrese su calle");
        labelCalle.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField textFieldCalle = new JTextField(20);
        JButton buttonAgregar = new JButton("Agregar cliente");

        JLabel labelColonia = new JLabel("Ingrese el nombre de su colonia");
        labelColonia.setFont(new Font("Arial", Font.BOLD,18));
        JTextField textFieldColonia = new JTextField(20);

        JLabel labelTelefono = new JLabel("Telefonos de contacto");
        labelTelefono.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField telefonoTextfield = new JTextField(20);

        JPanel panelPrincipal = new JPanel();
        JPanel panelNorte = new JPanel();
        JPanel panelCentro = new JPanel();
        panelPrincipal.setLayout(new BorderLayout(10,10));
        panelPrincipal.setBorder(
                BorderFactory.createEmptyBorder(20,50,320,50)
        );

        panelCentro.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(6,6,6,6); // espacio
        gbc.anchor = GridBagConstraints.WEST;

        // Fila 1
        gbc.gridx = 0; gbc.gridy = 0;
        panelCentro.add(labelNombre, gbc);

        gbc.gridx = 1;
        panelCentro.add(textFieldNombre, gbc);

        // Fila 2
        gbc.gridx = 0; gbc.gridy = 1;
        panelCentro.add(labelApellidoPaterno, gbc);

        gbc.gridx = 1;
        panelCentro.add(textFieldApellidoPaterno, gbc);

        //fila 3
        gbc.gridx = 0; gbc.gridy = 2;
        panelCentro.add(labelApellidoMaterno, gbc);

        gbc.gridx = 1;
        panelCentro.add(textFieldApellidoMaterno, gbc);

        //Fila 3
        gbc.gridx = 0; gbc.gridy = 3;
        panelCentro.add(labelCalle, gbc);

        gbc.gridx = 1;
        panelCentro.add(textFieldFecha, gbc);

        //Fila 4
        gbc.gridx = 0; gbc.gridy = 4;
        panelCentro.add(labelColonia, gbc);

        gbc.gridx = 1;
        panelCentro.add(textFieldColonia, gbc);

        //Fila 5
        gbc.gridx = 0; gbc.gridy = 5;
        panelCentro.add(labelTelefono, gbc);

        gbc.gridx = 1;
        panelCentro.add(telefonoTextfield, gbc);



        panelCentro.add(buttonAgregar);


        panelNorte.add(titulo);

        panelPrincipal.add(panelNorte, BorderLayout.NORTH);
        panelPrincipal.add(panelCentro, BorderLayout.CENTER);

        add(panelPrincipal);
        setVisible(true);
    }

}
