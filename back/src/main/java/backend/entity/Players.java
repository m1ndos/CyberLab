package backend.entity;

public class Players {
    public int id;
    public int team_id;
    public String nickname;
    public String avatar;
    public String firstname;
    public String lastname;
    public String patronymic;
    public String phone;

    public Players(int id, int team_id, String nickname, String avatar, String firstname, String lastname, String patronymic, String phone) {
        this.id = id;
        this.team_id = team_id;
        this.nickname = nickname;
        this.avatar = avatar;
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.phone = phone;
    }
}
