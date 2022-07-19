package com.imersaojava.app;

import com.imersaojava.app.entities.Movie;
import com.imersaojava.app.utils.ApiKey;
import org.codehaus.jackson.map.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class App 
{
    public static void main(String[] args) throws Exception{
        HttpClient client = HttpClient.newHttpClient();

        ApiKey api = new ApiKey();
        String url = "https://imdb-api.com/en/API/Top250Movies/" + api.getKey();
        URI uri = URI.create(url);

        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body().replace("{\"items\":","");
        body = body.replace(",\"errorMessage\":\"\"", "");

        ObjectMapper mapper = new ObjectMapper();

        if (response.statusCode() == 200) {
            Movie[] movies = mapper.readValue(body, Movie[].class);
            int moviePosition = 1;
            for (Movie movie : movies) {
                System.out.println("# "+ moviePosition);
                System.out.println(movie.getTitle());
                System.out.println(movie.getImDbRating());
                System.out.println();
                moviePosition += 1;
            }
        } else {
            System.out.println("Error status code: " + response.statusCode());
        }


    }
}
