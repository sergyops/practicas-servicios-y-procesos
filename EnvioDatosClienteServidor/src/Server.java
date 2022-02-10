import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{

    int port = 6000;

    public Server() {
    }

    @Override
    public void run() {

        try(ServerSocket server = new ServerSocket(port)) {

            while (true){
                Socket socket = server.accept();

                InputStream input = socket.getInputStream();

                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                String leerRecaudacion = reader.readLine();

                System.out.println("[SERVIDOR] El cliente ha recaudado: " + leerRecaudacion);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
