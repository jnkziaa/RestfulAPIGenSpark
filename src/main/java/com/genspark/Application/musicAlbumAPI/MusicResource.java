package com.genspark.Application.musicAlbumAPI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @RequestMapping("/Singer/{singerId}/Album/{albumId}")
    public Album retrieveSpecificAlbums(@PathVariable String singerId, @PathVariable String albumId){
        singerId = stringModifier(singerId);
        albumId = stringModifier(albumId);

        Album album = musicService.retrieveSpecificAlbum(singerId, albumId);
        if(album == null){
            return null;
        }

        return album;
    }

    @RequestMapping(value = "/Singer/{singerId}/Album", method = RequestMethod.POST)
    public ResponseEntity<Object> addNewAlbums(@PathVariable String singerId, @RequestBody Album album){
        singerId = stringModifier(singerId);
        String albumId = musicService.addNewAlbum(singerId, album);
        albumId = stringModifier(albumId);
        System.out.println(albumId);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{albumId}").buildAndExpand(albumId).toUri();
        System.out.println(location);
        return ResponseEntity.created(location).build();
    }

    @RequestMapping(value = "/Singer/{singerId}/Album/{albumId}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSpecificAlbum(@PathVariable String singerId, @PathVariable String albumId){
        singerId = stringModifier(singerId);
        albumId = stringModifier(albumId);

        String response = musicService.deleteSpecificAlbum(singerId, albumId);
        if(response == null){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.status(200).build();
    }

    @RequestMapping(value = "/Singer/{singerId}/Album/{albumId}", method = RequestMethod.PUT)
    public void modifySpecificAlbum(@PathVariable String singerId, @PathVariable String albumId, @RequestBody Album album){
        singerId = stringModifier(singerId);
        albumId = stringModifier(albumId);
        musicService.modifySpeficAlbum(singerId, albumId, album);
    }
    private String stringModifier(String input){
        return input.replace("_", " ").toLowerCase();
    }
}
