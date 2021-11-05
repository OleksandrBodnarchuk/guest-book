package pl.alex.ksiegagosci;

public class Comment {
    private int id;
    private final String author;
    private final String comment;

    public Comment(String author, String comment) {
        this.author = author;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getComment() {
        return comment;
    }

    public void setId(int id) {
        this.id = id;
    }
}
