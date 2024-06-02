package data;

import books.Book;

import java.util.ArrayList;

public abstract class User {
    private String nim;

    public User(String nim) {
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }

    public abstract void displayBooks(Book[] bookList);

    public abstract void displayBooks(ArrayList<Book> bookList);


}

