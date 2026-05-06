package ni.edu.uam;
import ni.edu.uam.Modelos.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Cocina cocina = new Cocina();
        String nombreCajero = JOptionPane.showInputDialog("Nombre del Cajero de turno:");
        Cajero cajero = new Cajero(nombreCajero, cocina);
        cajero.iniciarMenu();

        JOptionPane.showMessageDialog(null, "Cerrando sistema de cafetería...");
    }
}