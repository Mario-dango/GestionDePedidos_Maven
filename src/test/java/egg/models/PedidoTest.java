package egg.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class PedidoTest {
    @Test
    void testGetCantidadDePedidos() {
        Pedido pedido = new Pedido(null);
        Pedido pedido1 = new Pedido(null);
        Pedido pedido2 = new Pedido(null);
        Pedido pedido3 = new Pedido(null);
        Pedido pedido4 = new Pedido(null);

        assertEquals(Pedido.getCantidadDePedidos(),5);
        assertEquals(6,6);
    }

    @Test
    void testGetCliente() {
        Pedido nuevPedido = mock(Pedido.class);
        String clientePedido = "Pepe";


        when(nuevPedido.getCliente()).thenReturn(clientePedido);

        assertEquals(nuevPedido.getCliente(), "Pepe");
    }

    @Test
    void testGetElEstadoDelPedido() {

    }

    @Test
    void testGetListaDeProductos() {

    }

    @Test
    void testGetNumeroDePedido() {
        Pedido nuevoPedido = mock(Pedido.class);
        // when(nuevoPedido.getNumeroDePedido()).thenReturn(0);
        assertEquals( nuevoPedido.getNumeroDePedido(), 1);
    }

    @Test
    void testSetCliente() {

    }

    @Test
    void testSetElEstadoDelPedido() {

    }

    @Test
    void testSetListaDeProductos() {

    }

    @Test
    void testSetNumeroDePedido() {

    }
}
