package backend.service;

import backend.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<News> getFirstSixNews(){
        String sql = "SELECT * FROM news LIMIT 6";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new News(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("date"),
                rs.getString("description"),
                rs.getString("image")
        ));
    }

    public List<News> getAllNews(){
        String sql = "SELECT * FROM news";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new News(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("date"),
                rs.getString("description"),
                rs.getString("image")
        ));
    }

    public News getNewsById(int id){
        String sql = "SELECT * FROM news WHERE id = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new News(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("date"),
                rs.getString("description"),
                rs.getString("image")
        ), id).get(0);
    }
}
