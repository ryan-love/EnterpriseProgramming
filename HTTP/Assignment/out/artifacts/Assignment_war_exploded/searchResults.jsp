<%@ page import="java.util.*" %>
<%@ page import="model.Film" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
</head>
<body>
<table width="700px" align="center"
       style="border:1px solid #000000;">
    <tr>
        <td colspan=4 align="center"
            style="background-color:teal">
            <b>Employee Records</b></td>
    </tr>
    <tr style="background-color:lightgrey;">
        <td><b>EID</b></td>
        <td><b>NAME</b></td>
        <td><b>SALARY</b></td>
        <td><b>ADDRESS</b></td>
    </tr>
 <%ArrayList<Film> flm = (ArrayList<Film>) request.getAttribute("film");%>
   <%= flm %>
    <%String json = (String)request.getAttribute("json"); %>
    <%= json %>

            </td>
        </tr>



    <tr>
        <td colspan=4 align="center"
            style="background-color:#eeffee"><b>No Record Found..</b></td>
    </tr>

</table>
</body>
</html>