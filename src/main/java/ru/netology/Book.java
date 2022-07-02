package ru.netology;

public class Book extends Product {
    private String bookAuthor;

    public Book(int id, String name, int price, String bookAuthor) {
        super(id, name, price);
        this.bookAuthor = bookAuthor;
    }
}
