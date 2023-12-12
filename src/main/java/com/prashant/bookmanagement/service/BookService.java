package com.prashant.bookmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prashant.bookmanagement.model.Book;
import com.prashant.bookmanagement.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;

	public ResponseEntity<Book> addBook(Book book) {
		try {
            Book savedBook = bookRepository.save(book);
            return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	

	public ResponseEntity<List<Book>> findAllBooks(int pageNumber, int pageSize) {
		// pagination
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		
		Page<Book> booksOfPage = bookRepository.findAll(pageable);
		List<Book> books = booksOfPage.getContent();
		
		return new ResponseEntity<>(books, HttpStatus.OK) ;
	}
	

	public ResponseEntity<Book> findBook(int bookId) {
		Optional<Book> book = bookRepository.findById(bookId);
		if(book.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(book.get(), HttpStatus.OK);
	}
	

	public ResponseEntity<Book> updateBook(int bookId, Book book) {
		Optional<Book> existingOptional = bookRepository.findById(bookId);
		
		if(existingOptional.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		Book existingBook = existingOptional.get();
		existingBook.setTitle(book.getTitle());
		existingBook.setDescription(book.getDescription());
		existingBook.setAuthor(book.getAuthor());
		existingBook.setPageCount(book.getPageCount());
		
		Book updatedBook = bookRepository.save(existingBook);
		
		return new ResponseEntity<>(updatedBook, HttpStatus.OK);
	}

	public ResponseEntity<String> deleteBook(int bookId) {
		Optional<Book> book = bookRepository.findById(bookId);
		
		if(book.isEmpty()) {
			return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
		}
		
		bookRepository.deleteById(bookId);
		
		return new ResponseEntity<>("Deleted succesfully", HttpStatus.OK);
	}


}
