package backend.service;

import backend.entity.User;
import backend.exeptions.UserAlreadyExist;
import backend.exeptions.UserNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean isUserExist(String phone){
        String sql = "SELECT COUNT(*) FROM users WHERE phone = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, phone) != 0;
    }

    public void addUser(User user) throws UserAlreadyExist {
        if(isUserExist(user.phone)){
            throw new UserAlreadyExist("UserAlreadyExist");
        }
        String sql = "INSERT INTO users(team_id, firstname, lastname, patronymic, nickname, tg, vk, phone, password)" +
                "VALUES (null,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, user.firstname, user.lastname, user.patronymic,user.nickname, user.tg, user.vk, user.phone, user.password);
    }

    public User auth(String phone, String password) throws UserNotFound {
        String sql = "SELECT COUNT(*) FROM users WHERE phone = ? and password = ?";
        if(jdbcTemplate.queryForObject(sql, Integer.class, phone, password) == 1){
            return getUser(phone, password);
        } else throw new UserNotFound("UserNotFound");
    }

    public User getUser(String phone, String password){
        return jdbcTemplate.query("SELECT * FROM users WHERE phone = ? and password = ?",
                (rs, rowNum) -> new User(
                        rs.getInt("id"),
                        rs.getInt("team_id"),
                        rs.getString("lastname"),
                        rs.getString("firstname"),
                        rs.getString("patronymic"),
                        rs.getString("nickname"),
                        rs.getString("tg"),
                        rs.getString("vk"),
                        rs.getString("phone"),
                        rs.getString("password"),
                        rs.getBoolean("is_admin")
                ), phone, password
        ).get(0);
    }

    public User getUser(int id){
        return jdbcTemplate.query("SELECT * FROM users WHERE id = ?",
                (rs, rowNum) -> new User(
                        rs.getInt("id"),
                        rs.getInt("team_id"),
                        rs.getString("lastname"),
                        rs.getString("firstname"),
                        rs.getString("patronymic"),
                        rs.getString("nickname"),
                        rs.getString("tg"),
                        rs.getString("vk"),
                        rs.getString("phone"),
                        rs.getString("password"),
                        rs.getBoolean("is_admin")
                ), id
        ).get(0);
    }
}
