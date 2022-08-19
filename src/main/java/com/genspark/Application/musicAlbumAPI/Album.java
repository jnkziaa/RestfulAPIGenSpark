package com.genspark.Application.musicAlbumAPI;

import java.util.Date;
import java.util.List;

public class Album {
    private String id;
    private String albumName;
    private String releaseDate;
    private List<String> genre;
    private List<String> songNames;

    public Album(String id, String albumName, String releaseDate, List<String> genre, List<String> songNames) {
        this.id = id;
        this.albumName = albumName;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.songNames = songNames;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        id = id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public List<String> getSongNames() {
        return songNames;
    }

    public void setSongNames(List<String> songNames) {
        this.songNames = songNames;
    }

    @Override
    public String toString() {
        return "Album{" +
                "Id='" + id + '\'' +
                ", albumName='" + albumName + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", genre=" + genre +
                ", songNames=" + songNames +
                '}';
    }
}
