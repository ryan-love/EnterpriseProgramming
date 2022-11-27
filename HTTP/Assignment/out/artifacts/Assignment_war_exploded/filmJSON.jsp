<%@ page import="model.Film" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="java.util.List" %>
<%@ page import="com.google.gson.GsonBuilder" %>
<%@ page import="java.io.IOException" %>


<%
    List<Film> films = (List<Film>) request.getAttribute("allFilms");
    List<Film> search =(List<Film>) request.getAttribute("search");

    GsonBuilder gsonB = new GsonBuilder().setPrettyPrinting().setPrettyPrinting();
Gson gson = gsonB.create();

if(films != null){
    String json;
    json =gson.toJson(films);
    out.println(json);
}

if(search != null){
    String jSearch;
    jSearch = gson.toJson(search);
    out.println(jSearch);
}



%>

