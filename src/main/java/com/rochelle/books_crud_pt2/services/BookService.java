package com.rochelle.books_crud_pt2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rochelle.books_crud_pt2.models.Book;
import com.rochelle.books_crud_pt2.repositories.BookRepository;

// designate this as a @Service -> contains all our business logic
// the BookService uses the repository
// this makes a file a service in spring
// how to tell the service about the bookrepsitory that it can use -> autowired
@Service
public class BookService {
    // the connection to our Repository and the service
    // allows spring to access all the data in out bookrepository
    @Autowired BookRepository bookRepository;
    //^ CREATE
    // want to pass in a book -> create a varibale in java have to say what it is going to be 
    // book is a param 
    // Book is saying that this param is going to be a book object
    public void createBook(Book book) {
        // taking in whatever param gets passed in then pass it on to save
        bookRepository.save(book);
    }

    //^ READ ALL
    /* 
    -> this is where we put our business logic
    -> once connected to the BookRepository -> now have access to the BookRepository inside of our service
    -> now have access to this fineAll method 
    -> return a list of all my books 
    -> allows us to use the magic of the ORM
    */
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    //^ UPDATE


    //^ DELETE
}
