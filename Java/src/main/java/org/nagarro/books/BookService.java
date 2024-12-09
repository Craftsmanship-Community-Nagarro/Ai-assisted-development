package org.nagarro.books;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();

}
