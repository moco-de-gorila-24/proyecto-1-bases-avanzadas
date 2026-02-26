/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;
import paneles.PanelEntregas;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        try {
            // Establece la apariencia del sistema operativo (opcional pero recomendado)
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Ejecuta la interfaz en el hilo de eventos de Swing
        java.awt.EventQueue.invokeLater(() -> {
            new PanelEntregas().setVisible(true);
        });
    }
}