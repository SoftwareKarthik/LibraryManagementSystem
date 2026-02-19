package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.model.Book;
import com.library.repository.BookRepo;

@Service
public class LibraryService {

    @Autowired
    private BookRepo bookRepo;

    // ADD a new book
    public Object addBook(Book book) {
        return bookRepo.save(book);
    }

    // GET a book by ID
    public Object getBookById(int id) {
        return bookRepo.findById(id).orElse(null);
    }

    // GET all books
    public Object getAllBooks() {
        return bookRepo.findAll();
    }

    // DELETE a book by ID
    public Object deleteBook(int id) {
        bookRepo.deleteById(id);
        return "Book Deleted Successfully!!!";
    }

    // UPDATE book details
    public Object updateBook(int id, Book updatedBook) {
        Book existingBook = bookRepo.findById(id).orElse(null);
        if (existingBook != null) {
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setGenre(updatedBook.getGenre());
            existingBook.setPrice(updatedBook.getPrice());
            existingBook.setAvailable(updatedBook.isAvailable());
            return bookRepo.save(existingBook);
        } else {
            return "Book Does Not Exist!!!";
        }
    }

    // ISSUE a book (mark as not available)
    public Object issueBook(int id) {
        Book book = bookRepo.findById(id).orElse(null);
        if (book != null) {
            if (book.isAvailable()) {
                book.setAvailable(false);
                bookRepo.save(book);
                return "Book Issued Successfully!!!";
            } else {
                return "Book is Already Issued!!!";
            }
        } else {
            return "Book Does Not Exist!!!";
        }
    }

    // RETURN a book (mark as available)
    public Object returnBook(int id) {
        Book book = bookRepo.findById(id).orElse(null);
        if (book != null) {
            if (!book.isAvailable()) {
                book.setAvailable(true);
                bookRepo.save(book);
                return "Book Returned Successfully!!!";
            } else {
                return "Book Was Not Issued!!!";
            }
        } else {
            return "Book Does Not Exist!!!";
        }
    }
}