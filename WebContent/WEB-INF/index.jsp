<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Great Number Game</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/index.css">
    </head>
    <body>
        <div class="jumbotron">
            <h1 class="display-4 text-center">Welcome to the Great Number Game!</h1>
            <p class="lead text-center">I am thinking of a number between 1 and 100</p>
            <p class="lead text-center">Take a guess!</p>
            <hr class="my-4">
            	<c:set var = "result" value = "${result}"/>
            	<c:set var = "higher" value = "higher"/>
            	<c:set var = "lower" value = "lower"/>
            	<c:set var = "success" value = "success"/>
                <c:if test = "${result == higher}">
                    <div class="incorrect w-25 h-25"> 
                        <p></p>
                        <h1 class="">Too High!</h1>
                    </div>
                </c:if>                
                <c:if test = "${result == lower}">
                    <div class="incorrect w-25 h-25"> 
                        <h1 class="align-middle">Too Low!</h1>
                    </div>
                </c:if> 
            <c:if test = "${result == success}">
                <div class="correct w-25 h-25">
                    <h1 class="align-middle"><c:out value = "${randNum}"/> was the number!</h1>
                    <form action='Destroy' method='POST'> 
                        <input class="btn btn-primary btn-sm btn-light m-1" type="submit" value="Play Again?">
                    </form>
                </div>
            </c:if>
            <c:if test = "${result != success}">
                <div class="text-center m-3">
                    <form action='Home' method='POST'>
                        <input type="text" id="guess" class="form_field" placeholder="Guess the #" name="guess">
                        <input class="btn btn-primary btn-sm btn-success" type="submit" value="Submit">
                    </form>
                </div>
            </c:if>
        </div>
	</body>
</html>