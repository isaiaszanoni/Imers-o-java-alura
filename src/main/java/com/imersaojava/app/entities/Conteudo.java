package com.imersaojava.app.entities;

public class Conteudo {
    private final String title;
    private final String imageUrl;

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
}
