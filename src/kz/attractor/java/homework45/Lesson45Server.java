package kz.attractor.java.homework45;

import com.sun.net.httpserver.HttpExchange;
import kz.attractor.java.EmployeeService;
import kz.attractor.java.server.ContentType;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lesson45Server extends Lesson44Server {
    private Employee user = null;

    public Lesson45Server(String host, int port) throws IOException {
        super(host, port);

        registerGet("/login", this::loginGet);
        registerPost("/login", this::loginPost);
        registerGet("/register", this::regGet);
        registerPost("/register", this::regPost);
        registerGet("/profile", this::profileGet);
    }

    private void loginPost(HttpExchange exchange) {
        Map<String, Object> map = new HashMap<>();
        getContentType(exchange);
        String raw = getBody(exchange);
        Map<String, String> parsed = Utils.parseUrlEncoded(raw, "&");
        try {
            if (parsed.size() == 2) {
                List<Employee> users = EmployeeService.readFile();
                for (Employee employee : users) {
                    if (employee.getEmail().equals(parsed.get("email")) && employee.getPassword().equals(parsed.get("user-password"))) {
                        user = employee;
                        throw new RuntimeException();
                    }
                }
            }
            map.put("fail", true);
            renderTemplate(exchange, "index.html", map);
        } catch (Exception e) {
            redirect303(exchange, "/profile");
        }
    }

    private void loginGet(HttpExchange exchange) {
        Path path = makeFilePath("login.html");
        sendFile(exchange, path, ContentType.TEXT_HTML);
    }

    private void regPost(HttpExchange exchange) {
        Map<String, Object> map = new HashMap<>();
        getContentType(exchange);
        String raw = getBody(exchange);
        Map<String, String> parsed = Utils.parseUrlEncoded(raw, "&");
        try {
            if (parsed.size() == Employee.class.getDeclaredFields().length - 5) {
                List<Employee> users = new ArrayList<>(EmployeeService.readFile());
                Employee emp = Employee.createUser(users.size() + 1, parsed);
                for (Employee employee : users) {
                    if (Employee.compareUser(emp, employee)) {
                        throw new RuntimeException("User already exists!");
                    }
                }
                users.add(emp);
                EmployeeService.writeFile(users);
                redirect303(exchange, "/login");
            } else {
                map.put("fail_text", "Fill all the fields!");
                renderTemplate(exchange, "register.html", map);
            }
        } catch (Exception e) {
            e.printStackTrace();

            map.put("fail_text", "An error has occurred!");
            renderTemplate(exchange, "register.html", map);
        }
    }

    private void regGet(HttpExchange exchange) {
        Path path = makeFilePath("register.html");
        sendFile(exchange, path, ContentType.TEXT_HTML);
    }

    private void profileGet(HttpExchange exchange) {
        if(user != null) {
            user.setBooks();
        }
        renderTemplate(exchange, "profile.html", user);
    }
}
