package kz.attractor.java;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kz.attractor.java.homework45.Book;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BookService {
    private static final Gson GSON = new GsonBuilder().create();
    private static final Path PATH = Paths.get("./books.json");

    public static Book[] readFile(){
        String json = "";
        try {
            json = Files.readString(PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return GSON.fromJson(json, Book[].class);
    }

//    public static void writeFile(Track[] tracks){
//        String json = GSON.toJson(tracks);
//        try {
//            byte[] arr = json.getBytes();
//            Files.write(PATH, arr);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
