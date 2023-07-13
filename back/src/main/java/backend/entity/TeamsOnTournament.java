package backend.entity;

public class TeamsOnTournament {
    public int id;
    public int team_id;
    public int tournament_id;

    public TeamsOnTournament(int id, int team_id, int tournament_id) {
        this.id = id;
        this.team_id = team_id;
        this.tournament_id = tournament_id;
    }
}
