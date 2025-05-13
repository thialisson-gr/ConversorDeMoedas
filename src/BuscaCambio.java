import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscaCambio {
    public Cambio buscaCambio() throws IOException, InterruptedException {
        String apiKey = "ae4ad98901ceaf0fd66cdd87";
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return new Gson().fromJson(response.body(), Cambio.class);
    }
}