package com.rochelle.books_crud_pt2.repositories;

// -> sometimes it knows how to import this sometimes it will not work 
import org.springframework.data.repository.CrudRepository;
// connect my book from models
import com.rochelle.books_crud_pt2.models.Book;
import java.util.List;


// this is where we connect to the ORM -> will be an interface
//BookRepository is the ORM that connects us to our DB
// there is no save method -> it has it in virtue of the CrudRepository
public interface BookRepository extends CrudRepository<Book, Long> {
    // want to be able to find all books -> call find all method want to return a list of books
    //No SQL no DB -> if want to get all my books now I can
    List<Book> findAll();
}
