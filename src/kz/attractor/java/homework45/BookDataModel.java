package kz.attractor.java.homework45;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class BookDataModel {
    private Book book = new Book("The Fault in Our Stars", "John Green");
    private List<Book> books = new ArrayList<>();

    public BookDataModel() {
        books.add(new Book(1, "The Fault in Our Stars", "John Green", "In office"));
        books.add(new Book(2, "What If? Serious Scientific Answers to Absurd Hypothetical Questions", "Randall Munroe", "In office"));
        books.add(new Book(3, "Life of Pi", "Yann Martel", "In office"));
        books.add(new Book(4, "1984", "George Orwell", "In office"));
        books.add(new Book(5, "The Alchemist", "Paulo Coelho", "In office"));
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
