package paneles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private Image imagen;

    public Login() {
        imagen = new ImageIcon("src\\main\\java\\img\\fondo.png").getImage();

    }

    public void mostrarPanel(JPanel p) {
        p.setOpaque(false);
        setContentPane(p);
        revalidate();
        repaint();
    }

    public void mostrar() {
        setTitle("Login");
        setLayout(new BorderLayout());
        setSize(1080, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelLogin = new JPanel() {

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

        panelLogin.setLayout(new BorderLayout(20, 20));
        panelLogin.setBorder(
                BorderFactory.createEmptyBorder(0, 50, 300, 50)
        );

        JPanel panelNorte = new JPanel();
        panelNorte.setOpaque(false);

        JPanel panelCentro = new JPanel();
        panelCentro.setOpaque(false);
        panelCentro.setLayout(new GridBagLayout());

        JPanel contenedorCentral = new JPanel(new BorderLayout());
        contenedorCentral.setOpaque(false);
        contenedorCentral.add(panelCentro, BorderLayout.CENTER);
        panelLogin.add(contenedorCentral, BorderLayout.CENTER);

        JLabel labelLogin = new JLabel("Inicio de sesion");
        labelLogin.setFont(new Font("Arial", Font.BOLD, 30));

        JLabel labelUsuario = new JLabel("Ingrese su nombre");
        labelUsuario.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField textFieldUsuario = new JTextField(20);

        JLabel labelContra = new JLabel("Ingrese su contraseña");
        labelContra.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField textFieldContra = new JTextField(20);

        JButton buttonIniciarSesion = new JButton("Iniciar sesion");
        JButton buttonPedidoExpres = new JButton("Realizar pedido expres");

        JLabel labelRegistrto = new JLabel("¿No tienes cuenta, registrate?");
        labelRegistrto.setFont(new Font("Arial", Font.BOLD, 15));
        JButton buttonRegistrarse = new JButton("Registrate");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6); // espacio
        gbc.anchor = GridBagConstraints.WEST;

        //fila 1
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelCentro.add(labelUsuario, gbc);

        gbc.gridx = 1;
        panelCentro.add(textFieldUsuario, gbc);

        //fila 2
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelCentro.add(labelContra, gbc);

        gbc.gridx = 1;
        panelCentro.add(textFieldContra, gbc);

        //fila 3
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelCentro.add(buttonPedidoExpres, gbc);

        gbc.gridx = 1;
        panelCentro.add(buttonIniciarSesion, gbc);

        //fila 4
        gbc.gridx = 0;
        gbc.gridy = 3;
        panelCentro.add(labelRegistrto, gbc);

        gbc.gridx = 1;
        panelCentro.add(buttonRegistrarse, gbc);

        panelNorte.add(labelLogin);
        panelLogin.add(panelNorte, BorderLayout.NORTH);

        panelLogin.add(panelCentro, BorderLayout.CENTER);
        setContentPane(panelLogin);

        buttonRegistrarse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Register r = new Register();
                r.mostrar();
                mostrarPanel(r);

            }
        });

        buttonIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textFieldUsuario.getText().equals("luis") && Integer.parseInt(textFieldContra.getText()) == 123) {
                    JOptionPane.showMessageDialog(null, "Acceso consedido");
                    Register r = new Register();

                } else {
                    JOptionPane.showMessageDialog(null, "Contra incorrecta");
                }
            }
        });

        setVisible(true);
    }
}
