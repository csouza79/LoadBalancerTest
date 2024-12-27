import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class LoadBalancer {
    private final List<String> servers;
    private final AtomicInteger currentIndex;

    public LoadBalancer(List<String> servers) {
        this.servers = servers;
        this.currentIndex = new AtomicInteger(0);
    }

    public String getNextServer() {
        int index = currentIndex.getAndUpdate(i -> (i + 1) % servers.size());
        return servers.get(index);
    }

    public String forwardRequest(String clientRequest) throws Exception {
        String server = getNextServer();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(server))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static void main(String[] args) throws Exception {
        List<String> servers = List.of(
            "http://localhost:8081",
            "http://localhost:8082",
            "http://localhost:8083"
        );

        LoadBalancer loadBalancer = new LoadBalancer(servers);

        // Simular requisições de clientes
        for (int i = 0; i < 10; i++) {
            String response = loadBalancer.forwardRequest("ClientRequest" + i);
            System.out.println("Resposta recebida: " + response);
        }
    }
}
