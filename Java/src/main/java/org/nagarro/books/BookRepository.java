package org.nagarro.books;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {

    private final List<Book> books = new ArrayList<>();

    public List<Book> findAll() {
        return books;
    }

    public Optional<Book> findById(String id) {
        return books.stream().filter(b -> b.getId().equals(id)).findFirst();
    }

    public Book save(Book book) {
        books.add(book);
        return book;
    }

    public boolean deleteById(String id) {
        Optional<Book> book = findById(id);
        book.ifPresent(books::remove);
        return book.isPresent();
    }
}
