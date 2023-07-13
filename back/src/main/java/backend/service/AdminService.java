package backend.service;

import backend.entity.News;
import backend.entity.Tournaments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addTournament(Tournaments tournament){
        System.out.println(tournament);
        String sql = "INSERT INTO tournaments (name, logo, start_date, end_date, number_of_teams, number_of_players_in_one_team, winner_team_id) " +
                "VALUES (?,?,'"+tournament.start_date+"','"+ tournament.end_date +"',?,?, null)";
        jdbcTemplate.update(sql, tournament.name, tournament.logo, tournament.number_of_teams, tournament.number_of_players_in_one_team);
    }
    public void setWinnerTeamOfTournament(int winner_team_id, int tournament_id){
        String sql = "UPDATE tournaments SET winner_team_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, winner_team_id, tournament_id);
    }

    public void addNews(News news){
        String sql = "INSERT INTO news (title, date, description, image) VALUES (?,now(),?,?)";
        jdbcTemplate.update(sql, news.title, news.description, news.image);
    }

    public void deleteNews(int id){
        String sql = "DELETE FROM news WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
