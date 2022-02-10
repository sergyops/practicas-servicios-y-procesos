import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Random;

public class ClienteRecaudacion implements Runnable{

    int port = 6000;
    String hostname = "localhost";

    public ClienteRecaudacion() {
    }

    @Override
    public void run() {

        try(Socket cliente = new Socket(hostname,port)) {

            System.out.println("[CLIENTE] Conectando con el servidor...");
            OutputStream out = cliente.getOutputStream();

            System.out.println("[CLIENTE] Enviando recaudación...");
            Random random = new Random();

            PrintStream stream = new PrintStream(out,true);

            stream.println(random.nextInt(1000 - 100));

            cliente.close();
        }catch (IOException e){
            e.printStackTrace();

        }

    }
}
