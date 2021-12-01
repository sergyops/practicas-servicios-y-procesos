
public class PrecioProducto {

    private String proveedor;
    private float precio;

    //getters y setters
    public String getproveedor() {

        return proveedor;
    }

    public void setproveedor(String proveedor) {

        this.proveedor = proveedor;
    }

    public float getPrecio() {

        return precio;
    }

    public void setPrecio(float precio) {

        this.precio = precio;
    }
    //constructor
    public PrecioProducto(String proveedor, float precio){

        this.proveedor = proveedor;
        this.precio = precio;

    }


}
