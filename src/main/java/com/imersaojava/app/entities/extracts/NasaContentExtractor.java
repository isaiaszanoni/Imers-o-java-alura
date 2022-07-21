package com.imersaojava.app.entities.extracts;

import com.imersaojava.app.entities.Conteudo;
import com.imersaojava.app.utils.JsonParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NasaContentExtractor {

    public List<Conteudo> extractContent(String json) {

        JsonParser parser = new JsonParser();
        List<Map<String, String>> atributesList = parser.parse(json);

        List<Conteudo> contents = new ArrayList<>();

        for (Map<String, String> atributes : atributesList) {
            String title = atributes.get("title");
            String urlImage = atributes.get("url");
            Conteudo content = new Conteudo(title, urlImage);

            contents.add(content);
        }

        return contents;
    }
}
