package egg.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import egg.enums.Producto;
import egg.models.Pedido;

/*
 * Crea la clase MenuServicio para interactuar con el 
 * usuario al inicio de la aplicación. El menú debe mostrar 
 * opciones para que el usuario pueda crear un nuevo pedido, 
 * actualizar el estado de un pedido, buscar pedidos por estado, 
 * mostrar lista de pedidos (también poder filtrarlos) 
 * y salir de la aplicación.
 */

public class MenuServicio {

    private Scanner elScannerDelMenu = new Scanner(System.in);
    private PedidoServicio miPedidoServicio = new PedidoServicio();

    public void imprimirMenu(){
        System.out.println("******MENU******");
        System.out.println("*****************");
        System.out.println("[1] Crear un nuevo pedido.");
        System.out.println("[2] Actualizar estado del pedido.");
        System.out.println("[3] Buscar pedido por estado.");
        System.out.println("[4] Mostrar la Lista de pedidos.");
        System.out.println("[0] Salir");
    }
    
    public void generarMenu() {
        Boolean seguirEnElMenu = true;
        do {
            // elScannerDelMenu = new Scanner(System.in);
            Integer opcion = 0;
            imprimirMenu();
            try {
                opcion = elScannerDelMenu.nextInt();
                switch (opcion) {
                    case 1 -> opcionNumero1();
                    case 2 -> opcionNumero2();
                    case 3 -> opcionNumero3();
                    case 4 -> opcionNumero4();
                    case 0 -> seguirEnElMenu = false;   
                }                   
            } catch (Exception e) {
                System.out.println("La excepción lanzada es: " + e);
                elScannerDelMenu.next();
            } finally {
                System.out.println("Seleccione una opcion numerica valida.");
                // elScannerDelMenu.close();
            }
        } while (seguirEnElMenu);
    }

    private void opcionNumero1(){
        String elCliente;
        System.out.println("Ingrese usuario de cliente:");
        elScannerDelMenu.nextLine();
        elCliente = elScannerDelMenu.nextLine();
        miPedidoServicio.crearNuevoPedido(elCliente);
        System.out.println("Se creó el pedido, actualmente hay una cantidad de: " + Pedido.getCantidadDePedidos());
    }

    private void opcionNumero2(){
        String elCliente;
        System.out.println("Ingrese usuario de cliente:");
        elScannerDelMenu.nextLine();
        elCliente = elScannerDelMenu.nextLine();
        Integer opcion;
        System.out.println("¿A qué estado deseas actualizar?");
        System.out.println("(1) Pendiente.");
        System.out.println("(2) En Proceso.");
        System.out.println("(3) Enviado.");
        System.out.println("(4) Entregado.");
        System.out.println("(0) Cancelar.");
        opcion = elScannerDelMenu.nextInt();
        miPedidoServicio.actualizarPedido(elCliente, opcion);
    }

//      [3] Buscar pedido por estado.
    private void opcionNumero3(){
        String elCliente;
        List<Pedido> elPedidoBuscado = new ArrayList<Pedido>();

        System.out.println("Seleccione el estado del pedido:");
        System.out.println("(1) Pendiente.");
        System.out.println("(2) En Proceso.");
        System.out.println("(3) Enviado.");
        System.out.println("(4) Entregado.");
        System.out.println("(0) Cancelar.");
        elScannerDelMenu.next();
        Integer opcion = elScannerDelMenu.nextInt();
        String estadoPedido = "";
        switch (opcion) {
            case 1 -> estadoPedido = "Pendiente";
            case 2 -> estadoPedido = "Pendiente";
            case 3 -> estadoPedido = "Pendiente";
            case 4 -> estadoPedido = "Pendiente";
            case 0 -> estadoPedido = "Cancelar";
            default -> estadoPedido = "Cancelar";
        }
        System.out.println("¿Desea filtrar antes por cliente?");
        System.out.println("(1) si\t\t(2) No");
        elScannerDelMenu.next();
        opcion = elScannerDelMenu.nextInt();
        if (!estadoPedido.equals("Cancelar")){
            if (opcion == 1){
                System.out.println("Ingrese usuario de cliente:");
                elScannerDelMenu.nextLine();
                elCliente = elScannerDelMenu.nextLine();
                elPedidoBuscado = miPedidoServicio.buscarPedido(estadoPedido, elCliente);
            } else if (opcion == 2){
                elPedidoBuscado = miPedidoServicio.buscarPedido(estadoPedido);

            }
            imprimirListaPedidos(elPedidoBuscado);
        }
    }

    private void opcionNumero4(){
        System.out.println("¿Desea agregar algún filtro?");
        System.out.println("(1) si\t\t(2) No");
        Integer opcion = elScannerDelMenu.nextInt();
        List<Pedido> laListaParaImprimir = new ArrayList<Pedido>();
        if (opcion == 1) {
            System.out.println("Filtros:");
            System.out.println("(1) El cliente");
            System.out.println("(2) Estado");
            System.out.println("(3) Marcas");
            System.out.println("(4) Numero de pedido");
            String opcionFiltro;
            Integer numPedido;
            opcion = elScannerDelMenu.nextInt();            
            switch (opcion) {
                case 1 : 
                    elScannerDelMenu.nextLine(); 
                    System.out.println("Ingrese el cliente:");   
                    opcionFiltro = elScannerDelMenu.nextLine();      
                    laListaParaImprimir = miPedidoServicio.obtenerListaCompletaDePedidos(opcionFiltro, opcion);              
                    break;
                case 2 : 
                    System.out.println("Ingrese el Estado:"); 
                    elScannerDelMenu.nextLine(); 
                    opcionFiltro = elScannerDelMenu.nextLine();               
                    laListaParaImprimir = miPedidoServicio.obtenerListaCompletaDePedidos(opcionFiltro, opcion);       
                    break;
                case 3 : 
                    System.out.println("Ingrese el Marcas:");
                    elScannerDelMenu.nextLine();  
                    opcionFiltro = elScannerDelMenu.nextLine();  
                    laListaParaImprimir = miPedidoServicio.obtenerListaCompletaDePedidos(opcionFiltro, opcion);               
                    break;      
                case 4 : 
                    System.out.println("Ingrese el Número de Pedido:"); 
                    elScannerDelMenu.nextInt(); 
                    numPedido = elScannerDelMenu.nextInt();             
                    laListaParaImprimir = miPedidoServicio.obtenerListaCompletaDePedidos(numPedido, opcion);      
                    break;      
                default:
                    break;
            }
        } else {
            laListaParaImprimir = miPedidoServicio.obtenerListaCompletaDePedidos();
        }                
        imprimirListaPedidos(laListaParaImprimir);
    }

    public void imprimirListaPedidos(List<Pedido> listaPedidoParaImprimir){
        if (listaPedidoParaImprimir.isEmpty()){
            System.out.println("La lista está vacia.");
        } else{
            System.out.println("-------------------LISTA----------------");
            for (Pedido pedido : listaPedidoParaImprimir) {            
                String productoString = "\n";
                for (Producto producto : pedido.getListaDeProductos()) {
                    productoString = productoString + "\t\tNombre: " + producto.getNombre() + " | Marca: " + producto.getMarca() + " | Valor: " + producto.getValor() + "\n";
                }
                System.out.println("El pedido encontrado es:");
                System.out.println("\tCliente: " + pedido.getCliente());
                System.out.println("\tNúmero de pedido: " + pedido.getNumeroDePedido());
                System.out.println("\tPedidos: " + productoString);
                System.out.println("\tEstado: El estado es " + pedido.getElEstadoDelPedido().getDescripcion());
                System.out.println("-----------------------------------------");
            }
        }
        System.out.println();
    }

}
