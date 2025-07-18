import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
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

            String json = response.body();
            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
            String resultado = jsonObject.get("result").getAsString();

            if (!resultado.equals("success")) {
                String errorType = jsonObject.get("error-type").getAsString();
                throw new IllegalStateException("Error en respuesta de la API: " + errorType);
            }
            return new Gson().fromJson(json, RespuestaConversion.class);

        } catch (IOException e) {
            System.err.println("Error de conexión o lectura de datos: " + e.getMessage());
            throw new RuntimeException("No se pudo conectar con el servicio de conversión", e);

        } catch (InterruptedException e) {
            System.err.println("La solicitud fue interrumpida: " + e.getMessage());
            Thread.currentThread().interrupt();
            throw new RuntimeException("La operación fue interrumpida", e);

        }
    }
}