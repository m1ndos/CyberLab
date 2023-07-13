package backend.entity;

public class RegOnPractice {
    public int id;
    public String date;
    public String time_start;
    public int number_of_computers;
    public String time_end;

    public RegOnPractice(int id, String date, String time_start, int number_of_computers, String time_end) {
        this.id = id;
        this.date = date;
        this.time_start = time_start;
        this.number_of_computers = number_of_computers;
        this.time_end = time_end;
    }

    public RegOnPractice(String date, String time_start, int number_of_computers, String time_end) {
        this.date = date;
        this.time_start = time_start;
        this.number_of_computers = number_of_computers;
        this.time_end = time_end;
    }
}
