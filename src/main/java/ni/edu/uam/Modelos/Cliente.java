package ni.edu.uam.Modelos;

import javax.swing.*;

public class Cliente {
    private String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public void recibirNotificacion(String mensaje) {
        JOptionPane.showMessageDialog(null,
                "NOTIFICACIÓN PARA " + nombre.toUpperCase() + ":\n" + mensaje,
                "Aviso al Cliente",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public String getNombre() { return nombre; }
}