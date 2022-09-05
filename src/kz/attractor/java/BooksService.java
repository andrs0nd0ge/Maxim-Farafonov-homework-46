package kz.attractor.java;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kz.attractor.java.homework45.Book;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BooksService {
    private static final Gson GSON = new GsonBuilder().create();
    private static final Path PATH = Paths.get("src/kz/attractor/java/books.json");

    public static List<Book> readFile(){
        String json = "";
        try{
            json = Files.readString(PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Book[] books = GSON.fromJson(json, Book[].class);
        return List.of(books);
    }
}
