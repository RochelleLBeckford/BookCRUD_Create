<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Books</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
    <div class="container mt-5">
        <p>I really like these books</p>
        <table class="table table-hover border border-5">
            <tbody>
                <tr>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Pages</th>
                    <th>Description</th>
                    <!-- these are going to be my actions -> edit & delete -->
                    <th>Actions</th>
                </tr>
                    <!-- the list is working but now need to loop over it -->
                    <!-- <c:out value="${books}"/> -->
                    <!--
                    ~ Java equivalent of Jinja ~
                    -> take data from controller and have it render on my view
                    -> give it a value attribute
                    -> then what we want to render on page
                    -->
                    <!-- 
                        -> var is the variable for iteration -> the variable of iteration can be anything but the items have to be named after the array 
                        -> items is the artray name 
                        -> naming variable conventions -> want someone after you to look at your code and understand what you were trying to do 
                        -> make title an <a> tag so when click it all the info for that book will show 
                    -->
                    <c:forEach var="book" items="${books}">
                        <tr>
                            <td>
                                <!-- 
                                    ->want this to go to a page that will be /books/id 
                                    -> iteration is books so book.id
                                -->
                                <a href="/books/${book.id}">${book.title}</a>
                            </td>
                            <td>
                                ${book.author}
                            </td>
                            <td>
                                ${book.pages}
                            </td>
                            <td>
                                ${book.description}
                            </td>
                            <!--  
                                -> add'tl table data that will be my actions 
                                -> need to make route where link will go 
                                -> /books/edit/id
                            -->
                            <td class="d-flex gap-2">
                                <a class="btn btn-primary" href="/books/edit/${book.id}">Edit</a>
                                <!-- this is for the delete 
                                    -> we have to include the hidden input which is why the <form> tag is needed
                                    -> the work around if we want to use put
                                    -> must follow the restful routing 
                                    -> need to create a route for delete
                                    -> must create a a method for delete
                                -->
                                <form action="/books/${book.id}" method="post">
                                    <input type="hidden" name="_method" value="delete">
                                    <input class="btn btn-danger" type="submit" value="Delete">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
            </tbody>
        </table>
        <a class="btn btn-primary" href="/books/new">Add a Book</a>
    </div>
</body>
</html>
