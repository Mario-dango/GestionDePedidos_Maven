package egg.enums;

public enum Producto {    
    PIZZA("Muzza 8p", "Casera", 1500),
    EMPANADA("Empanadas 6u", "Casera J&Q", 2500), 
    CERVEZA("Cerveza", "Quilmes", 970), 
    GASEOSA("Gaseosa", "Coca Cola", 870);

    private String marca;
    private String nombre;

    private Integer valor;

    private Producto(String elNombre, String laMarca, Integer loQueCuesta){
        this.nombre = elNombre;
        this.marca = laMarca;
        this.valor = loQueCuesta;
    }

    public String getMarca(){
        return this.marca;
    }

    public Integer getValor() {
        return valor;
    }
    
    public String getNombre() {
        return nombre;
    }
}
