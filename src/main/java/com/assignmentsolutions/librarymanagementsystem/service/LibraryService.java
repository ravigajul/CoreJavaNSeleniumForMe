package com.assignmentsolutions.librarymanagementsystem.service;

import java.util.ArrayList;
import java.util.List;

import com.assignmentsolutions.librarymanagementsystem.exception.BookNotAvailableException;
import com.assignmentsolutions.librarymanagementsystem.model.Book;
import com.assignmentsolutions.librarymanagementsystem.model.Member;

public class LibraryService {
    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();

    // method to add book
    public void addBook(Book book) {
        books.add(book);
    }

    // method to add a member
    public void addMember(Member member) {
        members.add(member);
    }

    // Implement a method to issue a book to a member, which checks if the book is
    // available and marks it as issued.
    public void issueBook(String ISBN, String memberId) throws BookNotAvailableException {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                if (!book.isIssued()) {
                    book.setIssued(true);
                    System.out.println("Book issued to member: " + memberId);
                } else {
                    throw new BookNotAvailableException("Book is already issued");
                }
            }
        }
        throw new BookNotAvailableException("Book not found.");
    }

    // Method to return a book
    public void returnBook(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                if(book.isIssued()){
                    book.setIssued(false);
                    System.out.println("Book returned");
                }else{
                    System.out.println("Book was not issued");
                }              
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Method to list all books
    public void listBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
