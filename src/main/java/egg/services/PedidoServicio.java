package egg.services;

import java.util.ArrayList;
import java.util.List;

import egg.enums.EstadoPedido;
import egg.enums.Producto;
import egg.models.Pedido;

/*
 * Crea la clase PedidoServicio que se encargue de gestionar los pedidos.
 * Esta clase debe tener métodos
 * para crear un nuevo pedido, actualizar el estado de un pedido existente, 
 * buscar pedidos por estado, y obtener la lista completa de pedidos y 
 * realizar filtros sobre la misma.
 */

public class PedidoServicio {

    private List<Pedido> listaDePedidos = new ArrayList<Pedido>();
    
    public void crearNuevoPedido(String elClienteSolicitaQuePedido) {
        Pedido nuevoPedido = new Pedido(elClienteSolicitaQuePedido);
        listaDePedidos.add(nuevoPedido);
    }

    public void actualizarPedido(String elClienteSolicitaActualizar, Integer opcion) {
        Pedido elPedidoParaActualziar = new Pedido(null);
        for (Pedido pedido : listaDePedidos) {
            if (pedido.getCliente().equals(elClienteSolicitaActualizar)){
                elPedidoParaActualziar = pedido;
            }
        }
        switch (opcion) {
            case 1:
                elPedidoParaActualziar.setElEstadoDelPedido(EstadoPedido.PENDIENTE);
                break;
            case 2:
                elPedidoParaActualziar.setElEstadoDelPedido(EstadoPedido.EN_PROCESO);
                break;
            case 3:
                elPedidoParaActualziar.setElEstadoDelPedido(EstadoPedido.ENVIADO);
                break;
            case 4:
                elPedidoParaActualziar.setElEstadoDelPedido(EstadoPedido.ENTREGADO);
                break;    
            case 0:
                break;         
            default:
                break;
        }
    }

    public List<Pedido> buscarPedido(String estadoPedido, String elClienteSolicitaSuPedido) {
        List<Pedido> listaPedidoBuscado = new ArrayList<Pedido>();
        for (Pedido pedido : listaDePedidos) {
            if (pedido.getCliente().equals(elClienteSolicitaSuPedido)){
                if (pedido.getElEstadoDelPedido().getDescripcion().equals(estadoPedido)){
                    listaPedidoBuscado.add(pedido);
            }
            }
        }
        return listaPedidoBuscado;
    }
    
    public List<Pedido> buscarPedido(String estadoPedido) {
        List<Pedido> listaPedidoBuscado = new ArrayList<Pedido>();
        for (Pedido pedido : listaDePedidos) {
            if (pedido.getElEstadoDelPedido().getDescripcion().equals(estadoPedido)){
                listaPedidoBuscado.add(pedido);
            }
        }
        return listaPedidoBuscado;
    }

    public List<Pedido> obtenerListaCompletaDePedidos() {
        return listaDePedidos;
    }

    public List<Pedido> obtenerListaCompletaDePedidos(String filtro, Integer tipoFiltro) {
        List<Pedido> listaParaDevolver = new ArrayList<Pedido>();
        if (tipoFiltro == 1) {
            for (Pedido pedido : listaDePedidos) {
                if (pedido.getCliente().equals(filtro)){
                    listaParaDevolver.add(pedido);
                }
            }
        } else if (tipoFiltro == 2){
            for (Pedido pedido : listaDePedidos) {
                if (pedido.getElEstadoDelPedido().getDescripcion().equals(filtro)){
                    listaParaDevolver.add(pedido);
                }
            }
        } else if (tipoFiltro == 3){
            for (Pedido pedido : listaDePedidos) {
                List<Producto> listaProductos = pedido.getListaDeProductos();
                for (Producto productos : listaProductos) {
                    if (productos.getMarca().equals(filtro)){
                        listaParaDevolver.add(pedido);
                    }                    
                }
            }
        } else {
            return null;
        }
        return listaParaDevolver;
    }

    public List<Pedido> obtenerListaCompletaDePedidos(Integer numeroPedido, Integer tipoFiltro) {
        List<Pedido> listaParaDevolver = new ArrayList<Pedido>();
        if (tipoFiltro == 1) {
            for (Pedido pedido : listaDePedidos) {
                if (pedido.getNumeroDePedido() == (numeroPedido)){
                    listaParaDevolver.add(pedido);
                }
            }
        }
        return listaParaDevolver;
    }

}
