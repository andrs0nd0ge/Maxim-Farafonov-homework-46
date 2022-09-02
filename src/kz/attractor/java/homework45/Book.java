package kz.attractor.java.homework45;

public class Book {
    private Integer id;
    private String name;
    private String author;
    private String state;
    public Book(int id, String name, String author, String state){
        this.id = id;
        this.name = name;
        this.author = author;
        this.state = state;
    }

    public Book(String name, String author) {
        this(0, name, author, null);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
