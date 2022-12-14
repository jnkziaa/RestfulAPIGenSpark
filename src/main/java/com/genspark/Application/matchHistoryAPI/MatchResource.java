package com.genspark.Application.matchHistoryAPI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class MatchResource {

    MatchHistoryService matchHistoryService;

    public MatchResource(MatchHistoryService matchHistoryService){
        this.matchHistoryService = matchHistoryService;
    }

    @RequestMapping("/hello-world")
    public String helloWorld(){
        return "hello world";
    }



    @RequestMapping("/matchHistory")
    public List<MatchHistory> retrieveAllMatches(){
        return matchHistoryService.retrieveAllMatches();
    }

    @RequestMapping("/matchHistory/{matchHistoryId}")
    public MatchHistory retrieveHistory(@PathVariable String matchHistoryId){
        matchHistoryId =  stringModifier(matchHistoryId); //turns "player_1" to "player 1" for aesthetics
        MatchHistory matchHistory = matchHistoryService.retrieveMatchHistoryById(matchHistoryId);
        if(matchHistory == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return matchHistory;
    }

    @RequestMapping("/matchHistory/{matchHistoryId}/matches")
    public List<Matches> retrieveAllMatches(@PathVariable String matchHistoryId){
        matchHistoryId =  stringModifier(matchHistoryId); //turns "player_1" to "player 1" for aesthetics
        List<Matches> matches = matchHistoryService.retrieveAllMatchesInHistory(matchHistoryId);
        if(matches == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return matches;

    }

    @RequestMapping("/matchHistory/{matchHistoryId}/matches/{matchesId}")
    public Matches retrieveSpecificMatch(@PathVariable String matchHistoryId, @PathVariable String matchesId){
        matchHistoryId =  stringModifier(matchHistoryId); //turns "player_1" to "player 1" for aesthetics
        matchesId =  stringModifier(matchesId);
        Matches matches = matchHistoryService.retrieveSpecificMatch(matchHistoryId, matchesId);
        if(matches == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return matches;
    }


    @RequestMapping(value = "/matchHistory/{matchHistoryId}/matches", method = RequestMethod.POST)
    public ResponseEntity<Object> addNewMatches(@PathVariable String matchHistoryId, @RequestBody Matches matches){
        matchHistoryId =  stringModifier(matchHistoryId); //turns "player_1" to "player 1" for aesthetics
        String matchesId = matchHistoryService.addNewMatches(matchHistoryId, matches);
        matchesId = stringModifier(matchesId);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{matchesId}").buildAndExpand(matchesId).toUri();
        return ResponseEntity.created(location).build();

    }

    @RequestMapping(value = "/matchHistory/{matchHistoryId}/matches/{matchesId}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSpecificMatch(@PathVariable String matchHistoryId, @PathVariable String matchesId){
        matchHistoryId =  stringModifier(matchHistoryId); //turns "player_1" to "player 1" for aesthetics
        matchesId = stringModifier(matchesId);
        String response = matchHistoryService.deleteSpecificMatch(matchHistoryId, matchesId);
        if(response==null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(200).build(); //refer to notes.txt for number code definition.
    }

    @RequestMapping(value = "/matchHistory/{matchHistoryId}/matches/{matchesId}", method = RequestMethod.PUT)
    public void modSpecMatch(@PathVariable String matchHistoryId, @PathVariable String matchesId, @RequestBody Matches matches){
        matchHistoryId =  stringModifier(matchHistoryId); //turns "player_1" to "player 1" for aesthetics
        matchesId = stringModifier(matchesId);
        matchHistoryService.modifySpecificMatch(matchHistoryId, matchesId, matches);
    }

    private String stringModifier(String input){
        return input.replace("_", " ").toLowerCase();
    }

}
