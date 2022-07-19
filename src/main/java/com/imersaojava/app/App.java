package com.imersaojava.app;


import com.imersaojava.app.utils.ApiKey;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception{
        HttpClient client = HttpClient.newHttpClient();

        ApiKey api = new ApiKey();
        String url = "https://imdb-api.com/en/API/Top250Movies/" + api.getKey();
        URI uri = URI.create(url);

        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        System.out.println(body);

    }
}
