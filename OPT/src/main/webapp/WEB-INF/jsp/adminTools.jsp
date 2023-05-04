<!--The form tag will allow you to grab information 
from the form and send it to the controller-->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- allows you to use c tags, tags that do things like if statements and loops-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- allows for java stuff on the page-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/css/main.css">
    <link rel="stylesheet" href="/css/flex.css">
    <link rel="stylesheet" href="/css/adminTools.css">
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
    <!--Creating Reservations, Creating, Places, Creating Amenities-->
    <div class="main-content flex-row">
        <div class="flex-col">
            <div class="flex-row justify-center">
                <h1>Welcome Admin, Choose an Option</h1>
            </div>
            <div class="flex-row justify-center">
                <a class="link-button" href="/reservation">See All Reservations</a>
                <a class="link-button" href="/adminPlaces">Create and Update Places</a>
                <a class="link-button" href="/amenity">Create and Update Amenities</a>
            </div>
        </div>
    </div>
</body>
</html>