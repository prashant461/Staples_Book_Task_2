package com.prashant.bookmanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Book_Id")
	private int bookId;
	
	@NotBlank(message = "Title cannot be blank")
	@Column(name="Title")
	private String title;
	
	@Column(name="Description")
	private String description;
	
	@NotBlank(message = "Author name cannot be blank")
	@Column(name="Author")
	private String author;
	
	@Min(value = 10,message = "Page count must be a non-negative value and greater than 10")
	@Column(name="Page_count")
    private int pageCount; 
    
}
