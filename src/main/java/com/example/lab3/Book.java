package com.example.lab3;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Book {

    private List<BookController> books = new ArrayList<>();

    @PostMapping("/book")
    public BookController addBook(@RequestBody BookController book) {
        book.setStatus("received");
        books.add(book);
        return book;
    }

    @GetMapping("/all")
    public List<BookController> getAllBooks() {
        return books;
    }
}