import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexionApi {
    String url = "https://v6.exchangerate-api.com/v6/56fb7601020c97ccd13397f2/pair/";
    public RespuestaConversion conectar(String monedaBase, String monedaAConvertir, double cantidad){
        String url = "https://v6.exchangerate-api.com/v6/56fb7601020c97ccd13397f2/pair/"+ monedaBase +"/"+ monedaAConvertir +"/"+ cantidad;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String>    response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), RespuestaConversion.class);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo realizar la conversión");
        }

    }
}