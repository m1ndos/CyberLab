package backend.controllers;

import backend.entity.PlayerDTO;
import backend.entity.Players;
import backend.service.TeamAndPlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class TeamAndPlayersController {
    @Autowired
    TeamAndPlayersService teamAndPlayersService;
    @PostMapping("/add-team")
    public ResponseEntity addTeam(@RequestBody Map<String, String> map){
        teamAndPlayersService.addTeam(map.get("name"));
        return ResponseEntity.ok("ok");
    }
    @PostMapping("/add-team-in-tournament")
    public ResponseEntity addTeamOnTournament(@RequestBody Map<String, String> map){
        int tournament_id = Integer.parseInt(map.get("tournament_id"));
        teamAndPlayersService.addTeamOnTournament(map.get("name"), tournament_id);
        return ResponseEntity.ok("ok");
    }

    @PostMapping("add-players")
    public ResponseEntity addPlayers(@RequestBody Map<String, List<PlayerDTO>> map){
        teamAndPlayersService.addPlayers(map.get("players"));
        return ResponseEntity.ok("ok");
    }
}
