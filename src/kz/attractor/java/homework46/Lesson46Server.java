package kz.attractor.java.homework46;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Lesson46Server extends Lesson45Server {
    String uniqueId = String.valueOf(new Random().nextInt(100000) + 1);
    public Lesson46Server(String host, int port) throws IOException {
        super(host, port);
        registerGet("/cookie", this::cookieHandler);
    }

    protected void cookieHandler(HttpExchange exchange) {
        Cookie sessionCookie = Cookie.make("User-ID", uniqueId);
        Map<String, Object> data = new HashMap<>();
        sessionCookie.setMaxAge(600);
        sessionCookie.setHttpOnly(true);

        setCookie(exchange, sessionCookie);
        getCookies(exchange);
        renderTemplate(exchange, "cookie.html", data);
    }

    protected static String getCookies(HttpExchange exchange) {
        return exchange.getRequestHeaders()
                .getOrDefault("Cookie", List.of(""))
                .get(0);
    }

    protected void setCookie(HttpExchange exchange, Cookie cookie) {
        exchange.getResponseHeaders().add("Set-Cookie", cookie.toString());
    }

    @Override
    protected void createCookie(HttpExchange exchange, Employee employee) {
        Cookie sessionCookie = Cookie.make("User-ID", uniqueId);
        Map<String, Object> data = new HashMap<>();
        sessionCookie.setMaxAge(600);
        sessionCookie.setHttpOnly(true);

        setCookie(exchange, sessionCookie);

        String cookieString = getCookies(exchange);
        Map<String, String> cookies = Cookie.parse(cookieString);
        data.put("cookies", cookies);
    }

    @Override
    protected void profileGet(HttpExchange exchange) {
        Cookie sessionCookie = Cookie.make("User-ID", uniqueId);
        sessionCookie.setMaxAge(600);
        sessionCookie.setHttpOnly(true);

        setCookie(exchange, sessionCookie);

        getCookies(exchange);

        if(user != null) {
            user.setBooks();
        }
        renderTemplate(exchange, "profile.html", user);
    }
}
