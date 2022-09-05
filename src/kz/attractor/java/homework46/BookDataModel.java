package kz.attractor.java.homework46;

import kz.attractor.java.BooksService;

import java.util.List;

public class BookDataModel {
    private List<Book> books;

    public BookDataModel() {
        books = BooksService.readFile();
    }
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
