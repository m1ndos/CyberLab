package backend.entity;

public class User {
    public int id;
    public int team_id;
    public String lastname;
    public String firstname;
    public String patronymic;
    public String nickname;
    public String tg;
    public String vk;
    public String phone;
    public String password;
    public boolean is_admin;

    public User(int id, int team_id, String lastname, String firstname, String patronymic, String nickname, String tg, String vk, String phone, String password, boolean is_admin) {
        this.id = id;
        this.team_id = team_id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.patronymic = patronymic;
        this.nickname = nickname;
        this.tg = tg;
        this.vk = vk;
        this.phone = phone;
        this.password = password;
        this.is_admin = is_admin;
    }

    public User(int team_id, String lastname, String firstname, String patronymic, String nickname, String tg, String vk, String phone, String password, boolean is_admin) {
        this.team_id = team_id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.patronymic = patronymic;
        this.nickname = nickname;
        this.tg = tg;
        this.vk = vk;
        this.phone = phone;
        this.password = password;
        this.is_admin = is_admin;
    }

    public User(String lastname, String firstname, String patronymic, String nickname, String tg, String vk, String phone, String password, boolean is_admin) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.patronymic = patronymic;
        this.nickname = nickname;
        this.tg = tg;
        this.vk = vk;
        this.phone = phone;
        this.password = password;
        this.is_admin = is_admin;
    }
}
