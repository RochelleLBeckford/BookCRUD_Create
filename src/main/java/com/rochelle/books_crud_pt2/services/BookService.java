package com.rochelle.books_crud_pt2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rochelle.books_crud_pt2.models.Book;
import com.rochelle.books_crud_pt2.repositories.BookRepository;

// -> designate this as a @Service -> contains all our business logic
// -> the BookService uses the repository
// -> this makes a file a service in spring
// -> how to tell the service about the bookrepsitory that it can use -> autowired
// ~ -> all Business Logic goes here -> methods 
@Service
public class BookService {
    // -> the connection to our Repository and the service
    // -> allows spring to access all the data in out bookrepository
    @Autowired BookRepository bookRepository;
    //^ CREATE
    // -> want to pass in a book -> create a varibale in java have to say what it is going to be 
    // -> book is a param 
    // -> Book is saying that this param is going to be a book object
    public void createBook(Book book) {
        // -> taking in whatever param gets passed in then pass it on to save
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

    //^ READ ONE
    // -> now just need to call this in our controller
    // -> know which book you want by the id -> pass in Lond id
    public Book getOneBook(Long id) {
        // -> getting a book us e the optional type 
        Optional<Book> optionalBook = bookRepository.findById(id);
        // -> Java shorthand for if, else if statement 
        return optionalBook.orElse(null);
    }

    //^ UPDATE
    // -> method for update
    // controller talks to the service the servive talks to the repository
    public void updateBook(Book book) {
        /* 
        -> save -> get the same book from the database 
        -> fixing it and passing it back
        -> taking that book and resaving it to the modified version
        */
        bookRepository.save(book);
    }


    //^ DELETE
    public void deleteBook(Book book) {
        // controller talks to the service -> service talks to the repository
        bookRepository.delete(book);
    }
}
