<%--
  Created by IntelliJ IDEA.
  User: Ryan Love
  Date: 21/12/2019
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@page import="javax.xml.bind.*" %>
<%@page import="java.util.List" %>
<%@page import="model.FilmtoList" %>
<%@page import="model.Film" %>
<%@ page import="model.FilmDAO" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%
    List<Film> film = (List<Film>) request.getAttribute("allFilms");
    List<Film> search = (List<Film>) request.getAttribute("search");
    FilmtoList ftl = new FilmtoList();
    if (film != null){
        ftl.setFilms(film);
    }

    if(search != null) {
        ftl.setFilms(search);
    }


try{
    JAXBContext context = JAXBContext.newInstance(FilmtoList.class);
    Marshaller m = context.createMarshaller();
    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        m.marshal(ftl, out);

} catch (JAXBException e){
 System.out.println(e);
}

%>