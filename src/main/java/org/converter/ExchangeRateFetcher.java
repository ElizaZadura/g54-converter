package org.converter;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;

public class ExchangeRateFetcher {
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/SEK"; // Example API URL
    private OkHttpClient client;

    public ExchangeRateFetcher() {
        this.client = new OkHttpClient();
    }

    public double getExchangeRate(String targetCurrency) throws IOException {
        Request request = new Request.Builder().url(API_URL).build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            JSONObject json = new JSONObject(response.body().string());
            return json.getJSONObject("rates").getDouble(targetCurrency);
        }
    }
}
