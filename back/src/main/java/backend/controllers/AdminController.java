package backend.controllers;

import backend.entity.News;
import backend.entity.Tournaments;
import backend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin("*")
public class AdminController {
    @Autowired
    AdminService adminService;
    @PostMapping("/add-tournament")
    public ResponseEntity addTournament(@RequestBody Map<String, String> map){
        int number_of_teams = Integer.parseInt(map.get("number_of_teams"));
        int number_of_players_in_one_team = Integer.parseInt(map.get("number_of_players_in_one_team"));
        Tournaments tournament = new Tournaments(map.get("name"), map.get("logo"), map.get("start_date"), map.get("end_date"), number_of_teams, number_of_players_in_one_team);
        adminService.addTournament(tournament);
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/set-winner-team")
    public ResponseEntity setWinnerTeamOfTournament(@RequestBody Map<String,Integer> map){
        adminService.setWinnerTeamOfTournament(map.get("winner_team_id"), map.get("tournament_id"));
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/add-news")
    public ResponseEntity addNews(@RequestBody Map<String, String> map){
        News news = new News(map.get("title"), map.get("description"), map.get("image"));
        adminService.addNews(news);
        return ResponseEntity.ok("ok");
    }

    @PostMapping("delete-news")
    public ResponseEntity deleteNews(@RequestBody Map<String, Integer> map){
        adminService.deleteNews(map.get("id"));
        return ResponseEntity.ok("ok");
    }
}
