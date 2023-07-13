package backend.controllers;

import backend.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class TeamController {
    @Autowired
    TeamService teamService;
    @GetMapping("get-all-teams")
    public ResponseEntity getAllTeams(){
        return ResponseEntity.ok(teamService.getAllTeams());
    }
}
