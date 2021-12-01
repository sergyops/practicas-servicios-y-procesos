
public class Main {

    public static void main(String[] args) {

        Thread Cambio = new Thread(new AddProductos(ExclusionMutua.getInstance()));

        Cambio.start();

    }
}
