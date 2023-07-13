package backend.service;

import backend.entity.Tournaments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentsService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Tournaments> getAllTournaments(){
        String sql = "SELECT * FROM tournaments";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Tournaments(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("logo"),
                rs.getString("start_date"),
                rs.getString("end_date"),
                rs.getInt("number_of_teams"),
                rs.getInt("number_of_players_in_one_team"),
                rs.getInt("winner_team_id")
        ));
    }

    public int getNumberOfPlayersInOneTeamById(int id){
        String sql = "SELECT number_of_players_in_one_team from tournaments where id = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, id);
    }
}
