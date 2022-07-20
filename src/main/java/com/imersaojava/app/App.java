package com.imersaojava.app;

import com.imersaojava.app.entities.Movie;
import com.imersaojava.app.entities.StickersCreator;
import com.imersaojava.app.utils.ApiKey;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class App 
{
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        ApiKey api = new ApiKey();
        //String url = "https://imdb-api.com/en/API/Top250Movies/" + api.getKey();
        String url = "https://api.mocki.io/v2/549a5d8b/Top250Movies";
        URI uri = URI.create(url);

        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body().replace("{\"items\":","");
        body = body.replace(",\"errorMessage\":\"\"", "");

        ObjectMapper mapper = new ObjectMapper();

        StickersCreator stickers = new StickersCreator();

        if (response.statusCode() == 200) {
            Movie[] movies = mapper.readValue(body, Movie[].class);
            int moviePosition = 1;
            for (Movie movie : movies) {
                System.out.println("# "+ moviePosition);
                System.out.println(movie.getTitle());
                System.out.println(movie.getImDbRating());
                System.out.println();
                moviePosition += 1;

                String imageUrl = movie.getImage();
                InputStream inputStream = new URL(movie.getImage()).openStream();
                stickers.generateSticker(inputStream, movie.getTitle().replace(" ", "") + ".png");

            }
        } else {
            System.out.println("Error status code: " + response.statusCode());
        }
    }
}
