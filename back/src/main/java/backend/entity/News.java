package backend.entity;

public class News {
    public int id;
    public String title;
    public String date;
    public String description;
    public String image;

    public News(int id, String title, String date, String description, String image) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.description = description;
        this.image = image;
    }

    public News(String title, String description, String image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }
}
