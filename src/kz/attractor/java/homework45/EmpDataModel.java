package kz.attractor.java.homework45;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class EmpDataModel {
    private Employee employee = new Employee("Brad", "Barnard");
    private List<Employee> employees = new ArrayList<>();
    public EmpDataModel() {
        employees.add(new Employee(1, "Brad", "Barnard"));
        employees.add(new Employee(2, "Jeffery", "Carney"));
        employees.add(new Employee(3, "Philip", "Salter"));
        String empJson = new Gson().toJson(employees);
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
