import java.util.Random;

public class ControladorAfluencia extends Thread {


    private int numAdultosTotales = 0;
    private int numNinyosTotales = 0;
    private int limiteAfluenciaTotal = 100;
    int total = 0;

    Random random = new Random();

    @Override
    public void run() {

        while (limiteAfluenciaTotal > 0) {

            try {
                Thread.sleep(3000);

                
                numAdultosTotales = random.nextInt((limiteAfluenciaTotal - 0) + 1);

                limiteAfluenciaTotal = limiteAfluenciaTotal - numAdultosTotales;

                System.out.println("actual: " +limiteAfluenciaTotal);

                numNinyosTotales = random.nextInt((limiteAfluenciaTotal - 0) + 1);

                limiteAfluenciaTotal = limiteAfluenciaTotal - numNinyosTotales;

                total = total + numAdultosTotales + numNinyosTotales;

                System.out.println("Adultos: " + numAdultosTotales + " | Niños: " + numNinyosTotales + " | Total: " + total);
                System.out.println("Huecos restantes: " + limiteAfluenciaTotal);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
