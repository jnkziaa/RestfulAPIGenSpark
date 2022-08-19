package com.genspark.Application.musicAlbumAPI;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Component
public class MusicService {
    private static List<Singer> singerList = new ArrayList<>();
    private static List<Album> albumList;

    //(String id, String albumName, Date releaseDate, List<String> genre, List<String> songNames) {
    //(String id, String name, List<String> genre, List<String> labels, List<Album> albums)
    static {
        Album album = new Album("Album 1", "Kamikazee", "August 31, 2018", new ArrayList<>(Arrays.asList("HipHop", "Hardcore Hiphop")),
                new ArrayList<>(Arrays.asList("The Ringer", "Greatest", "Lucky You", "Paul", "Normal", "Stepping Stone", "Not Alike", "Kamikaze", "Fall", "Nice Guy", "Good Guy", "Venom")));

        Album album1 = new Album("Album 2", "Revival", "December 15, 2017", new ArrayList<>(Arrays.asList("HipHop", "Rap Rock", "Political Hip Hop")),
                new ArrayList<>(Arrays.asList("Walk on Water", "Believe", "Cholaraseptic", "Untouchable", "River", "Like Home", "Bad Husband", "Framed", "Nowhere Fast", "Heat", "Offended", "Castle")));

        albumList = new ArrayList<>(Arrays.asList(album, album1));
        Singer singer = new Singer("Singer 1", "Eminem", new ArrayList<>(Arrays.asList("Hip Hop")), new ArrayList<>(Arrays.asList("Aftermath", "Shady", "Interscope", "Web")), albumList);
        singerList.add(singer);
        Album album2= new Album("Album 1", "Folklore", "July 24, 2020", new ArrayList<>(Arrays.asList("Indie Folk", "Alternative Rock", "Chamber Pop")),
                new ArrayList<>(Arrays.asList("The 1", "Cardigan", "The Last Grean American Dynasty", "Exile", "My Tears Ricochet",
                        "Mirrorball", "Seven", "August", "This is me Trying", "Invisible String", "Mad Woman", "Epiphany")));
        albumList = new ArrayList<>(Arrays.asList(album2));
        Singer singer1 = new Singer("Singer 2", "Taylor Swift", new ArrayList<>(Arrays.asList("Pop", "Country", "Folk", "Rock", "alternative")),
                new ArrayList<>(Arrays.asList("Republic", "Big Machine")), albumList);
        singerList.add(singer1);



    }

    public List<Singer> retrieveAllMusic() {
        return singerList;
    }

    public Singer retrieveSingerById(String singerId) {
        Predicate<? super Singer> predicate = music -> music.getId().equalsIgnoreCase(singerId);
        Optional<Singer> optionalSinger = singerList.stream().filter(predicate).findFirst();
        if(optionalSinger.isEmpty()){
            return null;
        }
        return optionalSinger.get();
    }


    public List<Album> retrieveAllAlbums(String singerId) {
        Singer singerInMethod = retrieveSingerById(singerId);
        if(singerInMethod == null){
            return null;
        }

        return singerInMethod.getAlbums();
    }
}
