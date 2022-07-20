package com.imersaojava.app.entities;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

    String title;
    double imDbRating;

    String image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getImDbRating() {
        return imDbRating;
    }

    public void setImDbRating(double imDbRating) {
        this.imDbRating = imDbRating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
