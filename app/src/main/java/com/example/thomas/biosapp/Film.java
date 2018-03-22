package com.example.thomas.biosapp;

/**
 * Created by steph on 21-3-2018.
 */

public class Film {
    private String name;
    private String posterUrl;
    private String description;
    private String id;

    public Film(String name, String posterUrl, String description,
                String id) {
        this.name = name;
        this.posterUrl = posterUrl;
        this.description = description;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
