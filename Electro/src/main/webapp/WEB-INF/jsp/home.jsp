<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Allows you to use c tags, tags that do things like if statements and loops -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Allows for java stuff on the page -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/css/main.css">
    <link rel="stylesheet" href="/css/home.css">
    <link rel="stylesheet" href="/css/flex.css">
</head>
<body class="flex-col">
    <c:choose>
        <c:when test="${user != null}">
            <div class="header flex-row">
                <div class="header-link">Hello ${user.getName()}</div>
                <a href="/" class="header-link">Home</a>
                <a href="/logout" class="header-link">Log Out</a>
            </div>
        </c:when>
        <c:otherwise>
            <div class="header flex-row">
                <a href="/sign-up" class="header-link">Sign Up</a>
                <a href="/" class="header-link">Home</a>
                <a href="/sign-in" class="header-link">Sign In</a>
            </div>
        </c:otherwise>
    </c:choose>
    <div class="main-page flex-row">
        <!-- if im logged in show my name, if not, show hi mom -->
        <c:if test="${user != null}">
           <div class="spacing"> Welcome Sparky</div>
        </c:if>
        <!-- c:choose works like an if else, 
            when is the if statement, otherwise is the else -->
        <c:choose>
            <c:when test="${user != null}">
                <a class="spacing" href="/search">Spark Your Search!</a>
            </c:when>
            <c:otherwise>
                A Shock to Your System
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>