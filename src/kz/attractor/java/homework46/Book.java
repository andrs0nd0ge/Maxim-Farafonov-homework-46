package kz.attractor.java.homework46;

import kz.attractor.java.EmployeeService;

import java.util.List;

public class Book {
    private Integer id;
    private String name;
    private String author;
    private Integer user_id;
    private boolean isBusy;
    private transient Employee user;

    public Book(int id, String name, String author) {
    }

    public Book(String name, String author){
        this.name = name;
        this.author = author;

        setMyUser();
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

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public boolean getIsBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        this.isBusy = busy;
    }

    public Employee getUser() {
        return user;
    }

    public void setUser(Employee user) {
        this.user = user;
    }

    private void setMyUser() {
        if (isBusy) {
            List<Employee> users = EmployeeService.readFile();
            for (Employee user : users) {
                if (user.getId().equals(this.user_id)) {
                    this.user = user;
                }
            }
        }
    }
}
