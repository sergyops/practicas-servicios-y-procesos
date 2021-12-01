import java.util.ArrayList;
import java.util.Iterator;

public class ExclusionMutua{

    //Single-ton
    private static ExclusionMutua semaforoBinario;

    //Implementación semáforo binario
    private static int recurso = 1;


    public final static ExclusionMutua getInstance(){
        if(semaforoBinario == null){
            semaforoBinario = new ExclusionMutua();
        }
        return semaforoBinario;
    }

    //creamos un arraylist para almacenar todos los productos con sus proveedores

        ArrayList<PrecioProducto> producto = new ArrayList<PrecioProducto>();

    //Método para añadir productos desde otra clase
    public void addproducto(String proveedor, float precio){

        producto.add(new PrecioProducto(proveedor,precio));

    }


    public synchronized void entrada_seccion_critica(String proveedor, float precio){

        //Comprobamos si está disponible, si no está disponible, esperamos.
        while(!estaDisponible()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//==================================================================================================================================

        //----------> En esta parte se escribe lo que se ejecuta al estar disponible <----------

        //Cambia el recurso a 0, es decir, que SI está siendo utilizado y NO ESTÁ DISPONIBLE.
        recurso = recurso - 1;

        //variable para almacenar un true o false según se haya encontrado o no el producto
        //la inicializamos con un false
        boolean encontrado = false;

        //Se crea un iterator para acceder al arraylist
        Iterator<PrecioProducto> iterador = producto.iterator();

        /*
        En el while va recorriendo TODAS las posiciones del array y lo almacena en "p"
        Después con el if vamos comparando:
        El proveedor que nos muestra el while, con el proveedor que tenemos almacenado en la variable.
        Si es el mismo, entonces:
        1. Se cambia la variable "encontrado" a true.
        2. Se cambia el precio del producto a uno nuevo que se haya introducido y tenemos almacenado en la variable precio.
        */
        while (iterador.hasNext()){
            PrecioProducto p = iterador.next();

            if(p.getproveedor()==proveedor){
                encontrado=true;
                p.setPrecio(precio);

                System.out.println("Se ha encontrado el proveedor " + proveedor);
                System.out.println("Añadiendo nuevo precio de: " + precio + " €");
            }
        }

        /*
        Si no se ha encontrado el proveedor con el while, se añade un nuevo elemento a la arraylist
        con la información que tenemos en las variables proveedor y precio
         */
        if(!encontrado){
            producto.add(new PrecioProducto(proveedor,precio));

            System.out.println("No se ha encontrado el proveedor " + proveedor);
            System.out.println("Añadiendo nuevo producto...");
            System.out.println("Proveedor: "+ proveedor);
            System.out.println("Precio: " + precio + "€");
        }

        //Se notifica que ha terminado
        this.notifyAll();
//==================================================================================================================================
    }




    public synchronized void salida_seccion_critica(){

        //Comprobamos si NO está disponible, si está disponible, esperamos.
        while(estaDisponible()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



//==================================================================================================================================

        //----------> En esta parte se escribe lo que se ejecuta al NO ESTAR DISPONIBLE <----------

        //Cambia el recurso a 0, es decir, que NO está siendo utilizado y ESTÁ DISPONIBLE.
        recurso = recurso + 1;

        //Se notifica que ha terminado
        this.notifyAll();
//==================================================================================================================================
    }


    public synchronized final static boolean estaDisponible(){

        return recurso == 1 ? true : false;
    }


}
