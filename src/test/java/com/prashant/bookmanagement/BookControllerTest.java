package com.prashant.bookmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.prashant.bookmanagement.model.Book;
import com.prashant.bookmanagement.repository.BookRepository;
import com.prashant.bookmanagement.service.BookService;


@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void testSaveProduct() {
        // Arrange
    	Book book = new Book();
    	book.setTitle("Sample Title");
    	book.setDescription("Sample Description");
    	book.setAuthor("Sample Author");
    	book.setPageCount(100);
        

        when(bookRepository.save(book)).thenReturn(book);

        // Act
        ResponseEntity<Book> response = bookService.addBook(book);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(book, response.getBody());

    }
    
    @Test
    public void testGetProductById() {
        // Arrange
        int bookId = 1;
        Book book = new Book();
        book.setTitle("Sample Title");
        book.setDescription("Sample Description");
        book.setAuthor("Sample Author");
        book.setPageCount(100);

        when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));

        // Act
        ResponseEntity<Book> response = bookService.findBook(bookId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(book, response.getBody());
    }

    @Test
    public void testUpdateProduct() {
        // Arrange
    	int bookId = 1;
    	
        Book existingBook = new Book();
        existingBook.setTitle("Sample Title");
        existingBook.setDescription("Sample Description");
        existingBook.setAuthor("Sample Author");
        existingBook.setPageCount(100);
        

        Book updatedBook = new Book();
        updatedBook.setTitle("Sample Title");
        updatedBook.setDescription("Sample Description");
        updatedBook.setAuthor("Sample Author");
        updatedBook.setPageCount(100);
        
       
        when(bookRepository.findById(bookId)).thenReturn(Optional.of(existingBook));
        when(bookRepository.save(existingBook)).thenReturn(updatedBook);

        // Act
        ResponseEntity<Book> response = bookService.updateBook(bookId, updatedBook);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedBook, response.getBody());
    }
    
    @Test
    public void testDeleteBook() {
    	int bookId = 1;
        Book book = new Book();
        book.setTitle("Sample Title");
        book.setDescription("Sample Description");
        book.setAuthor("Sample Author");
        book.setPageCount(100);

        // Mock the book repository to return a non-empty Optional when findById is called
        when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));

        // Act
        ResponseEntity<String> deletedResponse = bookService.deleteBook(bookId);

        // Assert
        assertEquals("Deleted succesfully", deletedResponse.getBody());
        assertEquals(HttpStatus.OK, deletedResponse.getStatusCode());
    }
    
}
