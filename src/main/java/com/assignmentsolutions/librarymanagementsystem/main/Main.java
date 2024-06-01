package com.assignmentsolutions.librarymanagementsystem.main;

import com.assignmentsolutions.librarymanagementsystem.exception.BookNotAvailableException;
import com.assignmentsolutions.librarymanagementsystem.model.Book;
import com.assignmentsolutions.librarymanagementsystem.model.Member;
import com.assignmentsolutions.librarymanagementsystem.service.LibraryService;

public class Main {
    public static void main(String[] args) {
        LibraryService libraryService = new LibraryService();

        // add books to Library
        libraryService.addBook(new Book("Game of Thrones", "George RR Martin", "12345"));
        libraryService.addBook(new Book("Learning Java", "Herbet Sheild", "67891"));

        // add members to library
        libraryService.addMember(new Member("RaviGajul", "M01"));
        libraryService.addMember(new Member("StevenLim", "M02"));

        // List all the books
        libraryService.listBooks();

        // Issue a book to the member
        try {
            libraryService.issueBook("12345", "M01");

        } catch (BookNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        // list the books
        libraryService.listBooks();

        // issue the same book again
        try {
            libraryService.issueBook("12345", "M01");
        } catch (BookNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        // return the book
        libraryService.returnBook("12345");

        // return the same book again
        libraryService.returnBook("12345");

        // list all the books again to see the updated status
        libraryService.listBooks();
    }
}
