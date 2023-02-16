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
    <div class="container d-flex justify-content-center border border-5 mt-5">
        <!-- <c:out value="${name}" ></c:out> -->
        <!-- Survey part -> Form -->
        <card>
            <card-body>
                <h1>Add a Book</h1>

                <!-- 
                    -> will send to where ever declared as action key
                    -> must create that route
                -->
                <form action="/books" method="POST">
                    <div>
                        <label>Title:</label>
                        <input type="text" class="form-control" name="title">
                    </div>

                    <div>
                        <label>Author:</label>
                        <input type="text" class="form-control" name="author">
                    </div>
                    
                    <div>
                        <label>Number of Pages:</label>
                        <input type="number" class="form-control" name="pages">
                    </div>

                    <div>
                        <label>Description:</label>
                        <!-- <input type="textera" name="description"> -->
                        <textarea name="description" class="form-control" id="description" cols="10" rows="3"></textarea>
                    </div>

                    <input type="submit" value="Add a New Book">
                </form>
            </card-body>
        </card>
    </div>
</body>
</html>