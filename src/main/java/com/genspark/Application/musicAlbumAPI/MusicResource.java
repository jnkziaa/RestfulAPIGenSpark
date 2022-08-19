package com.genspark.Application.musicAlbumAPI;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MusicResource {

    MusicService musicService;

    public MusicResource(MusicService musicService) {
        this.musicService = musicService;
    }

    @RequestMapping("/Singer")
    public List<Singer> retrieveAllMusic(){
        return musicService.retrieveAllMusic();
    }

    @RequestMapping("/Singer/{singerId}")
    public Singer retrieveSpecificSinger(@PathVariable String singerId){
        singerId = stringModifier(singerId);

        return musicService.retrieveSingerById(singerId);

    }

    @RequestMapping("/Singer/{singerId}/Album")
    public List<Album> retrieveAllAlbums(@PathVariable String singerId){
        singerId = stringModifier(singerId);
        List<Album>  albumList =  musicService.retrieveAllAlbums(singerId);
        if(albumList == null){
            return null;
        }

        return albumList;
    }
    private String stringModifier(String input){
        return input.replace("_", " ").toLowerCase();
    }
}
