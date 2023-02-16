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
        <p>I really like the book</p>
        <table class="table table-hover border border-5">
            <tbody>
                <tr>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Pages</th>
                    <th>Description</th>
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
                    -->
                    <c:forEach var="book" items="${books}">
                        <tr>
                            <td>
                                ${book.title}
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
                        </tr>
                    </c:forEach>
            </tbody>
        </table>
        <a class="btn btn-primary" href="/books/new">Add a Book</a>
    </div>
</body>
</html>
