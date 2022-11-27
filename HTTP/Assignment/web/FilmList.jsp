<%--
  Created by IntelliJ IDEA.
  User: Ryan Love
  Date: 16/12/2019
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>FilmDB</title>
</head>
<body>
<center>
    <h1>Film</h1>
    <h2>
        <a href="${pageContext.request.contextPath}/show">Add New Film Entry</a>
        &nbsp;&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/GUI">List All Film Entiies</a>

    </h2>
</center>
<div>
    <table border="1" cellpadding="10">
        <h2>List of All Films</h2>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Year</th>
            <th>Director</th>
            <th>Stars</th>
            <th>Review</th>
            <th>Operations</th>
        </tr>
        <c:forEach var="film" items="${allFilms}">
            <tr>
                <td><c:out value="${film.id}" /></td>
                <td><c:out value="${film.title}" /></td>
                <td><c:out value="${film.year}" /></td>
                <td><c:out value="${film.director}" /></td>
                <td><c:out value="${film.stars}" /></td>
                <td><c:out value="${film.review}" /></td>
                <td>
                    <a href="${pageContext.request.contextPath}/edit?id=<c:out value='${film.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="${pageContext.request.contextPath}/delete?id=<c:out value='${film.id}' />">Delete</a>

                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>