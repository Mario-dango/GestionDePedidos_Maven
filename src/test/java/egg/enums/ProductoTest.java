package egg.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class ProductoTest {

    @ParameterizedTest
    @EnumSource(Producto.class)
    void testGetMarca(Producto producto) {
        String marca = producto.getMarca();
        switch (producto) {
            case PIZZA:
                assertEquals("Casera", marca);
                break;
            case EMPANADA:
                assertEquals("Casera J&Q", marca);
                break;
            case CERVEZA:
                assertEquals("Quilmes", marca);
                break;
            case GASEOSA:
                assertEquals("Coca Cola", marca);
                break;
        }
    }

    @ParameterizedTest
    @EnumSource(Producto.class)
    void testGetNombre(Producto producto) {
        String nombre = producto.getNombre();
        switch (producto) {
            case PIZZA:
                assertEquals("Muzza 8p", nombre);
                break;
            case EMPANADA:
                assertEquals("Empanadas 6u", nombre);
                break;
            case CERVEZA:
                assertEquals("Cerveza", nombre);
                break;
            case GASEOSA:
                assertEquals("Gaseosa", nombre);
                break;
        }
    }

    @ParameterizedTest
    @EnumSource(Producto.class)
    void testGetValor(Producto producto) {
        Integer valor = producto.getValor();
        switch (producto) {
            case PIZZA:
                assertEquals(1500, valor);
                break;
            case EMPANADA:
                assertEquals(2500, valor);
                break;
            case CERVEZA:
                assertEquals(970, valor);
                break;
            case GASEOSA:
                assertEquals(870, valor);
                break;
        }
    }

    @ParameterizedTest
    @EnumSource(Producto.class)
    void testValueOf(Producto producto) {
        Producto productoObtenido = Producto.valueOf(producto.name());
        assertEquals(producto, productoObtenido);
    }

    @Test
    void testValues() {
        Producto[] productos = Producto.values();
        assertEquals(4, productos.length);
        assertEquals(Producto.PIZZA, productos[0]);
        assertEquals(Producto.EMPANADA, productos[1]);
        assertEquals(Producto.CERVEZA, productos[2]);
        assertEquals(Producto.GASEOSA, productos[3]);
    }
}
