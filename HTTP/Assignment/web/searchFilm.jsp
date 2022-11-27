<%--
  Created by IntelliJ IDEA.
  User: Ryan Love
  Date: 17/12/2019
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<html>
<head>
</head>
<body>
<br/><br/>
<<form method="post" action="search">
    <table border="0" width="300" align="center" bgcolor="#e9fh">
        <tr><td colspan=2 style="font-size:12pt;" align="center">
            <h3>Search Details</h3></td></tr>
        <tr><td ><b>Title:</b></td>
            <td>: <input  type="text" name="title" id="title">
                <input type="button" name="JSON" id="JSON" value="JSON">
            </td></tr>
        <tr><td colspan=2 align="center">
            <input  type="submit" value="Search" ></td></tr>
    </table>
</form>

</body>
</html>
