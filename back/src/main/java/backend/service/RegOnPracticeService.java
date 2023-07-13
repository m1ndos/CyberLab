package backend.service;

import backend.entity.RegOnPractice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegOnPracticeService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<RegOnPractice> getAllRegOnPractice(){
        String sql = "SELECT * FROM reg_on_practice";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new RegOnPractice(
                rs.getInt("id"),
                rs.getString("date"),
                rs.getString("time_start"),
                rs.getInt("number_of_computers"),
                rs.getString("time_end")
        ));
    }

    public void regComputerOnPractice(int id){
        String sql = "UPDATE reg_on_practice SET number_of_computers = number_of_computers - 1 WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }
}
