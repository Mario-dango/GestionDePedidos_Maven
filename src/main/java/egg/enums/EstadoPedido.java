package egg.enums;
// Los estados posibles son "pendiente", "en proceso", "enviado" y "entregado".
public enum EstadoPedido {

    PENDIENTE("Pendiente."),
    EN_PROCESO("En proceso."), 
    ENVIADO("Enviado."), 
    ENTREGADO("Entregado.");

    private String descripcion;

    private EstadoPedido(String laDescripcion){
        this.descripcion = laDescripcion;
    }

    public String getDescripcion(){
        return this.descripcion;
    }
}
