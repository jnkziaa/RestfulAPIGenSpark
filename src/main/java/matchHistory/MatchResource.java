package matchHistory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MatchResource {

    MatchHistoryService matchHistoryService;

    public MatchResource(MatchHistoryService matchHistoryService){
        this.matchHistoryService = matchHistoryService;
    }


    @RequestMapping("/matchHistory")
    public List<MatchHistory> retrieveAllMatches(){
        return matchHistoryService.retrieveAllMatches();
    }


}
