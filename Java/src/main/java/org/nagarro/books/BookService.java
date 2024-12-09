package org.nagarro.books;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();

    // Get all books
    public List<Book> getAllBooks() {
        return books;
    }

    // Add a new book
    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    // Get a book by ID
    public Book getBookById(String id) {
        return books.stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null);
    }

    // Delete a book by ID
    public boolean deleteBook(String id) {
        Optional<Book> book = books.stream().filter(b -> b.getId().equals(id)).findFirst();
        book.ifPresent(books::remove);
        return book.isPresent();
    }
}
