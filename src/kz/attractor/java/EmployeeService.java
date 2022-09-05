package kz.attractor.java;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kz.attractor.java.homework45.Employee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class EmployeeService {
    private static final Gson GSON = new GsonBuilder().create();
    private static final Path PATH = Paths.get("src/kz/attractor/java/employees.json");

    public static List<Employee> readFile(){
        String json = "";
        try {
            json = Files.readString(PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Employee[] employees = GSON.fromJson(json, Employee[].class);
        return List.of(employees);
    }

    public static void writeFile(List<Employee> emps){
        String json = GSON.toJson(emps);
        try {
            byte[] arr = json.getBytes();
            Files.write(PATH, arr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
