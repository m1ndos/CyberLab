package backend.controllers;

import backend.service.TournamentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin("*")
public class TournamentsController {
    @Autowired
    TournamentsService tournamentsService;
    @GetMapping("/get-all-tournaments")
    public ResponseEntity getAllTournaments(){
        return ResponseEntity.ok(tournamentsService.getAllTournaments());
    }

    @PostMapping("/get-number-of-players")
    public ResponseEntity getNumberOfPlayersInOneTeamById(@RequestBody Map<String, Integer> map){
        return ResponseEntity.ok(tournamentsService.getNumberOfPlayersInOneTeamById(map.get("id")));
    }
}
