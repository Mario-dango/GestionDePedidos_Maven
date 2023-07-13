package egg.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class EstadoPedidoTest {

    @ParameterizedTest
    @EnumSource(EstadoPedido.class)
    void testGetDescripcion(EstadoPedido estado) {
        String descripcion = estado.getDescripcion();
        switch (estado) {
            case PENDIENTE:
                assertEquals("Pendiente.", descripcion);
                break;
            case EN_PROCESO:
                assertEquals("En proceso.", descripcion);
                break;
            case ENVIADO:
                assertEquals("Enviado.", descripcion);
                break;
            case ENTREGADO:
                assertEquals("Entregado.", descripcion);
                break;
        }
    }

    @ParameterizedTest
    @EnumSource(EstadoPedido.class)
    void testValueOf(EstadoPedido estado) {
        EstadoPedido estadoObtenido = EstadoPedido.valueOf(estado.name());
        assertEquals(estado, estadoObtenido);
    }

    @Test
    void testValues() {
        EstadoPedido[] estados = EstadoPedido.values();
        assertEquals(4, estados.length);
        assertEquals(EstadoPedido.PENDIENTE, estados[0]);
        assertEquals(EstadoPedido.EN_PROCESO, estados[1]);
        assertEquals(EstadoPedido.ENVIADO, estados[2]);
        assertEquals(EstadoPedido.ENTREGADO, estados[3]);
    }
}
