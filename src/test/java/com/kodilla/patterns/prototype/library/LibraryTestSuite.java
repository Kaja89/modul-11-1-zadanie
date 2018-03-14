package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

public class LibraryTestSuite {
    @Test
    public void testGetBooks() {
        //Given
        Library library = new Library("Library number 1");
        Book book1 = new Book("Ogniem i mieczem", "Henryk Sienkiewicz", 1980, 1, 12);
        Book book2 = new Book("Potop", "Henryk Sienkiewicz", 1982, 3, 14);
        Book book3 = new Book("Pan Wołodyjowski", "Henryk Sienkiewicz", 1988, 5, 4);
        Book book4 = new Book("Pan Tadeusz", "Adam Mickiewicz", 2000, 12, 22);

        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);
        library.getBooks().add(book4);

        Library shallowCopy = null;
        try {
            shallowCopy = library.shallowCopy();
            shallowCopy.setName("Library number 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepCopy = null;
        try {
            deepCopy = library.deepCopy();
            deepCopy.setName("Library number 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        library.getBooks().remove(book3);

        //Then
        System.out.println(library);
        System.out.println(shallowCopy);
        System.out.println(deepCopy);
        Assert.assertEquals(3, library.getBooks().size());
        Assert.assertEquals(3, shallowCopy.getBooks().size());
        Assert.assertEquals(4, deepCopy.getBooks().size());
    }
}
