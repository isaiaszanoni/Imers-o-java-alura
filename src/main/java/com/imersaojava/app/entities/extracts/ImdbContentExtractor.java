package com.imersaojava.app.entities.extracts;

import com.imersaojava.app.entities.Conteudo;
import com.imersaojava.app.entities.Movie;
import com.imersaojava.app.interfaces.ExtractContents;
import com.imersaojava.app.utils.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImdbContentExtractor implements ExtractContents{

    public List<Conteudo> extractContent(String json) {
        ObjectMapper mapper = new ObjectMapper();
        JsonParser parser = new JsonParser();
        json = parser.removeItemAndErrorsMessageFromJson(json);

        try {
            Conteudo[] movies = mapper.readValue(json, Conteudo[].class);

            return List.of(movies);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
