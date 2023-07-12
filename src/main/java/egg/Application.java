package egg;

import egg.services.MenuServicio;

public class Application {

    public static void main(String[] args) {
        MenuServicio menuDeLaAplicacion = new MenuServicio();
        menuDeLaAplicacion.generarMenu();
    }
}
