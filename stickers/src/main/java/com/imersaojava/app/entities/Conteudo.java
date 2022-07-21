package com.imersaojava.app.entities;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Conteudo {
    String title = null;
    String imageUrl = null;

    String image;

    public Conteudo() {

    }

    public Conteudo(String title, String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getImage() {
        return image;
    }
}
