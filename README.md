# Spring Boot Book Management 📚

## Overview
Welcome to the Spring Boot Book Management project! This application exposes a RESTful API for managing books, incorporating basic security using Spring Security and persisting book data in a MySQL database.

## Project Structure

### Controller
- **BookController:** Manages API endpoints related to book operations.

### Model
- **Book:** Entity class representing a book with attributes (bookId, title, description, author, pageCount).

### Service
- **BookService:** Service layer containing business logic for book operations.

### Repository
- **BookRepository:** JPA repository for interacting with the database.

### Security
- **WebConfig:** Spring Security configuration class with in-memory user details and basic authentication.

### Test
- **BookControllerTest:** JUnit and Mockito-based tests for the BookController.

## Features
### Functionalities Supported
- **Create a new book (POST):** `/api/book/add-book`
- **Get a book by its ID (GET):** `/api/book/{bookId}`
- **Update a book (PUT):** `/api/book/update/{bookId}`
- **Delete a book (DELETE):** `/api/book/delete/{bookId}`
- **Get a list of all books (GET):** `/api/book/all-books`

### HTTP Status Codes and Error Messages
- The API responds with appropriate HTTP status codes and error messages for different scenarios.

### Security
- Basic security is implemented using Spring Security with in-memory authentication.

### Database
- Book data is persisted in a MySQL database using Spring Data JPA.

### Unit Tests
- Unit tests for API endpoints are implemented using JUnit and Mockito.

## Getting Started
### Prerequisites
- Clone the project or download the ZIP file.
- Open the project in your preferred IDE (e.g., IntelliJ, Eclipse).

### Configuration
- Configure your MySQL database connection in `application.properties`.

### Run the Application
- Build and run the application.

## API Documentation
### Create a new book (POST)
- **Endpoint:** `/api/book/add-book`
- **Request Body:** Book details (JSON)
- **Payload:
  ```
  {
      "title": "A Dystopian Journey",
      "description": "A dystopian novel by George Orwell goeghhghg",
      "author": "George Orwell",
      "pageCount": 328,
      "genre": "Dystopian Fiction"
  }
  ```
- **Response:** Book details with HTTP status.

### Get a book by its ID (GET)
- **Endpoint:** `/api/book/{bookId}`
- **Path Variable:** `bookId`
- **Response:** Book details with HTTP status.

### Update a book (PUT)
- **Endpoint:** `/api/book/update/{bookId}`
- **Path Variable:** `bookId`
- **Request Body:** Updated book details (JSON)
- **Payload:
  ```
  {
      "title": "A Dystopian Journey updated",
      "description": "A dystopian novel by George Orwell goeghhghg",
      "author": "George Orwell",
      "pageCount": 328,
      "genre": "Dystopian Fiction"
  }
  ```
- **Response:** Updated book details with HTTP status.

### Delete a book (DELETE)
- **Endpoint:** `/api/book/delete/{bookId}`
- **Path Variable:** `bookId`
- **Response:** Success message with HTTP status.

### Get a list of all books (GET)
- **Endpoint:** `/api/book/all-books`
- **Response:** List of books with HTTP status.

## Contributing
Feel free to contribute, suggest improvements, or report issues! 🚀

## Happy Reading! 📖
