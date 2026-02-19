package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.library.model.Book;
import com.library.service.LibraryService;

@RestController
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    // ADD a new book
    @PostMapping("/addbook")
    Object addBook(@RequestBody Book book) {
        return libraryService.addBook(book);
    }

    // GET a book by ID
    @GetMapping("/getbook/{id}")
    Object getBook(@PathVariable("id") int id) {
        return libraryService.getBookById(id);
    }

    // GET all books
    @GetMapping("/getallbooks")
    Object getAllBooks() {
        return libraryService.getAllBooks();
    }

    // DELETE a book by ID
    @DeleteMapping("/deletebook/{id}")
    Object deleteBook(@PathVariable("id") int id) {
        return libraryService.deleteBook(id);
    }

    // UPDATE book details
    @PutMapping("/updatebook/{id}")
    Object updateBook(@PathVariable("id") int id, @RequestBody Book updatedBook) {
        return libraryService.updateBook(id, updatedBook);
    }

    // ISSUE a book
    @PutMapping("/issuebook/{id}")
    Object issueBook(@PathVariable("id") int id) {
        return libraryService.issueBook(id);
    }

    // RETURN a book
    @PutMapping("/returnbook/{id}")
    Object returnBook(@PathVariable("id") int id) {
        return libraryService.returnBook(id);
    }
}