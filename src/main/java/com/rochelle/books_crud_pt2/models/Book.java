package com.rochelle.books_crud_pt2.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//?  In java -> these 4 lines create our table in MySQL -> @Entity, @Table, @Id, @GeneratedValue -> the beauty of ORM
// 4 lines of codes saves us from doing all that SQL or even the ERD Diagram

//? Book.java is only 1 aspect of my model -> 2 other aspects/ sections of the model
// Actual connection to the database is -> we have different layers -> repository -> services -> controller
// repositories folder -> BookRepository.java file will be an interface
// services -> BookService.java file will be the connection

/* 
~ @Entity is an ORM [object relational mapper]-> will write the SQL for me ~
-> will allow us to keep track of our book as an element of our DN -> a table in our DB
-> Entity marks this as something the JPA will keep track of
*/
@Entity
//~ -> make a table -> @Table and set the name of the table -> name ="books_crud" ~
// the @ annotation is special -> this will magically make our table
@Table(name="books_crud_pt2")

public class Book {
    // need to set up the id to keep track of the title, author, pages, description
    // creates the id column in our DB -> keep track of the id we establish for the book that we got
    @Id
    // what allows us to auto increment our ids
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // these annotations modify the property of our book
    private Long id;
    // the books attributes must be provided for the imports to work -> title, author, pages, description 
    // now if look at schema will see all of these attributes below in their own column
    private String title;
    private String author;
    private Integer pages;

    
    private String description;

    // ~ inorder to be able to access these attributes and in order to make new books ~
    // -> need constructor
    // -> generate an empty constructor
    // -> needed to be a Java Bean -> POJO that spring uses to keep tracl of everything
    public Book() {
    }

    // ~ generate a constructor w/ all of the fields ~
    public Book(String title, String author, Integer pages, String description) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.description = description;
    }

    
    /* 
    ~ since private need to access them -> getters and setters ~ 
    ~ POJO -> Plain old java object ~
        -> specific format for creating objects in java
        -> it has to have private attributes 
        -> it has to have a constructor that takes all the params
        -> it has to have getters and setters
        -> it has to have serialized
    -> spring will be able to use it w/o any other set up or config from us -> will be able to access our programs 
    ~ Now can go into controller ~
    */
    // needed to be a Java Been 
    // added these id getter and setters so can access private Long id -> now need to create a route for this 
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPages() {
        return this.pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

