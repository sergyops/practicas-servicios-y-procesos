public class Main {

    public static void main(String[] args) {
        Server server = new Server();
        ClienteRecaudacion cliente = new ClienteRecaudacion();
        ClienteRecaudacion cliente2 = new ClienteRecaudacion();

        Thread ts = new Thread(server);
        Thread tc = new Thread(cliente);
        Thread tc2 = new Thread(cliente);

        ts.start();
        tc.start();
        tc2.start();
    }
}
