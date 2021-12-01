
public class AddProductos implements Runnable{

    private static ExclusionMutua semaforoBinario = null;

    public AddProductos(ExclusionMutua s) {
        semaforoBinario = s;
    }


    public ExclusionMutua clase = new ExclusionMutua();



    @Override
    public void run() {

        //Añadimos productos de prueba
        clase.addproducto("marca1",3);
        clase.addproducto("marca2",10);
        clase.addproducto("marca3",20);

        //Añadimos los cambios al producto o añadimos un producto nuevo

        clase.entrada_seccion_critica("marca1",5);

    }
}
