package backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerDTO {
    public String team_name;
    public String player_firstname;
    public String player_lastname;
    public String player_patronymic;
    public String player_nickname;
    public String player_phone;

    public PlayerDTO(@JsonProperty("team_name") String team_name,
                     @JsonProperty("player_firstname") String player_firstname,
                     @JsonProperty("player_lastname") String player_lastname,
                     @JsonProperty("player_patronymic") String player_patronymic,
                     @JsonProperty("player_nickname") String player_nickname,
                     @JsonProperty("player_phone") String player_phone) {
        this.team_name = team_name;
        this.player_firstname = player_firstname;
        this.player_lastname = player_lastname;
        this.player_patronymic = player_patronymic;
        this.player_nickname = player_nickname;
        this.player_phone = player_phone;
    }

    @Override
    public String toString() {
        return "PlayerDTO{" +
                "player_firstname='" + player_firstname + '\'' +
                ", player_lastname='" + player_lastname + '\'' +
                ", player_patronymic='" + player_patronymic + '\'' +
                ", player_nickname='" + player_nickname + '\'' +
                ", player_phone='" + player_phone + '\'' +
                '}';
    }
}
