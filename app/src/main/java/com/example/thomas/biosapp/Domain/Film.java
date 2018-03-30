package com.example.thomas.biosapp.Domain;

import java.io.Serializable;

/**
 * Created by steph on 21-3-2018.
 */

public class Film implements Serializable {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Film film = (Film) o;

        if (!name.equals(film.name)) return false;
        if (!posterUrl.equals(film.posterUrl)) return false;
        if (!description.equals(film.description)) return false;
        return id.equals(film.id);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + posterUrl.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + id.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", posterUrl='" + posterUrl + '\'' +
                ", description='" + description + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
