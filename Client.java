import java.util.List;

public class Client {
    public static void main(String[] args) throws Exception {
        LoadBalancer loadBalancer = new LoadBalancer(List.of(
            "http://localhost:8081",
            "http://localhost:8082",
            "http://localhost:8083"
        ));

        for (int i = 1; i <= 5; i++) {
            System.out.println("Cliente enviando requisição " + i);
            String response = loadBalancer.forwardRequest("Request " + i);
            System.out.println("Resposta do servidor: " + response);
        }
    }
}
