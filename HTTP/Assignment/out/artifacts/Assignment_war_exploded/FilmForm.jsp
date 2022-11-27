<%--
  Created by IntelliJ IDEA.
  User: Ryan Love
  Date: 16/12/2019
  Time: 19:42
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
    <h2>
        <a href="${pageContext.request.contextPath}/create">Add New Film Entry</a>
        &nbsp;&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/Film">List All Film Entiies</a>

    </h2>
</center>
<div align="center">
    <c:if test="${film != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${film == null}">
        <form action="create" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${film != null}">
                            Edit Film
                        </c:if>
                        <c:if test="${film == null}">
                            Add New Film
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${film != null}">
                    <input type="hidden" name="id" value="<c:out value='${film.id}' />" />
                </c:if>
                <tr>
                    <th>ID: </th>
                    <td>
                        <input type="text" name="id" value="<c:out value='${film.id}' />"/>
                    </td>
                </tr>

                <tr>
                    <th>Title: </th>
                    <td>
                        <input type="text" name="title" value="<c:out value='${film.title}' />"/>
                    </td>
                </tr>
                <tr>
                    <th>Year: </th>
                    <td>
                        <input type="text" name="year" value="<c:out value='${film.year}' />"/>
                    </td>
                </tr>
                <tr>
                    <th>Director: </th>
                    <td>
                        <input type="text" name="director" value="<c:out value='${film.director}' />"/>
                    </td>
                </tr>
                <tr>
                    <th>Stars: </th>
                    <td>
                        <input type="text" name="stars" value="<c:out value='${film.stars}' />"/>
                    </td>
                </tr>
                <tr>
                    <th>Review: </th>
                    <td>
                        <input type="text" name="review" value="<c:out value='${film.review}' />"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>