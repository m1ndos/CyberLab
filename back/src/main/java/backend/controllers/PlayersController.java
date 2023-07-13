package backend.controllers;

import backend.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class PlayersController {
    @Autowired
    PlayerService playerService;
    @GetMapping("get-all-players")
    public ResponseEntity getAllPlayers(){
        return ResponseEntity.ok(playerService.getAllPlayers());
    }
}
