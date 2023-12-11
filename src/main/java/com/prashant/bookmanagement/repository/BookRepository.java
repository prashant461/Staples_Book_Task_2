package com.prashant.bookmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prashant.bookmanagement.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
