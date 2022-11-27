<%--
  Created by IntelliJ IDEA.
  User: Ryan Love
  Date: 21/12/2019
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="model.Film" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="model.FilmtoList" %>

<% List<Film> films = (List<Film>) request.getAttribute("allFilms");
    List<Film> search =(List<Film>) request.getAttribute("search");


    if(films != null) {
        for (int i = 0; i < films.size(); i++) {
           out.println(films.get(i));
        }
    } else {

    }
    if (search != null) {
        for (int i = 0; i < search.size(); i++) {
            out.println(search.get(i));
        }

    } else {

    }



//out.println(Arrays.toString(films.toArray()));
//out.println(Arrays.toString(search.toArray()));

%>


