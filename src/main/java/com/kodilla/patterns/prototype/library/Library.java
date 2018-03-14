package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Set;

public class Library extends Prototype {
    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return (Library) super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library libraryCopy = (Library) super.clone();
        libraryCopy.books = new HashSet<>();
        for (Book book : books) {
            libraryCopy.books.add(book);
        }
        return libraryCopy;
    }

    @Override
    public String toString() {
        String b = "Library : " + name + "\n";
        for (Book book : books) {
            b = b + book + "\n";
        }
        return b;
    }
}
