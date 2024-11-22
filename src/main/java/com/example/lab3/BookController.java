package com.example.lab3;
public class BookController {
    private String name;
    private int year;
    private String author;
    private String status;

    public BookController(String name, int year, String author, String status) {
        this.name = name;
        this.year = year;
        this.author = author;
        this.status = status;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

}