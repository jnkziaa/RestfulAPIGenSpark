package com.genspark.Application.musicAlbumAPI;

import java.util.List;

public class Singer {
    private String id;
    private String name;
    private List<String> genre;
    private List<String> labels;
    private List<Album> albums;

    public Singer(String id, String name, List<String> genre, List<String> labels, List<Album> albums) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.labels = labels;
        this.albums = albums;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    @Override
    public String toString() {
        return "Singer{" +
                "Id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", genre=" + genre +
                ", labels=" + labels +
                ", albums=" + albums +
                '}';
    }
}
