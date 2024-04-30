package com.dmqlproject.Backend.Controller;

import com.dmqlproject.Backend.Model.PlayerStatistics;
import com.dmqlproject.Backend.Service.PlayerStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class DataController {

    @Autowired
    private PlayerStatisticsService service;

    @GetMapping({"/home"})
    @ResponseBody
    public String demo(){
        System.out.println("Inside the Demo Controller");
        return "Inside the Demo Controller";
    }

    @GetMapping({"/PlayerStatistics"})
    @ResponseBody
    public List<PlayerStatistics> getAllStats(){
        return service.findall();
    }

    @GetMapping({"/PlayerStatistics/PlayerName/{PlayerName}"})
    @ResponseBody
    public PlayerStatistics searchByName(@PathVariable("PlayerName") String keyword){
        return service.search(keyword);
    }

    @GetMapping({"/PlayerNames/{SearchTerm}"})
    @ResponseBody
    public List<PlayerStatistics> allPlayers(@PathVariable("SearchTerm") String keyword){
        return service.searchByName(keyword);
    }

    @GetMapping({"/PlayerStatistics/PlayerID/{playerId}"})
    @ResponseBody
    public PlayerStatistics searchByID(@PathVariable("playerId") Integer keyword){
        return service.searchByID(keyword);
    }

//    @GetMapping("/PlayerStat/SearchPlayer/{searchTerm}")
//    @ResponseBody
//    public List<Map<String, String>> searchByTerm(@PathVariable("searchTerm") String searchTerm) {
//        List<PlayerStatistics> players = service.searchByTerm(searchTerm);
//
//        // Convert PlayerStatistics objects to Map<String, String> objects
//        List<Map<String, String>> playerList = players.stream()
//                .map(player -> {
//                    Map<String, String> playerMap = new HashMap<>();
//                    playerMap.put("value", String.valueOf(player.getPlayerId()));
//                    playerMap.put("label", player.getPlayerName());
//                    return playerMap;
//                })
//                .collect(Collectors.toList());
//
//        return playerList;
//    }
}

