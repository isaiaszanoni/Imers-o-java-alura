package com.imersaojava.app.entities.extracts;

import com.imersaojava.app.entities.Conteudo;
import com.imersaojava.app.entities.Movie;
import com.imersaojava.app.utils.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImdbContentExtractor {

    public Movie[] extractContent(String json) {
        ObjectMapper mapper = new ObjectMapper();
        JsonParser parser = new JsonParser();
        json = parser.removeItemAndErrorsMessageFromJson(json);

        try {
            Movie[] movies = mapper.readValue(json, Movie[].class);

            return movies;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
