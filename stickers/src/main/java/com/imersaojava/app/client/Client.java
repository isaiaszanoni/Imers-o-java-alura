package com.imersaojava.app.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Client {
    private int responseCode;

    public String getData(String url) {

        try {
            HttpClient client = HttpClient.newHttpClient();
            URI uri = URI.create(url);
            HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

            this.responseCode = response.statusCode();
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getResponseCode() {
        return responseCode;
    }
}
