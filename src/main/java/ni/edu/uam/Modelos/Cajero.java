package ni.edu.uam.Modelos;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Cajero {
    private String nombre;
    private Cocina cocina;
    private ArrayList<Pedido> listaPedidos;
    private int contadorId;

    public Cajero(String nombre, Cocina cocina) {
        this.nombre = nombre;
        this.cocina = cocina;
        this.listaPedidos = new ArrayList<>();
        this.contadorId = 1;
    }

    public void iniciarMenu() {
        boolean ejecutar = true;

        while (ejecutar) {
            String menu = "MENÚ CAFETERÍA \n" +
                    "Cajero: " + nombre + "\n\n" +
                    "1. Agregar pedido\n" +
                    "2. Ver pedidos\n" +
                    "3. Eliminar pedido\n" +
                    "4. Modificar estado\n" +
                    "5. Salir\n\n" +
                    "Seleccione una opción:";

            String opcionStr = JOptionPane.showInputDialog(menu);

            if (opcionStr == null) {
                break;
            }

            try {
                int opcion = Integer.parseInt(opcionStr);

                switch (opcion) {
                    case 1:
                        crearPedido();
                        break;
                    case 2:
                        mostrarPedidos();
                        break;
                    case 3:
                        eliminarPedido();
                        break;
                    case 4:
                        modificarEstado();
                        break;
                    case 5:
                        ejecutar = false;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción inválida.");
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número.");
            }
        }
    }

    private void crearPedido() {
            String nombreCliente = JOptionPane.showInputDialog("Nombre del cliente:");

            Cliente cliente = new Cliente(nombreCliente);
            Pedido pedido = new Pedido(contadorId++, cliente);

        int cantidad = Integer.parseInt(
                JOptionPane.showInputDialog("¿Cuántos productos desea agregar?")
        );

        for (int i = 0; i < cantidad; i++) {
            String nombreProducto = JOptionPane.showInputDialog("Nombre del producto:");
            double precio = Double.parseDouble(
                    JOptionPane.showInputDialog("Precio del producto:")
            );

            pedido.agregarProducto(new Producto(nombreProducto, precio));
        }

        listaPedidos.add(pedido);

        cliente.recibirNotificacion(
                "Su pedido #" + pedido.getId() + " fue registrado."
        );

        cocina.prepararPedido(pedido, this);
    }

    public void notificarPedidoListo(Pedido pedido) {
        JOptionPane.showMessageDialog(
                null,
                "Pedido #" + pedido.getId() + " listo."
        );

        pedido.getCliente().recibirNotificacion(
                "Su pedido está listo para entregar."
        );
    }

    private void mostrarPedidos() {
        if (listaPedidos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay pedidos.");
            return;
        }

        StringBuilder texto = new StringBuilder();

        for (Pedido pedido : listaPedidos) {
            texto.append(pedido).append("\n");
        }

        JOptionPane.showMessageDialog(null, texto.toString());
    }

    private void eliminarPedido() {
        int id = Integer.parseInt(
                JOptionPane.showInputDialog("Ingrese ID del pedido:")
        );

        boolean eliminado = listaPedidos.removeIf(
                pedido -> pedido.getId() == id
        );

        if (eliminado) {
            JOptionPane.showMessageDialog(null, "Pedido eliminado.");
        } else {
            JOptionPane.showMessageDialog(null, "Pedido no encontrado.");
        }
    }

    private void modificarEstado() {
        int id = Integer.parseInt(
                JOptionPane.showInputDialog("ID del pedido:")
        );

        for (Pedido pedido : listaPedidos) {
            if (pedido.getId() == id) {
                String nuevoEstado = JOptionPane.showInputDialog(
                        "Nuevo estado (Listo , Entregado ):"
                );

                pedido.cambiarEstado(nuevoEstado.toUpperCase());

                JOptionPane.showMessageDialog(
                        null,
                        "Estado actualizado."
                );
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Pedido no encontrado.");
    }
}