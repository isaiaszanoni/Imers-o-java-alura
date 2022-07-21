package br.com.alura.languagesapi.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mainLanguages")
public class Language {

    @Id
    private String id;
    private String title;
    private String image;
    private int rankPosition;

    public Language() {

    }

    public Language(String title, String image, int rankPosition) {
        this.title = title;
        this.image = image;
        this.rankPosition = rankPosition;
    }

    public Language(String id, String title, String image, int rankPosition) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.rankPosition = rankPosition;
    }

    public String getId() { return id; }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getRankPosition() {
        return rankPosition;
    }

    public void setRankPosition(int rankPosition) {
        this.rankPosition = rankPosition;
    }
}
