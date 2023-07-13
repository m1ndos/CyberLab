package backend.entity;

public class Tournaments {
    public int id;
    public String name;
    public String logo;
    public String start_date;
    public String end_date;
    public int number_of_teams;
    public int number_of_players_in_one_team;
    public int winner_team_id;

    @Override
    public String toString() {
        return "Tournaments{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", number_of_teams=" + number_of_teams +
                ", number_of_players_in_one_team=" + number_of_players_in_one_team +
                ", winner_team_id=" + winner_team_id +
                '}';
    }

    public Tournaments(int id, String name, String logo, String start_date, String end_date, int number_of_teams, int number_of_players_in_one_team, int winner_team_id) {
        this.id = id;
        this.name = name;
        this.logo = logo;
        this.start_date = start_date;
        this.end_date = end_date;
        this.number_of_teams = number_of_teams;
        this.number_of_players_in_one_team = number_of_players_in_one_team;
        this.winner_team_id = winner_team_id;
    }

    public Tournaments(String name, String logo, String start_date, String end_date, int number_of_teams, int number_of_players_in_one_team) {
        this.name = name;
        this.logo = logo;
        this.start_date = start_date;
        this.end_date = end_date;
        this.number_of_teams = number_of_teams;
        this.number_of_players_in_one_team = number_of_players_in_one_team;
    }
}
