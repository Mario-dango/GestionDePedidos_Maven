package egg.models;

import java.util.ArrayList;
import java.util.List;
import egg.enums.EstadoPedido;
import egg.enums.Producto;

/*
 * Crea el modelo Pedido que contenga los siguientes atributos: 
 * número de pedido, cliente, lista de productos y estado del pedido. 
 * El estado del pedido debe ser una constante de la enumeración 
 * "EstadoPedido". La lista de productos debe ser un array de Strings
 */

public class Pedido {
    
    private static int cantidadDePedidos;

    private int numeroDePedido;
    private String cliente;
    private List<Producto> listaDeProductos = new ArrayList<Producto>();
    private EstadoPedido elEstadoDelPedido;

    public Pedido(String suCliente ){
        cantidadDePedidos++;
        this.numeroDePedido = cantidadDePedidos;
        this.cliente = suCliente;
        this.elEstadoDelPedido = EstadoPedido.PENDIENTE;
        Producto[] losProductos = Producto.values();
        for (int i = 0; i < 2; i++) {
            int random = (int) (Math.random()*(3-0+1)+0);
            listaDeProductos.add(losProductos[random]);
        }
    }
    
    public int getNumeroDePedido() {
        return numeroDePedido;
    }
    public void setNumeroDePedido(int numeroDePedido) {
        this.numeroDePedido = numeroDePedido;
    }

    public String getCliente() {
        return cliente;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getListaDeProductos() {
        return listaDeProductos;
    }
    public void setListaDeProductos(List<Producto> listaDeProductos) {
        this.listaDeProductos = listaDeProductos;
    }
    
    public EstadoPedido getElEstadoDelPedido() {
        return elEstadoDelPedido;
    }
    public void setElEstadoDelPedido(EstadoPedido elEstadoDelPedido) {
        this.elEstadoDelPedido = elEstadoDelPedido;
    }
    
    public static int getCantidadDePedidos() {
        return cantidadDePedidos;
    }
}
