package com.imersaojava.app;

import com.imersaojava.app.client.Client;
import com.imersaojava.app.entities.Conteudo;
import com.imersaojava.app.entities.StickersCreator;
import com.imersaojava.app.entities.extracts.NasaContentExtractor;
import com.imersaojava.app.utils.ApiKey;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class App2 {

    public static void main(String[] args) throws Exception {
        Client client = new Client();
        ApiKey key = new ApiKey();
        //String nasaUrl = "https://api.nasa.gov/planetary/apod" + key.getNasaKey();
        String nasaUrl = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";
        String json = client.getData(nasaUrl);
        NasaContentExtractor extractor = new NasaContentExtractor();
        List<Conteudo> contents = extractor.extractContent(json);
        System.out.println(json);

        StickersCreator stickersCreator = new StickersCreator();
        for (int i = 0; i < 3; i++) {
            Conteudo content = contents.get(i);

            InputStream inputStream = new URL(content.getImageUrl()).openStream();

            stickersCreator.generateSticker(inputStream, content.getTitle() + ".png");

        }

    }



}
