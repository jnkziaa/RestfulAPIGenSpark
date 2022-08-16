package com.genspark.Application.matchHistory;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
    public MatchHistory retrieveMatchHistory(@PathVariable String matchHistoryId){
        matchHistoryId =  matchHistoryId.replace("_", " ").toLowerCase();
        MatchHistory matchHistory = MatchHistoryService.retrieveMatchHistoryById(matchHistoryId);
        if(matchHistory==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return matchHistory;
    }

    @RequestMapping("/matchHistory/{matchHistoryId}/matches")
    public List<Matches> retrieveAllMatches(@PathVariable String matchHistoryId){
        matchHistoryId =  matchHistoryId.replace("_", " ").toLowerCase();
        List<Matches> matches = matchHistoryService.retrieveAllMatchesInHistory(matchHistoryId);
        if(matches == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return matches;

    }

    @RequestMapping("/matchHistory/{matchHistoryId}/matches/{matchesId}")
    public Matches retrieveSpecificMatch(@PathVariable String matchHistoryId, @PathVariable String matchesId){
        matchHistoryId =  matchHistoryId.replace("_", " ").toLowerCase();
        matchesId =  matchesId.replace("_", " ").toLowerCase();

        Matches matches = MatchHistoryService.retrieveSpecificMatches(matchHistoryId, matchesId);
        if(matches == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return matches;

    }


}
