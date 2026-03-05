package com.klu.controller;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import com.klu.model.Book;

@RestController
public class LibraryController {

    List<Book> bookList = new ArrayList<>();

    // 1. Welcome Message
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Online Library System!";
    }

    // 2. Total Book Count
    @GetMapping("/count")
    public int getBookCount() {
        return 100;
    }

    // 3. Book Price
    @GetMapping("/price")
    public double getBookPrice() {
        return 499.99;
    }

    // 4. List of Book Titles
    @GetMapping("/books")
    public List<String> getBooks() {

        List<String> books = new ArrayList<>();
        books.add("Java Programming");
        books.add("Spring Boot Guide");
        books.add("Data Structures");

        return books;
    }

    // 5. Book Details using PathVariable
    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable int id) {
        return "Details of Book with ID: " + id;
    }

    // 6. Search Book using Request Parameter
    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "Searching for book titled: " + title;
    }

    // 7. Author Name using PathVariable
    @GetMapping("/author/{name}")
    public String getAuthor(@PathVariable String name) {
        return "Books written by Author: " + name;
    }

    // 8. Add Book using POST
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book Added Successfully!";
    }

    // 9. View All Books
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }
}