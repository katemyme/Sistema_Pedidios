package ni.edu.uam.Modelos;

public class Cocina {

    public void prepararPedido(Pedido pedido, Cajero cajero) {
        pedido.cambiarEstado("EN PREPARACIÓN");
        System.out.println("Cocina preparando pedido #" + pedido.getId());

        pedido.cambiarEstado("LISTO");
        System.out.println("Pedido #" + pedido.getId() + " listo");

        cajero.notificarPedidoListo(pedido);
    }
}