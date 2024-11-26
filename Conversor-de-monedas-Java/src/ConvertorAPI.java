import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConvertorAPI {

    public ConversionRates defaultUSDMap;
    public void getDefaultMapFromApi()
    {
        URI url = URI.create("https://v6.exchangerate-api.com/v6/61d7b0811dbac7f3ced6aa09/latest/USD");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            defaultUSDMap = new Gson().fromJson(response.body(), ConversionRates.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("No se pudo obtener contacto con el servidor"+e.getMessage());
        }
    }
    public boolean isCodeInAPI(String code)
    {
        return defaultUSDMap.conversion_rates().containsKey(code);
    }
    public double getOtherCurrency(String fromCurrency, String toCurrency)
    {
        URI url = URI.create("https://v6.exchangerate-api.com/v6/61d7b0811dbac7f3ced6aa09/latest/"+fromCurrency);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            ConversionRates rates = new Gson().fromJson(response.body(), ConversionRates.class);
            return rates.conversion_rates().get(toCurrency);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("No se pudo obtener contacto con el servidor"+e.getMessage());
        }
    }
}
