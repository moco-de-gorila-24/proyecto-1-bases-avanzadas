package paneles;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    public Login(){

    }

    public void mostrar(){
        setTitle("Login");
        setLayout(new BorderLayout());
        setSize(1080,720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel labelNombre = new JLabel("Ingrese su nombre completo");
        labelNombre.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField textFieldNombre = new JTextField(20);
        JLabel titulo = new JLabel("Registro de clientes");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel labelCalle = new JLabel("Ingrese su calle");
        labelCalle.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField textFieldCalle = new JTextField(18);

        JPanel panelPrincipal = new JPanel();
        JPanel panelNorte = new JPanel();
        JPanel panelCentro = new JPanel();
        panelPrincipal.setLayout(new BorderLayout(10,10));
        panelPrincipal.setBorder(
                BorderFactory.createEmptyBorder(20,20,20,20)
        );
        //JPanel panelNorte = new JPanel();
        //JPanel panelNorte = new JPanel();

        panelNorte.add(titulo);
        panelCentro.add(labelNombre);
        panelCentro.add(textFieldNombre);
        panelCentro.add(labelCalle);
        panelCentro.add(textFieldCalle);

        panelPrincipal.add(panelNorte, BorderLayout.NORTH);
        panelPrincipal.add(panelCentro, BorderLayout.WEST);

        add(panelPrincipal);
        setVisible(true);
    }

}
