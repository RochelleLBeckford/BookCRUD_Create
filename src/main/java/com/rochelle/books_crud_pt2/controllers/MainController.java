package com.rochelle.books_crud_pt2.controllers;

import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import com.rochelle.books_crud_pt2.models.Book;
import com.rochelle.books_crud_pt2.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;


// to make this a controller need the @Controller anotation
@Controller
public class MainController {
    // ~ Now can go into controller and do this for now b/c do not have databases yet ~
    // this will be a list of all the books
    // import ArrayList -> import java.util.ArrayList;
            // import POJO judt made -> import com.rochelle.books.models.Book;
    //? instead of storing books in an arraylist -> connect to my service
    
    // ArrayList<Book> books = new ArrayList<>();
    // now when create book still setting it to session but will also create an instance of that book -> create a book object 
    
    // the last step is the controller and it uses the service
    // now will get all my books from my DB -> go to DB and create some 
    // now DB has some books in it -> use my service to access my books 
    // connects the service to the controller
    @Autowired BookService bookService;


    //CRUD -> create, read, update, delete
    //& CREATE &
    /* 
    ? want to create a book -> need 2 routes 
    -> one for the submission 
    -> one for the redirect  
    */
    @RequestMapping("/books/new") 
    public String newBook(){
        return "new.jsp";
    } 

    // @RequestMapping(value = "/books", method=RequestMethod.POST)
    // public String createBook() {
    //     return "redirect:/";
    // }
    //? Can change from RequestMapping to PostMapping which is a shorter method -> less to rememeber
    // it is the same as the above
    // this is the route that handles my book
    @PostMapping(value = "/books")
    public String createBook(
        //~ when go to form and fill out book, how to access data ~
        // -> now have access to this data coming into my form
        @RequestParam("title") String title,
        @RequestParam("author") String author,
        @RequestParam("pages") Integer pages,
        @RequestParam("description") String description,
        HttpSession session
    ) {
        // create a new instance of the class
                        // pass in all the attributes for the book
        // Book book = new Book(title, author, pages, description);
        // // System.out.println(title);
        // // -> print out the book it gets me
        // // System.out.println(book);
        // // -> see the title of the book 
        // System.out.println(book.getTitle());
        // //~ now want to add session ~
        //     // -> import HttpSession
        //     // -> then set session to all attributes -> session.setAttributes
        // // -> add the books to my array -> books is going to be an array of all the books they give me
        // books.add(book);
        // session.setAttribute("title", title);
        // session.setAttribute("author", author);
        // session.setAttribute("pages", pages);
        // session.setAttribute("description", description);
        return "redirect:/";
    }


    
    //? For read -> read one and read all 
    //& READ ALL & 
    // -> usually root of app is the read all 
    /* 
    ~ on index page ~
    -> want to loop through on the index page and whatever books are in my list of books i want to store them on the index page
    -> want to have a table of all the data
    -> want to store the books I have created
    -> send my whole books array and send them to my index page
    -> take array of books and send down to my index.jsp -> need to import model to send data to my template -> import org.springframework.ui.Model;
    -> to see if this works go to index page andn <c:out />  the array of books 
    */
    @RequestMapping("/")
    public String index(Model model) {
        // -> pass down books and call it books
        // to get all my books -> say it is going to be a list of books
        List<Book> books = bookService.allBooks();
        // to see what we get
        System.out.println(books); // books i created in the DB show in ther terminal 
        // to get them on the frontend -> from the controller to the view
        model.addAttribute("books", books);
        return "index.jsp";
    }


    //& READ ONE & 
    /* 
    -> when do this show.jsp should have access to one book at the specified index
    -> have one book object that is being passed down to jsp
    attributes can be individual strings, they can be books, they can be whatever you want to pass down
    */
    @RequestMapping("/books/1")
    public String show(Model model) {
        // model.addAttribute("books", books.get(1));
        // model.addAttribute("books", books);
        return "show.jsp";
    }
    
    //& UPDATE & 
    
    
    //& DELETE & 

}
