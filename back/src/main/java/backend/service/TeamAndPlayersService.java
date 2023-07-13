package backend.service;

import backend.entity.PlayerDTO;
import backend.entity.Players;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamAndPlayersService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addTeam(String name){
        String sql = "INSERT INTO teams (name, logo) VALUES (?, null)";
        jdbcTemplate.update(sql, name);
    }
    public void addTeamOnTournament(String name, int tournament_id){
        String sql = "SELECT id FROM teams WHERE name = ? ORDER BY id DESC LIMIT 1";
        int team_id = jdbcTemplate.queryForObject(sql, Integer.class, name);
        sql = "INSERT INTO team_in_tournament (team_id, tournament_id) VALUES (?,?)";
        jdbcTemplate.update(sql, team_id, tournament_id);
    }
    public void addPlayers(List<PlayerDTO> playersList){
        String sql = "SELECT id FROM teams WHERE name = ? ORDER BY id DESC LIMIT 1";
        int team_id = jdbcTemplate.queryForObject(sql, Integer.class, playersList.get(0).team_name);
        sql = "INSERT INTO players (team_id, nickname, avatar, firstname, lastname, patronymic, phone)" +
                "VALUES (?,?,null,?,?,?,?)";
        for(PlayerDTO player: playersList){
            jdbcTemplate.update(sql,
                    team_id,
                    player.player_nickname,
                    player.player_firstname,
                    player.player_lastname,
                    player.player_patronymic,
                    player.player_phone);
        }
    }
}
