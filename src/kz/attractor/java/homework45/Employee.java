package kz.attractor.java.homework45;

public class Employee {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public Employee(int id, String firstName, String lastName, String email, String password){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Employee(String firstName, String lastName) {
        this(0, firstName, lastName, null, null);
    }

    public Employee(int id, String firstName, String lastName) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
