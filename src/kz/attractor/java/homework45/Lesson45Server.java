package kz.attractor.java.homework45;

import com.sun.net.httpserver.HttpExchange;
import kz.attractor.java.server.ContentType;
import kz.attractor.java.server.ResponseCodes;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public class Lesson45Server extends Lesson44Server{

    public Lesson45Server(String host, int port) throws IOException {
        super(host, port);

        registerGet("/login", this::loginGet);
        registerPost("/login", this::loginPost);
    }

    private void loginPost(HttpExchange exchange) {
        String cType = getContentType(exchange);
        String raw = getBody(exchange);

        Map<String, String> parsed = Utils.parseUrlEncoded(raw, "&");

        String data = String.format("<p>Raw data: <b>%s</b></p>" +
                "<p>Content-Type: <b>%s</b></p>" +
                "<p>After being proceed: <b>%s</b><p>", raw, cType, parsed);

        try {
            sendByteData(exchange, ResponseCodes.OK, ContentType.TEXT_HTML, data.getBytes());
        } catch (IOException e){
            e.printStackTrace();
        }
//        redirect303(exchange, "/");
    }

    private void loginGet(HttpExchange exchange) {
        Path path = makeFilePath("login.html");
        sendFile(exchange, path, ContentType.TEXT_HTML);
    }
}
