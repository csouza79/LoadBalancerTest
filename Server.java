import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.Executors;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;

public class Server {
    private final int port;
    private final String name;

    public Server(int port, String name) {
        this.port = port;
        this.name = name;
    }

    public void start() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.setExecutor(Executors.newVirtualThreadPerTaskExecutor());
        server.createContext("/", (HttpExchange exchange) -> {
            String response = "Response from " + name;
            exchange.sendResponseHeaders(200, response.getBytes().length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        });

        System.out.println(name + " is running on port " + port);
        server.start();
    }

    public static void main(String[] args) throws IOException {
        int port = Integer.parseInt(args[0]);
        String name = args[1];
        new Server(port, name).start();
    }
}
