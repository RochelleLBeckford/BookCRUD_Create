package com.rochelle.books_crud_pt2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rochelle.books_crud_pt2.models.Book;
import com.rochelle.books_crud_pt2.repositories.BookRepository;

// designate this as a @Service
// the BookService uses the repository
@Service
public class BookService {
    // connection to our Repository
    @Autowired BookRepository bookRepository;
    //^ CREATE

    //^ READ ALL
    /* 
    -> this is where we put our business logic
    -> once connected to the BookRepository -> now have access to the BookRepository inside of our service
    -> now have access to this fineAll method 
    -> return a list of all my books 
    */
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    //^ UPDATE


    //^ DELETE
}
