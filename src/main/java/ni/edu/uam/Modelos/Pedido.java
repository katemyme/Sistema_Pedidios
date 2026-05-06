package ni.edu.uam.Modelos;

import java.util.ArrayList;

public class Pedido {
    private int id;
    private Cliente cliente;
    private ArrayList<Producto> productos;
    private String estado;

    public Pedido(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.estado = "PENDIENTE";
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void cambiarEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Pedido #" + id +
                " | Cliente: " + cliente.getNombre() +
                " | Estado: " + estado +
                " | Productos: " + productos.size();
    }
}