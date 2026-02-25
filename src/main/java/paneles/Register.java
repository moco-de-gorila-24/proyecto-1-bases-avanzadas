package paneles;

import DTO.ClienteDTO;
import dominio.Cliente;
import fabrica.RegistrarCliente;
import negocio.NegocioException;
import negocio.PersistenciaException;
import negocioBO.ClienteBO;
import negocioDAO.ClienteDAO;
import persistenciaBD.ConexionBD;
import persistenciaBD.IConexionBD;
import persistenciaBO.IClienteBO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class Register extends JPanel {
    private Image imagen;


    public Register() {
        imagen = new ImageIcon("src\\main\\java\\img\\FondoRegistrar.png").getImage();
    }

    public void mostrarPanel(JFrame p) {
        p.setOpacity(0);
        p.setContentPane(p);
        revalidate();
        repaint();

    }

    public void mostrar() {
        setLayout(new BorderLayout());
        setSize(1080, 720);


        JLabel titulo = new JLabel("Registro de clientes");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel labelNombre = new JLabel("Ingrese sus nombres ");
        labelNombre.setFont(new Font("Arial", Font.BOLD, 17));
        JTextField textFieldNombre = new JTextField(20);

        JLabel labelApellidoPaterno = new JLabel("Ingrese su apellido paterno");
        labelApellidoPaterno.setFont(new Font("Arial", Font.BOLD, 17));
        JTextField textFieldApellidoPaterno = new JTextField(20);

        JLabel labelApellidoMaterno = new JLabel("Ingrese su apellido materno");
        labelApellidoMaterno.setFont(new Font("Arial", Font.BOLD, 17));
        JTextField textFieldApellidoMaterno = new JTextField(20);

        JLabel labelFecha = new JLabel("Ingrese su fecha de nacimiento ");
        labelFecha.setFont(new Font("Arial", Font.BOLD, 17));
        JTextField textFieldFecha = new JTextField("yyyy-mm-dd", 20);

        JLabel labelCalle = new JLabel("Ingrese su calle");
        labelCalle.setFont(new Font("Arial", Font.BOLD, 17));
        JTextField textFieldCalle = new JTextField(20);

        JButton buttonAgregar = new JButton("Agregar cliente");
        JButton buttonIniciarSesion = new JButton("Iniciar sesion"); // por si el cliente recuerda que tiene cuenta

        JLabel labelColonia = new JLabel("Ingrese el nombre de su colonia");
        labelColonia.setFont(new Font("Arial", Font.BOLD, 17));
        JTextField textFieldColonia = new JTextField(20);

        JLabel labelTelefono = new JLabel("Ingrese su telefono de contacto");
        labelTelefono.setFont(new Font("Arial", Font.BOLD, 17));
        JTextField telefonoTextfield = new JTextField(20);

        JLabel labelCodigoPostal = new JLabel("Ingrese su codigo postal");
        labelCodigoPostal.setFont(new Font("Arial", Font.BOLD, 17));
        JTextField textFieldCodigoPostal = new JTextField(20);

        JLabel labelContra = new JLabel("Ingrese una contraseña");
        labelContra.setFont(new Font("Arial", Font.BOLD, 17));
        JPasswordField passwordFieldContra = new JPasswordField(20);

        JLabel labelConfirmarContra = new JLabel("Confirme su contraseña");
        labelConfirmarContra.setFont(new Font("Arial", Font.BOLD, 17));
        JPasswordField passwordFieldConfirmarContra = new JPasswordField(20);

        JPanel panelPrincipal = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2 = (Graphics2D) g;

                // Habilitar alta calidad
                g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
                g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Dibujar imagen con interpolación suave
                g2.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
            }
        };
        JPanel panelNorte = new JPanel();
        panelNorte.setOpaque(false);

        JPanel panelCentro = new JPanel();
        panelCentro.setOpaque(false);

        JPanel panelSur = new JPanel();
        panelSur.setOpaque(false);

        panelPrincipal.setLayout(new BorderLayout(10, 10));
        panelPrincipal.setBorder(
                BorderFactory.createEmptyBorder(20, 40, 20, 40)
        );

        panelCentro.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        panelSur.setLayout(new GridBagLayout());
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.insets = new Insets(-5, 25, 50, 25); // espacio
        gbc2.anchor = GridBagConstraints.WEST;

        gbc.insets = new Insets(5, 5, 5, 5); // espacio
        gbc.anchor = GridBagConstraints.WEST;

        // Fila 1
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelCentro.add(labelNombre, gbc);

        gbc.gridx = 1;
        panelCentro.add(textFieldNombre, gbc);

        // Fila 2
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelCentro.add(labelApellidoPaterno, gbc);

        gbc.gridx = 1;
        panelCentro.add(textFieldApellidoPaterno, gbc);

        //fila 3
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelCentro.add(labelApellidoMaterno, gbc);

        gbc.gridx = 1;
        panelCentro.add(textFieldApellidoMaterno, gbc);

        //Fila 3
        gbc.gridx = 0;
        gbc.gridy = 3;
        panelCentro.add(labelFecha, gbc);

        gbc.gridx = 1;
        panelCentro.add(textFieldFecha, gbc);

        //Fila 4
        gbc.gridx = 0;
        gbc.gridy = 4;
        panelCentro.add(labelCalle, gbc);

        gbc.gridx = 1;
        panelCentro.add(textFieldCalle, gbc);

        //Fila 5
        gbc.gridx = 0;
        gbc.gridy = 5;
        panelCentro.add(labelColonia, gbc);

        gbc.gridx = 1;
        panelCentro.add(textFieldColonia, gbc);

        //Fila 6
        gbc.gridx = 0;
        gbc.gridy = 6;
        panelCentro.add(labelTelefono, gbc);

        gbc.gridx = 1;
        panelCentro.add(telefonoTextfield, gbc);

        //fila 7
        gbc.gridx = 0;
        gbc.gridy = 7;
        panelCentro.add(labelCodigoPostal, gbc);

        gbc.gridx = 1;
        panelCentro.add(textFieldCodigoPostal, gbc);

        //Fila 8
        gbc.gridx = 0;
        gbc.gridy = 8;
        panelCentro.add(labelContra, gbc);

        gbc.gridx = 1;
        panelCentro.add(passwordFieldContra, gbc);

        //fila 9
        gbc.gridx = 0;
        gbc.gridy = 9;
        panelCentro.add(labelConfirmarContra, gbc);

        gbc.gridx = 1;
        panelCentro.add(passwordFieldConfirmarContra, gbc);

        //fila 1 del panel sur

        gbc2.gridx = 0;
        gbc2.gridy = 12;
        panelSur.add(buttonIniciarSesion, gbc2);

        gbc2.gridx = 1;
        panelSur.add(buttonAgregar, gbc2);


        // panelCentro.add(buttonAgregar);
        panelNorte.add(titulo);
        panelPrincipal.add(panelNorte, BorderLayout.NORTH);
        panelPrincipal.add(panelCentro, BorderLayout.CENTER);
        panelPrincipal.add(panelSur, BorderLayout.SOUTH);
        add(panelPrincipal);

        buttonIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login log = new Login();
                log.mostrar();
            }
        });

        buttonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente cliente = new Cliente(textFieldNombre.getText(),
                        textFieldApellidoPaterno.getText(),
                        textFieldApellidoMaterno.getText(),
                        Date.valueOf(textFieldFecha.getText()),
                        textFieldCalle.getText(),
                        textFieldColonia.getText(),
                        Integer.valueOf(textFieldCodigoPostal.getText()),
                        new String(passwordFieldContra.getPassword()));

                IConexionBD conexion = new ConexionBD();
                ClienteDTO clienteDTO = new ClienteDTO(cliente);
                ClienteDAO cli = new ClienteDAO(conexion);
                ClienteBO c = new ClienteBO(cli);
                try {
                    c.agregarCliente(clienteDTO);


                } catch (NegocioException | PersistenciaException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        setVisible(true);
    }

}
