package backend.service;

import backend.entity.Players;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Players> getAllPlayers(){
        String sql = "SELECT * FROM players";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Players(
                rs.getInt("id"),
                rs.getInt("team_id"),
                rs.getString("nickname"),
                rs.getString("avatar"),
                rs.getString("firstname"),
                rs.getString("lastname"),
                rs.getString("patronymic"),
                rs.getString("phone")
        ));
    }
}
