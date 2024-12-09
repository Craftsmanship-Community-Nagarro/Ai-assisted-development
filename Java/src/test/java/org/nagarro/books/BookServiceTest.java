
package org.nagarro.books;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookServiceTest {

    private BookService bookService;
    private Book testBook;

    @BeforeEach
    void setUp() {
        bookService = new BookService();
        testBook = new Book("1234567890", "Test Book", "Test Author");
    }

    @Test
    void given_emptyBookList_when_listBooks_then_returnsEmptyList() {
        assertTrue(bookService.listBooks().isEmpty());
    }

    @Test
    void given_bookAdded_when_listBooks_then_returnsListWithOneBook() {
        bookService.addBook(testBook);
        assertEquals(1, bookService.listBooks().size());
        assertEquals(testBook, bookService.listBooks().get(0));
    }

    @Test
    void given_validBook_when_addBook_then_returnsAddedBook() {
        Book addedBook = bookService.addBook(testBook);
        assertEquals(testBook, addedBook);
        assertEquals(1, bookService.listBooks().size());
    }

    @Test
    void given_existingBook_when_getBookById_then_returnsCorrectBook() {
        bookService.addBook(testBook);
        Book foundBook = bookService.getBookById("1234567890");
        assertEquals(testBook, foundBook);
    }

    @Test
    void given_nonExistentIsbn_when_getBookById_then_returnsNull() {
        assertNull(bookService.getBookById("nonexistent"));
    }

    @Test
    void given_existingBook_when_updateBook_then_returnsUpdatedBook() {
        bookService.addBook(testBook);
        Book updatedBook = new Book("1234567890", "Updated Title", "Updated Author");

        Book result = bookService.updateBook("1234567890", updatedBook);

        assertNotNull(result);
        assertEquals("Updated Title", result.getTitle());
        assertEquals("Updated Author", result.getAuthor());
    }

    @Test
    void given_nonExistentBook_when_updateBook_then_returnsNull() {
        Book updatedBook = new Book("nonexistent", "Updated Title", "Updated Author");
        assertNull(bookService.updateBook("nonexistent", updatedBook));
    }
}