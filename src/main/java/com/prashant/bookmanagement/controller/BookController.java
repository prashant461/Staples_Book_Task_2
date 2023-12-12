package com.prashant.bookmanagement.controller;

import java.util.List;

import org.aspectj.apache.bcel.classfile.Module.Require;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.prashant.bookmanagement.model.Book;
import com.prashant.bookmanagement.service.BookService;



@RestController
@RequestMapping("/api/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	// adding new book in database
	@PostMapping("/add-book")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}
	
	// getting all books from database
	// take params for pagination as page size and page number
	
	@GetMapping("/all-books")
	public ResponseEntity<List<Book>> findAllBooks(
	        @RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize,
	        @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber
	) {
	    return bookService.findAllBooks(pageNumber, pageSize);
	}

	
	//getting book with specific bookId
	@GetMapping("/{bookId}")
	public ResponseEntity<Book> findBook(@PathVariable int bookId) {
		return bookService.findBook(bookId);
	}
	
	//updating record in database for specific bookId
	@PutMapping("update/{bookId}")
	public ResponseEntity<Book> updateBook(@PathVariable int bookId, @RequestBody Book book) {
		return bookService.updateBook(bookId, book);
		
	}
	
	// delete by specific id
	@DeleteMapping("delete/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable int bookId) {
		return bookService.deleteBook(bookId);
	}
}
