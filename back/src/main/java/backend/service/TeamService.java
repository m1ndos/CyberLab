package backend.service;

import backend.entity.Teams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Teams> getAllTeams(){
        String sql = "SELECT * FROM teams";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Teams(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("logo")
        ));
    }
}
