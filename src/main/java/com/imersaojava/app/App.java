package com.imersaojava.app;

import com.imersaojava.app.client.Client;
import com.imersaojava.app.entities.Conteudo;
import com.imersaojava.app.entities.Movie;
import com.imersaojava.app.entities.StickersCreator;
import com.imersaojava.app.entities.extracts.ImdbContentExtractor;
import com.imersaojava.app.entities.extracts.NasaContentExtractor;
import com.imersaojava.app.utils.ApiKey;
import com.imersaojava.app.utils.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App 
{
    public static void main(String[] args) throws Exception {

        ApiKey api = new ApiKey();
//      String imdbUrl = "https://imdb-api.com/en/API/Top250Movies/" + api.getKey();
        String imdbUrl = "https://api.mocki.io/v2/549a5d8b/MostPopularMovies";
        Client client = new Client();
        String body = client.getData(imdbUrl);

        JsonParser parser = new JsonParser();
        body = parser.removeItemAndErrorsMessageFromJson(body);

        ObjectMapper mapper = new ObjectMapper();

        StickersCreator stickers = new StickersCreator();

        Movie[] movies = mapper.readValue(body, Movie[].class);
        int moviePosition = 1;
        for (Movie movie : movies) {
            System.out.println("# " + moviePosition);
            System.out.println(movie.getTitle());
            System.out.println(movie.getImDbRating());
            System.out.println();
            moviePosition += 1;

            String imageUrl = movie.getImage();
            InputStream inputStream = new URL(movie.getImage()).openStream();
            stickers.generateSticker(inputStream, movie.getTitle().replace(" ", "") + ".png");

        }
    }
}
